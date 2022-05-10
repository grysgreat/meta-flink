package com.example.metaflink.mapper;

import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.RedisConfig1;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface RedisMapper {

    @Select("select * from test.redis")
    public List<RedisConfig1> ListAllRedisConfig();//查询全部的内容
    @Update("insert into test.redis values (#{ip}, #{Destport},#{Topic})")
    @Transactional
    public void InsertDatabaseConfig(RedisConfig1 redisConfig);//增加数据库
    @Select("select * from test.redis where Ip=#{ip}")
    public RedisConfig1 ListRedisConfigByIp(String ip);//根据表名来查询表
    @Delete("delete from test.redis where Ip=#{ip}")
    @Transactional
    public boolean DeleteRedisConfigByIp(String ip);//根据表名删除对应的表
    @Delete("delete  from test.redis")
    @Transactional
    public boolean DeleteAllRedisConfig();//删除全部的表
}
