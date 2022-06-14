package com.example.metaflink.controller;

import com.example.metaflink.Service.RedisService;

import com.example.metaflink.database.config.RedisConfig1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Redis管理")
@RestController
@CrossOrigin
@RequestMapping("/Redis")
public class RedisConfigController {
    @Autowired
    private RedisService redisService;
    @RequestMapping("/FindAllRedisConfigs")
    @ApiOperation(value = "获取Redis信息",notes = "获取全部Redis信息")
    public List<RedisConfig1>  findAll()
    {
        List<RedisConfig1> redisconfigs=redisService.ListAllRedisConfig();
        return redisconfigs;
    }
    @RequestMapping("/FindRedisConfigByid/{id}")
    @ApiOperation(value = "获取Redis信息",notes = "根据id值获取Redis信息")
    public RedisConfig1 findRedisConfigbyid(@PathVariable Integer id)
    {
        RedisConfig1 redisConfig1=redisService.ListRedisConfigById(id);

        return redisConfig1;
    }
    @RequestMapping("/DeleteRedisConfigByid/{id}")
    @ApiOperation(value = "删除Redis信息",notes = "根据id值删除Redis信息")
    public boolean deleteRedisConfigByid(@PathVariable Integer id)
    {
        redisService.DeleteRedisConfigById(id);
        return true;
    }
    @RequestMapping("/DeleteAll")
    @ApiOperation(value = "删除Redis信息",notes = "删除全部Redis信息")
    public boolean deleteAllRedisConfig()
    {
        redisService.DeleteAllRedisConfig();
        return true;
    }
    @RequestMapping("/insert")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "Redis编号", required = true, example = "1")
    @ApiOperation(value = "插入新的Redis信息",notes="根据传过来的Redis信息来插入一个新的Redis详细信息")
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
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "Redis编号", required = true, example = "1")
    @ApiOperation(value = "更新的Redis信息",notes="根据传过来的Redis信息来更新的Redis详细信息")
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
