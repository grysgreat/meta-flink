package com.example.metaflink.Service;

import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.Table;

import java.util.List;

public interface DataBaseConfigService {
    public void InsertDatabaseConfig(DatabaseConfig databaseConfig);//增加表

    public List<DatabaseConfig> ListAllDataBaseConfig();//查询全部的表

    public DatabaseConfig ListDataBaseConfigById(Integer id);//根据表名来查询表

    public void DeleteDataBaseConfigById(Integer id);//根据表名删除对应的表

    public void DeleteAllDataBaseConfig();//删除全部的表
}
