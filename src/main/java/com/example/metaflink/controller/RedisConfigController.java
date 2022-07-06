package com.example.metaflink.controller;

import com.example.metaflink.Service.RedisService;

import com.example.metaflink.database.config.RedisConfig1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/Redis")
public class RedisConfigController {
    @Autowired
    private RedisService redisService;
    @RequestMapping("/FindAllRedisConfigs")
    public List<RedisConfig1>  findAll()
    {
        List<RedisConfig1> redisconfigs=redisService.ListAllRedisConfig();
        return redisconfigs;
    }
    @RequestMapping("/FindRedisConfigByid/{id}")
    public RedisConfig1 findRedisConfigbyid(@PathVariable Integer id)
    {
        RedisConfig1 redisConfig1=redisService.ListRedisConfigById(id);

        return redisConfig1;
    }
    @RequestMapping("/DeleteRedisConfigByid/{id}")
    public boolean deleteRedisConfigByid(@PathVariable Integer id)
    {
        redisService.DeleteRedisConfigById(id);
        return true;
    }
    @RequestMapping("/DeleteAll")
    public boolean deleteAllRedisConfig()
    {
        redisService.DeleteAllRedisConfig();
        return true;
    }
    @RequestMapping("/insert")
    public RedisConfig1 Insert(@RequestParam(value ="id",required = false)Integer id,
                               @RequestParam(value="url") String url,
                               @RequestParam(value ="username",required = false)String Username,
                               @RequestParam(value ="password",required = false)String Password,
                               @RequestParam(value ="tablename",required = false)String Tablename,
                               @RequestParam(value="port",required = false)Integer destport,
                               @RequestParam(value="topic",required = false)String Topic){
        RedisConfig1 redisConfig1=new RedisConfig1();
        redisConfig1.setPort(destport);
        redisConfig1.setUrl(url);
        redisConfig1.setTopic(Topic);
        redisConfig1.setPassword(Password);
        redisConfig1.setTablename(Tablename);
        redisConfig1.setUsername(Username);
        redisService.InsertRedis(redisConfig1);
        return redisConfig1;
    }
    @RequestMapping("/update")
    public RedisConfig1 UpdateRedisConfig(@RequestParam(value ="id",required = true)Integer id,
                                    @RequestParam(value="url") String url,
                                    @RequestParam(value ="username",required = false)String Username,
                                    @RequestParam(value ="password",required = false)String Password,
                                    @RequestParam(value ="tablename",required = false)String Tablename,
                                    @RequestParam(value="port",required = false)Integer destport,
                                    @RequestParam(value="topic",required = false)String Topic)
    {
        RedisConfig1 redisConfig1=new RedisConfig1();
        redisConfig1.setTopic(Topic);
        redisConfig1.setPort(destport);
        redisConfig1.setUsername(Username);
        redisConfig1.setTablename(Tablename);
        redisConfig1.setPassword(Password);
        redisConfig1.setId(id);
        redisConfig1.setUrl(url);
        redisService.UpdateRedisConfig(redisConfig1);
        return redisConfig1;
    }


}
