package com.example.metaflink.Service;


import com.example.metaflink.database.config.RedisConfig1;


import java.util.List;

public interface RedisService {
    public void InsertRedis(RedisConfig1 redisConfig);//增加表

    public List<RedisConfig1> ListAllRedisConfig();//查询全部的表

    public RedisConfig1 ListRedisConfigById(Integer id);//根据表名来查询表

    public void DeleteRedisConfigById(Integer id);//根据表名删除对应的表

    public void DeleteAllRedisConfig();//删除全部的表

    public void UpdateRedisConfig(RedisConfig1 redisConfig1);
}
