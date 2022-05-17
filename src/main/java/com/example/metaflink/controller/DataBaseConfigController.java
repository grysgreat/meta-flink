package com.example.metaflink.controller;

import com.example.metaflink.Service.DataBaseConfigService;
import com.example.metaflink.Service.DataBaseConfigServiceImpl;
import com.example.metaflink.database.config.DatabaseConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/DataBase")
@CrossOrigin
public class DataBaseConfigController {
    @Autowired
    private DataBaseConfigService dataBaseConfigService;

    @RequestMapping("/FindALLDataBaseConfigs")
    public String findAll()
    {
        List<DatabaseConfig> databaseConfigs=dataBaseConfigService.ListAllDataBaseConfig();
        try {
            String  databasejsons=new ObjectMapper().writeValueAsString(databaseConfigs);
            return databasejsons;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
    @RequestMapping("/Delete/{id}")
    public Boolean deleteDataBaseConfig(@PathVariable Integer id)
    {
        dataBaseConfigService.DeleteDataBaseConfigById(id);
        return true;
        //return (new HashMap<String,Boolean>() ).put("is_ok", true);
    }
    @RequestMapping("/DeleteAll")
    public String deleteAllDataBaseConfig()
    {
        dataBaseConfigService.DeleteAllDataBaseConfig();
        return "Successfully Delete!";
    }

    @RequestMapping("/find")
    public String getDataBaseConfigById(@RequestParam Integer id){
        DatabaseConfig databaseConfig=dataBaseConfigService.ListDataBaseConfigById(id);
        try {
            String dabasejson=new ObjectMapper().writeValueAsString(databaseConfig);
            return dabasejson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
    @RequestMapping("/insert")
    public DatabaseConfig insertDataBaseConfigs(@RequestParam(value ="id",required = false)Long id,@RequestParam(value ="driverClassName",required = false)
            String driverClassName ,@RequestParam(value ="url",required = false)String url,@RequestParam(value ="username",required = false)String username,@RequestParam(value ="password",required = false)String password
            ,@RequestParam(value ="connectorType",required = false)String  connectorType,@RequestParam(value ="sql",required = false)String  sql,
                                                @RequestParam(value ="port",required = false)Integer  port,
                                        @RequestParam(value ="tablename",required = false)String tablename,@RequestParam(value = "basename",required = false)String basename)
    {
        DatabaseConfig databaseConfig=new DatabaseConfig();
        databaseConfig.setDriverClassName(driverClassName);
        databaseConfig.setPassword(password);
        databaseConfig.setUrl(url);
        databaseConfig.setUsername(username);
        databaseConfig.setConnectorType(connectorType);
        databaseConfig.setId(id);
        databaseConfig.setSql(sql);
        databaseConfig.setBasename(basename);
        databaseConfig.setTablename(tablename);
        databaseConfig.setPort(port);
        dataBaseConfigService.InsertDatabaseConfig(databaseConfig);
        return databaseConfig;
    }


    @RequestMapping("/update")//更新数据库
    public DatabaseConfig updateDataBaseConfigs(@RequestParam(value ="id",required = false)Long id,@RequestParam(value ="driverClassName",required = false)
            String driverClassName ,@RequestParam(value ="url",required = false)String url,@RequestParam(value ="username",required = false)String username,@RequestParam(value ="password",required = false)String password
            ,@RequestParam(value ="connectorType",required = false)String  connectorType,@RequestParam(value ="Sql",required = false)String  sql,
                                                @RequestParam(value ="port",required = false)Integer  port,
                                                @RequestParam(value ="tablename",required = false)String tablename,@RequestParam(value = "basename",required = false)String basename)
    {
        DatabaseConfig databaseConfig=new DatabaseConfig();
        databaseConfig.setDriverClassName(driverClassName);
        databaseConfig.setPassword(password);
        databaseConfig.setUrl(url);
        databaseConfig.setUsername(username);
        databaseConfig.setConnectorType(connectorType);
        databaseConfig.setId(id);
        databaseConfig.setSql(sql);
        databaseConfig.setTablename(tablename);
        databaseConfig.setBasename(basename);
        databaseConfig.setPort(port);
        dataBaseConfigService.UpdateDataBaseConfig(databaseConfig);
        return databaseConfig;
    }


}
