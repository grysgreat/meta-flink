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
package com.example.metaflink.database.config;
import lombok.*;


/**
 * @author binghe
 * @version 1.0.0
 * @description 数据库配置
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseConfig extends ConnectorConfig{

    /**
     * 驱动com.mysql.jdbc.Driver
     */
    private String driverClassName;

    public  String types = "mysql";

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    /**
     * 连接地址
     */
    private Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }

    private String tablename;
    private String basename;
    private String url;

    /**
     * 帐号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 通过SQL获取表信息
     */
    private String sql;

    /**
     * id字段
     */
    private Long id;

    public Long getId() { return id;    }

    public void setId(Long id) { this.id = id;    }

    public String getDriverClassName() {
        return driverClassName;
    }


    public DatabaseConfig setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DatabaseConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DatabaseConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DatabaseConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "DatabaseConfig{" +
                "driverClassName='" + driverClassName + '\'' +
                ", port=" + port +
                ", tablename='" + tablename + '\'' +
                ", basename='" + basename + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sql='" + sql + '\'' +
                ", id=" + id +
                '}';
    }
}
