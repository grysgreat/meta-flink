package com.example.metaflink.controller;

import com.example.metaflink.Service.DataBaseConfigService;
import com.example.metaflink.Service.DataBaseConfigServiceImpl;
import com.example.metaflink.database.config.DatabaseConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/DataBase")
@CrossOrigin
@Api(tags = "数据库管理")
public class DataBaseConfigController {
    @Autowired
    private DataBaseConfigService dataBaseConfigService;

    @RequestMapping("/FindALLDataBaseConfigs")
    @ApiOperation(value = "获取所有的JDBC链接信息")
    public List<DatabaseConfig> findAll()
    {
        List<DatabaseConfig> databaseConfigs=dataBaseConfigService.ListAllDataBaseConfig();
        return databaseConfigs;
    }
    @RequestMapping("/Delete/{id}")
    @ApiOperation(value = "根据给定的id值删除对应的JDBC链接信息")
    public Boolean deleteDataBaseConfig(@PathVariable Integer id)
    {
        dataBaseConfigService.DeleteDataBaseConfigById(id);
        return true;
        //return (new HashMap<String,Boolean>() ).put("is_ok", true);
    }
    @RequestMapping("/DeleteAll")
    @ApiOperation(value = "删除所有的JDBC链接信息")
    public Boolean deleteAllDataBaseConfig()
    {
        dataBaseConfigService.DeleteAllDataBaseConfig();
        return true;
    }

    @RequestMapping("/find")
    @ApiOperation(value = "根据给定的id值获取对应的JDBC链接信息")
    public DatabaseConfig getDataBaseConfigById(@RequestParam Integer id){
        DatabaseConfig databaseConfig=dataBaseConfigService.ListDataBaseConfigById(id);
        return databaseConfig;
    }
    @RequestMapping("/insert")
    @ApiImplicitParams
    ({
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "JDBC编号", required = false, example = "1"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "driverClassName", value = "驱动器名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "url", value = "URL", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "connectorType", value = "连接器种类", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "sql", value = "SQL", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "port", value = "端口号", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "tablename", value = "表名", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "basename", value = "数据库名", required = false)


    }
    )
    @ApiOperation(value = "插入新的JDBC链接信息",notes="根据传过来的JDBC链接信息来插入一个新的JDBC链接信息")
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


    @RequestMapping("/update")//更新数据库
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "JDBC编号", required = true, example = "1"),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "driverClassName", value = "驱动器名称", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "url", value = "URL", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "用户名", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "connectorType", value = "连接器种类", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "sql", value = "SQL", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "Long", name = "port", value = "端口号", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "tablename", value = "表名", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "basename", value = "数据库名", required = false)


            }
            )
    @ApiOperation(value = "更新JDBC链接信息",notes="根据传过来的JDBC链接信息来更新JDBC链接详细信息")
    public DatabaseConfig updateDataBaseConfigs(@RequestParam(value ="id",required = true)Long id,
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
