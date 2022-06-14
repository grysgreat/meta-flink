package com.example.metaflink.util;

import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.Field;
import com.example.metaflink.database.config.MetaInfo;
import com.example.metaflink.database.config.Table;
import com.example.metaflink.exception.ConnectorException;
import com.sun.rowset.CachedRowSetImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.ResultSetWrappingSqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.util.CollectionUtils;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author luxian
 */
public class DataBaseUtil {
//TODO :解决这一依赖

    /**
     * 生成 JdbcTemplate 用于数据库的动态连接
     * @param config 数据库配置类
     * @return
     */
    public static JdbcTemplate getJdbcTemplate(DatabaseConfig config) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(config.getDriverClassName());
        dataSource.setUrl(config.getUrl());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());

        // 是否自动回收超时连接
        dataSource.setRemoveAbandoned(true);
        // 超时时间(以秒数为单位)
        dataSource.setRemoveAbandonedTimeout(600);
        return new JdbcTemplate(dataSource);
    }

    public static void close(JdbcTemplate jdbcTemplate) throws SQLException {
        if (null != jdbcTemplate) {
            DataSource dataSource = jdbcTemplate.getDataSource();
            BasicDataSource ds = (BasicDataSource) dataSource;
            ds.close();
        }
    }

    public static void close(Connection connection) throws SQLException {
        if (null != connection) {
            connection.close();
        }
    }

    public static void close(ResultSet rs) throws SQLException {
        if (null != rs) {
            rs.close();
        }
    }

    /**
     * 获取数据库表元数据信息
     *
     * @param jdbcTemplate
     * @param metaSql      查询元数据
     * @param tableName    表名
     * @return MetaInfo 元数据
     */
    public static MetaInfo getMetaInfo(JdbcTemplate jdbcTemplate, String metaSql, String tableName) throws SQLException {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(metaSql);
        ResultSetWrappingSqlRowSet rowSet = (ResultSetWrappingSqlRowSet) sqlRowSet;
        CachedRowSetImpl resultSet = (CachedRowSetImpl) rowSet.getResultSet();
        SqlRowSetMetaData metaData = rowSet.getMetaData();

        // 查询表字段信息
        int columnCount = metaData.getColumnCount();
        if (1 > columnCount) {
            throw new ConnectorException("查询表字段不能为空.");
        }
        Connection connection = null;
        List<Field> fields = new ArrayList<>(columnCount);
        // <表名,[主键, ...]>
        Map<String, List<String>> tables = new HashMap<>();
        try {
            connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
            DatabaseMetaData md = connection.getMetaData();
            String name = null;
            String label = null;
            String typeName = null;
            String table = null;
            int columnType;
            boolean pk;
            for (int i = 1; i <= columnCount; i++) {
                table = StringUtils.isNotBlank(tableName) ? tableName : metaData.getTableName(i);
                if (null == tables.get(table)) {
                    tables.putIfAbsent(table, findTablePrimaryKeys(md, table));
                }
                name = metaData.getColumnName(i);
                label = metaData.getColumnLabel(i);
                typeName = metaData.getColumnTypeName(i);
                columnType = metaData.getColumnType(i);
                pk = isPk(tables, table, name);
                fields.add(new Field(label, typeName, columnType, pk));
            }
        } finally {
            tables.clear();
            close(connection);
        }
        return new MetaInfo(fields, resultSet.size());
    }

    public static Table getTableMetaInfo(JdbcTemplate jdbcTemplate, String metaSql, String tableName) throws SQLException {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(metaSql);
        ResultSetWrappingSqlRowSet rowSet = (ResultSetWrappingSqlRowSet) sqlRowSet;
        CachedRowSetImpl resultSet = (CachedRowSetImpl) rowSet.getResultSet();
        SqlRowSetMetaData metaData = rowSet.getMetaData();

        // 查询表字段信息
        int columnCount = metaData.getColumnCount();
        if (1 > columnCount) {
            throw new ConnectorException("查询表字段不能为空.");
        }
        Connection connection = null;
        List<Field> fields = new ArrayList<>(columnCount);
        // <表名,[主键, ...]>
        Map<String, List<String>> tables = new HashMap<>();
        Table newtable = new Table();

        try {
            connection = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
            DatabaseMetaData md = connection.getMetaData();
            String name = null;
            String label = null;
            String typeName = null;
            String table = null;
            int columnType;
            boolean pk;
            for (int i = 1; i <= columnCount; i++) {
                table = StringUtils.isNotBlank(tableName) ? tableName : metaData.getTableName(i);
                if (null == tables.get(table)) {
                    tables.putIfAbsent(table, findTablePrimaryKeys(md, table));
                }
                name = metaData.getColumnName(i);
                label = metaData.getColumnLabel(i);
                typeName = metaData.getColumnTypeName(i);
                columnType = metaData.getColumnType(i);
                pk = isPk(tables, table, name);
                fields.add(new Field(label, typeName, columnType, pk));
            }
            // 生成新Table类型
            newtable.setName(table);
            newtable.setColumn(fields);
            newtable.setCount(resultSet.size());
        } finally {
            tables.clear();
            close(connection);
        }
        return newtable;
    }

    private static boolean isPk(Map<String, List<String>> tables, String tableName, String name) {
        List<String> pk = tables.get(tableName);
        return !CollectionUtils.isEmpty(pk) && pk.contains(name);
    }

    private static List<String> findTablePrimaryKeys(DatabaseMetaData md, String tableName) throws SQLException {
        //根据表名获得主键结果集
        ResultSet rs = null;
        List<String> primaryKeys = new ArrayList<>();
        try {
            rs = md.getPrimaryKeys(null, null, tableName);
            while (rs.next()) {
                primaryKeys.add(rs.getString("COLUMN_NAME"));
            }
        } finally {
            close(rs);
        }
        return primaryKeys;
    }
}
