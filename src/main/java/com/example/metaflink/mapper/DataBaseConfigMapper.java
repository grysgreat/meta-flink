package com.example.metaflink.mapper;

import com.example.metaflink.database.config.DatabaseConfig;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Mapper
public interface DataBaseConfigMapper {

    @Select("select * from test.DataBaseConfigs")
    public List<DatabaseConfig> ListAllDataBaseConfig();//查询全部的内容

    @Insert("insert into test.DataBaseConfigs values (#{id},#{driverClassName},#{url}," +
            "#{username},"+"#{password},"+
            "#{connectorType},#{sql},#{port},#{tablename},#{basename})")
    @Transactional
    public void InsertDatabaseConfig(DatabaseConfig databaseConfig);//增加数据库

    @Update("Update test.DataBaseConfigs SET driverClassName=#{driverClassName} ," +
            "url=#{url} ,"+"username=#{username} ,"+"password=#{password} ,"+
            "connectorType=#{connectorType},port=#{port},tablename=#{tablename} ," +"basename=#{basename}"+
            " WHERE id =#{id}")
    @Transactional
    public void UpdateDataBaseConfigs(DatabaseConfig databaseConfig);//更新数据库



    @Select("select * from test.DataBaseConfigs where id=#{id}")
    public DatabaseConfig ListDataBaseConfigById(Integer id);//根据表名来查询表

    @Delete("delete from test.DataBaseConfigs where id=#{id}")
    @Transactional
    public boolean DeleteDataBaseConfigById(Integer id);//根据表名删除对应的表

    @Delete("delete  from test.DataBaseConfigs")
    @Transactional
    public boolean DeleteAllDataBaseConfig();//删除全部的表
}
