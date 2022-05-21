package com.example.metaflink.mapper;
import com.example.metaflink.database.config.RedisConfig1;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface RedisMapper {

    @Select("select * from test.redis")
    public List<RedisConfig1> ListAllRedisConfig();//查询全部的内容
    @Insert("insert into test.redis values (#{Url}, #{port},#{Topic},#{Id},#{Username},#{Password},#{Tablename})")
    @Transactional
    public void InsertRedisConfig(RedisConfig1 redisConfig);//增加数据库
    @Select("select * from test.redis where Id=#{id}")
    public RedisConfig1 ListRedisConfigById(Integer id);//根据表名来查询表
    @Delete("delete from test.redis where Id=#{id}")
    @Transactional
    public boolean DeleteRedisConfigById(Integer id);//根据表名删除对应的表
    @Delete("delete  from test.redis")
    @Transactional
    public boolean DeleteAllRedisConfig();//删除全部的表

    @Update("Update test.redis SET Url=#{Url}," +
            "port=#{port},Topic=#{Topic},Id=#{Id},"+"Username=#{Username},"+"Password=#{Password},"+"Tablename=#{Tablename}"+
            " WHERE Id =#{Id}")
    @Transactional
    public void UpdateRedisConfig(RedisConfig1 redisConfig1);
}
