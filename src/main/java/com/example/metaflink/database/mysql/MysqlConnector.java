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
package com.example.metaflink.database.mysql;

import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.constants.DatabaseConstants;
import com.example.metaflink.database.database.AbstractDatabaseConnector;

/**
 * @author binghe
 * @version 1.0.0
 * @description MySQL连接器
 */
public final class MysqlConnector extends AbstractDatabaseConnector {

    @Override
    protected String getQueryTablesSql(DatabaseConfig config) {
        return "show tables";
    }

    @Override
    public String getPageSql(String tableName, String pk, String querySQL) {
        // Mysql 分页查询
        return querySQL + DatabaseConstants.MYSQL_PAGE_SQL;
    }

    @Override
    public Object[] getPageArgs(int pageIndex, int pageSize) {
        return new Object[]{(pageIndex - 1) * pageSize, pageSize};
    }
}
