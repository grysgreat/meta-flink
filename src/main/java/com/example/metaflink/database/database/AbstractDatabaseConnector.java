/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.metaflink.database.database;






import com.example.metaflink.database.config.*;
import com.example.metaflink.database.constants.ConnectorConstants;
import com.example.metaflink.database.database.model.Result;
import com.example.metaflink.database.enums.ConnectorEnum;
import com.example.metaflink.database.enums.OperationEnum;
import com.example.metaflink.database.enums.SetterEnum;
import com.example.metaflink.database.enums.SqlBuilderEnum;
import com.example.metaflink.database.exception.ConnectorException;
import com.example.metaflink.database.utils.CollectionUtils;
import com.example.metaflink.util.DataBaseUtil;
import com.example.metaflink.database.utils.JDBCUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author binghe
 * @version 1.0.0
 * @description 抽象数据库连接器
 */
public abstract class AbstractDatabaseConnector implements Database{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    protected abstract String getQueryTablesSql(DatabaseConfig config);

    @Override
    public boolean isAlive(ConnectorConfig config) {
        DatabaseConfig cfg = (DatabaseConfig) config;
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection(cfg.getDriverClassName(), cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            logger.error("Failed to connect:{}", cfg.getUrl(), e.getMessage());
        } finally {
            JDBCUtils.close(connection);
        }
        return null != connection;
    }

    @Override
    public List<String> getTable(ConnectorConfig config) {
        List<String> tables = new ArrayList<>();
        DatabaseConfig databaseConfig = (DatabaseConfig) config;
        JdbcTemplate jdbcTemplate = null;
        try {
            jdbcTemplate = getJdbcTemplate(databaseConfig);
            String sql = getQueryTablesSql(databaseConfig);
            tables = jdbcTemplate.queryForList(sql, String.class);
        } catch (Exception e) {
            logger.error("getTable failed", e.getMessage());
        } finally {
            // 释放连接
            this.close(jdbcTemplate);
        }
        return tables;
    }

    @Override
    public MetaInfo getMetaInfo(ConnectorConfig config, String tableName) {
        DatabaseConfig cfg = (DatabaseConfig) config;
        JdbcTemplate jdbcTemplate = null;
        MetaInfo metaInfo = null;
        try {
            jdbcTemplate = getJdbcTemplate(cfg);
            String quotation = buildSqlWithQuotation();
            String metaSql = new StringBuilder().append("select * from ").append(quotation).append(tableName).append(quotation).toString();
            metaSql = this.getMetaSql(metaSql, cfg.getConnectorType());
            metaInfo = DataBaseUtil.getMetaInfo(jdbcTemplate, metaSql, tableName);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            // 释放连接
            this.close(jdbcTemplate);
        }
        return metaInfo;
    }


    /**
     *  优化metaSql的查询，使其只查询一条数据
     */
    private String getMetaSql(String metaSql, String connectorType) {
        if(StringUtils.isEmpty(connectorType)){
            return metaSql;
        }
        if (ConnectorEnum.ORACLE.getType().equalsIgnoreCase(connectorType)){  //Oracle数据库
            metaSql = metaSql.concat(" where rownum = 1 ");
        }else if(ConnectorEnum.MYSQL.getType().equalsIgnoreCase(connectorType)){  //MySQL数据库
            metaSql = metaSql.concat(" limit 1 ");
        }else if(ConnectorEnum.DQL_MYSQL.getType().equalsIgnoreCase(connectorType)){ //MySQL数据库
            metaSql = metaSql.concat(" limit 1 ");
        }else if(ConnectorEnum.DQL_ORACLE.getType().equalsIgnoreCase(connectorType)){ //Oracle数据库
            metaSql = metaSql.concat(" where rownum = 1 ");
        }

        return metaSql;
    }

    @Override
    public Map<String, String> getSourceCommand(CommandConfig commandConfig) {
        // 获取过滤SQL
        List<Filter> filter = commandConfig.getFilter();
        String queryFilterSql = getQueryFilterSql(filter);

        // 获取查询SQL
        Table table = commandConfig.getTable();
        Map<String, String> map = new HashMap<>();

        String query = SqlBuilderEnum.QUERY.getName();
        map.put(query, buildSql(query, table, queryFilterSql));

        // 获取查询总数SQL
        StringBuilder queryCount = new StringBuilder();
        String quotation = buildSqlWithQuotation();
        queryCount.append("select count(*) from ").append(quotation).append(table.getName()).append(quotation);
        if (StringUtils.isNotBlank(queryFilterSql)) {
            queryCount.append(queryFilterSql);
        }
        map.put(ConnectorConstants.OPERTION_QUERY_COUNT, queryCount.toString());
        return map;
    }

    @Override
    public Map<String, String> getTargetCommand(CommandConfig commandConfig) {
        // 获取增删改SQL
        Map<String, String> map = new HashMap<>();
        Table table = commandConfig.getTable();

        String insert = SqlBuilderEnum.INSERT.getName();
        map.put(insert, buildSql(insert, table, null));

        String update = SqlBuilderEnum.UPDATE.getName();
        map.put(update, buildSql(update, table, null));

        String delete = SqlBuilderEnum.DELETE.getName();
        map.put(delete, buildSql(delete, table, null));
        return map;
    }

    @Override
    public long getCount(ConnectorConfig config, Map<String, String> command) {
        // 1、获取select SQL
        String queryCountSql = command.get(ConnectorConstants.OPERTION_QUERY_COUNT);
        Assert.hasText(queryCountSql, "查询总数语句不能为空.");

        DatabaseConfig cfg = (DatabaseConfig) config;
        JdbcTemplate jdbcTemplate = null;
        try {
            // 2、获取连接
            jdbcTemplate = getJdbcTemplate(cfg);

            // 3、返回结果集
            return jdbcTemplate.queryForObject(queryCountSql, Long.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ConnectorException(e.getMessage());
        } finally {
            // 释放连接
            this.close(jdbcTemplate);
        }
    }

    @Override
    public Result reader(ConnectorConfig config, Map<String, String> command, List<Object> args, int pageIndex, int pageSize) {
        // 1、获取select SQL
        //2、foreach循环
        //获取key + value
        for (Object key : command.keySet()) {
            String value = command.get(key);
            System.out.println(key + " : " + value);
        }
        String querySql = command.get(SqlBuilderEnum.QUERY.getName());
        Assert.hasText(querySql, "查询语句不能为空.");

        DatabaseConfig cfg = (DatabaseConfig) config;
        JdbcTemplate jdbcTemplate = null;
        try {
            // 2、获取连接
            jdbcTemplate = getJdbcTemplate(cfg);

            // 3、设置参数
            Collections.addAll(args, getPageArgs(pageIndex, pageSize));

            // 4、执行SQL
            System.out.println("querySQL1:"+querySql);
            List<Map<String, Object>> list = jdbcTemplate.queryForList(querySql, args.toArray());

            // 5、返回结果集
            return new Result(list);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ConnectorException(e.getMessage());
        } finally {
            // 释放连接
            this.close(jdbcTemplate);
        }
    }

    @Override
    public Result writer(ConnectorConfig config, Map<String, String> command, List<Field> fields, List<Map<String, Object>> data) {
        // 1、获取select SQL
        String insertSql = command.get(SqlBuilderEnum.INSERT.getName());
        Assert.hasText(insertSql, "插入语句不能为空.");
        if (CollectionUtils.isEmpty(fields)) {
            logger.error("writer fields can not be empty.");
            throw new ConnectorException("writer fields can not be empty.");
        }
        if (CollectionUtils.isEmpty(data)) {
            logger.error("writer data can not be empty.");
            throw new ConnectorException("writer data can not be empty.");
        }
        final int size = data.size();
        final int fSize = fields.size();

        DatabaseConfig cfg = (DatabaseConfig) config;
        JdbcTemplate jdbcTemplate = null;
        Result result = new Result();
        try {
            // 2、获取连接
            jdbcTemplate = getJdbcTemplate(cfg);

            // 3、设置参数
            jdbcTemplate.batchUpdate(insertSql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    batchRowsSetter(preparedStatement, fields, fSize, data.get(i));
                }

                @Override
                public int getBatchSize() {
                    return size;
                }
            });

        } catch (Exception e) {
            // 记录错误数据
            result.getFailData().addAll(data);
            result.getFail().set(size);
            result.getError().append(e.getMessage()).append("\r\n");
            logger.error(e.getMessage());
        } finally {
            // 释放连接
            this.close(jdbcTemplate);
        }
        return result;
    }

    @Override
    public Result writer(ConnectorConfig config, List<Field> fields, Map<String, String> command, String event, Map<String, Object> data) {
        // 1、获取 SQL
        String sql = command.get(event);
        Assert.hasText(sql, "执行语句不能为空.");
        if (CollectionUtils.isEmpty(data) || CollectionUtils.isEmpty(fields)) {
            logger.error("writer data can not be empty.");
            throw new ConnectorException("writer data can not be empty.");
        }

        // Update / Delete
        if (StringUtils.equals(ConnectorConstants.OPERTION_UPDATE, event)) {
            // update attrs by id
            List<Field> pkList = fields.stream().filter((f) -> f != null && f.isPk()).collect(Collectors.toList());
            fields.add(pkList.get(0));
        } else if (StringUtils.equals(ConnectorConstants.OPERTION_DELETE, event)) {
            // delete by id
            List<Field> pkList = fields.stream().filter(f -> f.isPk()).collect(Collectors.toList());
            fields.clear();
            fields.add(pkList.get(0));
        }

        int size = fields.size();

        DatabaseConfig cfg = (DatabaseConfig) config;
        JdbcTemplate jdbcTemplate = null;
        Result result = new Result();
        try {
            // 2、获取连接
            jdbcTemplate = getJdbcTemplate(cfg);

            // 3、设置参数
            int update = jdbcTemplate.update(sql, (ps) -> {
                Field f = null;
                for (int i = 0; i < size; i++) {
                    f = fields.get(i);
                    SetterEnum.getSetter(f.getType()).set(ps, i + 1, f.getType(), data.get(f.getName()));
                }
            });
            if (0 == update) {
                throw new ConnectorException(String.format("执行%s操作失败, 数据不存在", event));
            }
        } catch (Exception e) {
            // 记录错误数据
            result.getFailData().add(data);
            result.getFail().set(1);
            result.getError().append(e.getMessage()).append("\r\n");
            logger.error(e.getMessage());
        } finally {
            // 释放连接
            this.close(jdbcTemplate);
        }
        return result;
    }

    @Override
    public JdbcTemplate getJdbcTemplate(DatabaseConfig config) {
        return DataBaseUtil.getJdbcTemplate(config);
    }

    @Override
    public void close(JdbcTemplate jdbcTemplate) {
        try {
            DataBaseUtil.close(jdbcTemplate);
        } catch (SQLException e) {
            logger.error("Close jdbcTemplate failed: {}", e.getMessage());
        }
    }

    /**
     * 获取DQL表信息
     *
     * @param config
     * @return
     */
    protected List<String> getDqlTable(ConnectorConfig config) {
        MetaInfo metaInfo = getDqlMetaInfo(config);
        Assert.notNull(metaInfo, "SQL解析异常.");
        DatabaseConfig cfg = (DatabaseConfig) config;
        return Arrays.asList(cfg.getSql());
    }

    /**
     * 获取DQL元信息
     *
     * @param config
     * @return
     */
    protected MetaInfo getDqlMetaInfo(ConnectorConfig config) {
        DatabaseConfig cfg = (DatabaseConfig) config;
        JdbcTemplate jdbcTemplate = null;
        MetaInfo metaInfo = null;
        try {
            jdbcTemplate = getJdbcTemplate(cfg);
            metaInfo = DataBaseUtil.getMetaInfo(jdbcTemplate, cfg.getSql(), null);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            // 释放连接
            this.close(jdbcTemplate);
        }
        return metaInfo;
    }

    /**
     * 获取DQL源配置
     *
     * @param commandConfig
     * @param tableLabel
     * @return
     */
    protected Map<String, String> getDqlSourceCommand(CommandConfig commandConfig, String tableLabel) {
        // 获取过滤SQL
        List<Filter> filter = commandConfig.getFilter();
        String queryFilterSql = getQueryFilterSql(filter);

        // 获取查询SQL
        Table table = commandConfig.getTable();
        Map<String, String> map = new HashMap<>();
        String querySql = table.getName();

        // 存在条件
        if (StringUtils.isNotBlank(queryFilterSql)) {
            querySql += queryFilterSql;
        }
        map.put(SqlBuilderEnum.QUERY.getName(), querySql);

        // 获取查询总数SQL
        StringBuilder queryCount = new StringBuilder();
        queryCount.append("select count(*) from (").append(table.getName()).append(")").append(tableLabel);
        if (StringUtils.isNotBlank(queryFilterSql)) {
            queryCount.append(queryFilterSql);
        }
        map.put(ConnectorConstants.OPERTION_QUERY_COUNT, queryCount.toString());
        return map;
    }

    /**
     * 查询语句表名和字段带上引号（默认不加）
     *
     * @return
     */
    protected String buildSqlWithQuotation() {
        return "";
    }

    /**
     * 获取查询条件SQL
     *
     * @param filter
     * @return
     */
    private String getQueryFilterSql(List<Filter> filter) {
        if (CollectionUtils.isEmpty(filter)) {
            return "";
        }
        // 过滤条件SQL
        StringBuilder condition = new StringBuilder();

        // 拼接并且SQL
        String filterSql = getFilterSql(filter);
        // 如果Add条件存在
        if (StringUtils.isNotBlank(filterSql)) {
            condition.append(filterSql);
        }

        // 拼接或者SQL
        String orSql = getFilterSql(OperationEnum.OR.getName(), filter);
        // 如果Or条件和Add条件都存在
        if (StringUtils.isNotBlank(orSql) && StringUtils.isNotBlank(filterSql)) {
            condition.append(" OR ").append(orSql);
        }

        // 如果有条件加上 WHERE
        StringBuilder sql = new StringBuilder();
        if (StringUtils.isNotBlank(condition.toString())) {
            // WHERE (USER.USERNAME = 'zhangsan' AND USER.AGE='20') OR (USER.TEL='18299996666')
            sql.insert(0, " WHERE ").append(condition);
        }
        return sql.toString();
    }


    /**
     * 将条件列表转化为条件SQL语句，条件顺序与页面配置的条件顺序一致
     * @param filter 条件列表
     * @return 条件SQL语句  aaa = aaa and bbb = bbb or ccc = ccc and ddd = ddd
     */
    private String getFilterSql(List<Filter> filter) {
        if (CollectionUtils.isEmpty(filter)) {
            return "";
        }

        int size = filter.size();
        StringBuilder sql = new StringBuilder();
        String quotation = buildSqlWithQuotation();
        Filter currentFilter = filter.get(0);
        //第一个条件数据不需加连接符
        sql.append(quotation).append(currentFilter.getName()).append(quotation).append(currentFilter.getFilter()).append("'").append(currentFilter.getValue()).append("' ");
        //从第二个条件数据开始循环
        for (int i = 1; i < size; i++) {
            currentFilter = filter.get(i);
            sql.append(" ").append(currentFilter.getOperation()).append(" ");
            // "USER" = 'zhangsan'
            sql.append(quotation).append(currentFilter.getName()).append(quotation).append(currentFilter.getFilter()).append("'").append(currentFilter.getValue()).append("'");
        }
        return sql.toString();
    }

    /**
     * 根据过滤条件获取查询SQL
     *
     * @param queryOperator and/or
     * @param filter
     * @return
     */
    private String getFilterSql(String queryOperator, List<Filter> filter) {
        List<Filter> list = filter.stream().filter(f -> StringUtils.equals(f.getOperation(), queryOperator)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }

        int size = list.size();
        int end = size - 1;
        StringBuilder sql = new StringBuilder();
        sql.append("(");
        Filter c = null;
        String quotation = buildSqlWithQuotation();
        for (int i = 0; i < size; i++) {
            c = list.get(i);
            // "USER" = 'zhangsan'
            sql.append(quotation).append(c.getName()).append(quotation).append(c.getFilter()).append("'").append(c.getValue()).append("'");
            if (i < end) {
                sql.append(" ").append(queryOperator).append(" ");
            }
        }
        sql.append(")");
        return sql.toString();
    }

    /**
     * 获取查询SQL
     *
     * @param type           {@link SqlBuilderEnum}
     * @param table
     * @param queryFilterSQL
     * @return
     */
    private String buildSql(String type, Table table, String queryFilterSQL) {
        if (null == table) {
            logger.error("Table can not be null.");
            throw new ConnectorException("Table can not be null.");
        }
        List<Field> column = table.getColumn();
        if (CollectionUtils.isEmpty(column)) {
            logger.error("Table column can not be empty.");
            throw new ConnectorException("Table column can not be empty.");
        }
        // 获取主键
        String pk = null;
        // 去掉重复的查询字段
        List<String> filedNames = new ArrayList<>();
        for (Field c : column) {
            if (c.isPk()) {
                pk = c.getName();
            }
            String name = c.getName();
            // 如果没有重复
            if (StringUtils.isNotBlank(name) && !filedNames.contains(name)) {
                filedNames.add(name);
            }
        }
        if (CollectionUtils.isEmpty(filedNames)) {
            logger.error("The filedNames can not be empty.");
            throw new ConnectorException("The filedNames can not be empty.");
        }
        String tableName = table.getName();
        if (StringUtils.isBlank(tableName)) {
            logger.error("Table name can not be empty.");
            throw new ConnectorException("Table name can not be empty.");
        }

        String quotation = buildSqlWithQuotation();
        return SqlBuilderEnum.getSqlBuilder(type).buildSql(tableName, pk, filedNames, queryFilterSQL, quotation, this);
    }

    /**
     * @param ps     参数构造器
     * @param fields 同步字段，例如[{name=ID, type=4}, {name=NAME, type=12}]
     * @param fSize  同步字段个数
     * @param row    同步字段对应的值，例如{ID=123, NAME=张三11}
     */
    private void batchRowsSetter(PreparedStatement ps, List<Field> fields, int fSize, Map<String, Object> row) {
        Field f = null;
        int type;
        Object val = null;
        for (int i = 0; i < fSize; i++) {
            // 取出字段和对应值
            f = fields.get(i);
            type = f.getType();
            val = row.get(f.getName());
            SetterEnum.getSetter(type).set(ps, i + 1, type, val);
        }
    }
}
