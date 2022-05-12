package com.example.metaflink.Service;

import com.example.metaflink.database.config.RedisConfig;
import com.example.metaflink.database.config.RedisConfig1;
import com.example.metaflink.mapper.RedisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RedisServiceImpl implements RedisService{

    @Autowired
    private RedisMapper redisMapper;
    @Override
    public void InsertRedis(RedisConfig1 redisConfig) {
        redisMapper.InsertRedisConfig(redisConfig);
    }

    @Override
    public List<RedisConfig1> ListAllRedisConfig() {
        return redisMapper.ListAllRedisConfig();
    }

    @Override
    public RedisConfig1 ListRedisConfigById(Integer id) {
        return redisMapper.ListRedisConfigById(id);
    }

    @Override
    public void DeleteRedisConfigById(Integer id) {
        redisMapper.DeleteRedisConfigById(id);

    }

    @Override
    public void DeleteAllRedisConfig() {
        redisMapper.DeleteAllRedisConfig();
    }

    @Override
    public void UpdateRedisConfig(RedisConfig1 redisConfig1) {
        redisMapper.UpdateRedisConfig(redisConfig1);
    }
}
