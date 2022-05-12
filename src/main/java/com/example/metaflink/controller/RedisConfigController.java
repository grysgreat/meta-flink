package com.example.metaflink.controller;

import com.example.metaflink.Service.RedisService;
import com.example.metaflink.database.config.DatabaseConfig;
import com.example.metaflink.database.config.KafKAConfig;
import com.example.metaflink.database.config.RedisConfig;
import com.example.metaflink.database.config.RedisConfig1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
@RestController
@RequestMapping("/Redis")
public class RedisConfigController {
    @Autowired
    private RedisService redisService;
    @GetMapping("/FindAllRedisConfigs")
    public String findAll()
    {
        List<RedisConfig1> redisconfigs=redisService.ListAllRedisConfig();
        try {
            String  databasejsons=new ObjectMapper().writeValueAsString(redisconfigs);
            return databasejsons;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
    @GetMapping("/FindRedisConfigByid/{id}")
    public String findRedisConfigbyid(@PathVariable Integer id)
    {
        RedisConfig1 redisConfig1=redisService.ListRedisConfigById(id);
        try {
            String dabasejson=new ObjectMapper().writeValueAsString(redisConfig1);
            return dabasejson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
    @GetMapping("/DeleteRedisConfigByid/{id}")
    public String deleteRedisConfigByid(@PathVariable Integer id)
    {
        redisService.DeleteRedisConfigById(id);
        return "SuccessfullyDeleted!";
    }
    @GetMapping("/DeleteAll")
    public String deleteAllRedisConfig()
    {
        redisService.DeleteAllRedisConfig();
        return "Successfully Delete!";
    }
    @GetMapping("/insert")
    public String Insert(@RequestParam(value ="id")Integer id,@RequestParam(value="ip") String ip,
                         @RequestParam(value="Destport")Integer destport,@RequestParam(value="Topic")String Topic)
    {
        RedisConfig1 redisConfig1=new RedisConfig1();
        redisConfig1.setDestport(destport);
        redisConfig1.setId(id);
        redisConfig1.setIp(ip);
        redisConfig1.setTopic(Topic);
        redisService.InsertRedis(redisConfig1);
        return "Successfully Inserted";
    }
    @RequestMapping("/update")
    public String UpdateRedisConfig(@RequestParam(value = "id",required = true) Integer id, @RequestParam(value = "Ip",required = false) String ip,
                                    @RequestParam(value = "Topic",required = false) String Topic, @RequestParam(value = "DestPort",required = false) Integer DestPort)
    {
        RedisConfig1 redisConfig1=new RedisConfig1();
        redisConfig1.setTopic(Topic);
        redisConfig1.setDestport(DestPort);
        redisConfig1.setId(id);
        redisConfig1.setIp(ip);
        redisService.UpdateRedisConfig(redisConfig1);
        return "Update Successfully";
    }


}
