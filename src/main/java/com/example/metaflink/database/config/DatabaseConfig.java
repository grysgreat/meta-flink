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

import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Table;

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

    /**
     * 连接地址
     */
    private String url;

    /**
     * 帐号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    @Override
    public String toString() {
        return "DatabaseConfig{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sql='" + sql + '\'' +
                ", id=" + id +
                '}';
    }

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
}
