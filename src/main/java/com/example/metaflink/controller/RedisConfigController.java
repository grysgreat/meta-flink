package com.example.metaflink.controller;

import com.example.metaflink.Service.RedisService;
import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.RedisConfig;
import com.example.metaflink.database.config.RedisConfig1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
@RestController
@RequestMapping("/Redis")
public class RedisConfigController {
    @Autowired
    private RedisService redisService;
    @GetMapping("/FindAllRedisConfigs")
    public List<String> findAll()
    {
        List<RedisConfig1> redisconfigs=redisService.ListAllRedisConfig();
        List<String>result= new LinkedList<>();
        for(RedisConfig1 i:redisconfigs)
        {
            result.add(i.toString());
        }
        return result;
    }

}
