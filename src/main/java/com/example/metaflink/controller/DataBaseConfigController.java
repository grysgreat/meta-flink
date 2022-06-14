package com.example.metaflink.controller;

import com.example.metaflink.Service.DataBaseConfigService;

import com.example.metaflink.database.config.DatabaseConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/DataBase")
@CrossOrigin
@Api(tags = "数据库管理")
public class DataBaseConfigController {
    @Autowired
    private DataBaseConfigService dataBaseConfigService;

    @RequestMapping(value = "/FindALLDataBaseConfigs",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
    @ApiOperation(value = "获取所有的JDBC链接信息")
    public List<DatabaseConfig> findAll()
    {
        List<DatabaseConfig> databaseConfigs=dataBaseConfigService.ListAllDataBaseConfig();
        return databaseConfigs;
    }
    @RequestMapping(value = "/Delete/{id}",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
    public Boolean deleteDataBaseConfig(@PathVariable Integer id)
    {
        dataBaseConfigService.DeleteDataBaseConfigById(id);
        return true;
        //return (new HashMap<String,Boolean>() ).put("is_ok", true);
    }
    @RequestMapping(value="/DeleteAll",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
    public Boolean deleteAllDataBaseConfig()
    {
        dataBaseConfigService.DeleteAllDataBaseConfig();
        return true;
    }

    @RequestMapping(value="/find",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
    public DatabaseConfig getDataBaseConfigById(@RequestParam Integer id){
        DatabaseConfig databaseConfig=dataBaseConfigService.ListDataBaseConfigById(id);
        return databaseConfig;
    }
    @RequestMapping(value="/insert",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})
    public DatabaseConfig insertDataBaseConfigs(@RequestParam(value ="id",required = false)Long id,
                                                @RequestParam(value ="driverClassName",required = false) String driverClassName ,
                                                @RequestParam(value ="url",required = false)String url,
                                                @RequestParam(value ="username",required = false)String username,
                                                @RequestParam(value ="password",required = false)String password,
                                                @RequestParam(value ="connectorType",required = false)String  connectorType,
                                                @RequestParam(value ="sql",required = false)String  sql,
                                                @RequestParam(value ="port",required = false)Integer  port,
                                                @RequestParam(value ="tablename",required = false)String tablename,
                                              @RequestParam(value ="basename",required = false)String basename)
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


    @RequestMapping(value = "/update",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS})//更新数据库
    public DatabaseConfig updateDataBaseConfigs(@RequestParam(value ="id",required = false)Long id,
                                                @RequestParam(value ="driverClassName",required = false) String driverClassName ,
                                                @RequestParam(value ="url",required = false)String url,
                                                @RequestParam(value ="username",required = false)String username,
                                                @RequestParam(value ="password",required = false)String password,
                                                @RequestParam(value ="connectorType",required = false)String  connectorType,
                                                @RequestParam(value ="Sql",required = false)String  sql,
                                                @RequestParam(value ="port",required = false)Integer  port,
                                                @RequestParam(value ="tablename",required = false)String tablename,
                                                @RequestParam(value = "basename",required = false)String basename)
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
