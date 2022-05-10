package com.example.metaflink.controller;

import com.example.metaflink.Service.DataBaseConfigService;
import com.example.metaflink.Service.DataBaseConfigServiceImpl;
import com.example.metaflink.database.config.DatabaseConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@RequestMapping("/DataBase")
public class DataBaseConfigController {
    @Autowired
    private DataBaseConfigService dataBaseConfigService;

    @GetMapping("/FindALLDataBaseConfigs")
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
    @GetMapping("/Delete/{id}")
    public String deleteDataBaseConfig(@PathVariable Integer id)
    {
        dataBaseConfigService.DeleteDataBaseConfigById(id);
        return "Successfully Delete";
    }
    @GetMapping("/DeleteAll")
    public String deleteAllDataBaseConfig()
    {
        dataBaseConfigService.DeleteAllDataBaseConfig();
        return "Successfully Delete!";
    }

    @GetMapping("/find")
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
    @GetMapping("/insert")
    public String insertDataBaseConfigs(@RequestParam(value ="id")Long id,@RequestParam(value ="driverClassName")
            String driverClassName ,@RequestParam(value ="url")String  url,@RequestParam(value ="username")String  username,@RequestParam(value ="password")String  password,
                                        @RequestParam(value ="connectorType")String connectorType,@RequestParam(value = "sql")String sql)
    {
        DatabaseConfig databaseConfig=new DatabaseConfig();
        databaseConfig.setDriverClassName(driverClassName);
        databaseConfig.setPassword(password);
        databaseConfig.setUrl(url);
        databaseConfig.setUsername(username);
        databaseConfig.setConnectorType(connectorType);
        databaseConfig.setId(id);
        databaseConfig.setSql(sql);
        dataBaseConfigService.InsertDatabaseConfig(databaseConfig);
        return "Successfully Inserted";
    }


}
