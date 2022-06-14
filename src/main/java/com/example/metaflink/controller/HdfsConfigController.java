package com.example.metaflink.controller;

import com.example.metaflink.Service.HdfsConfigService;
import com.example.metaflink.Service.SocketService;
import com.example.metaflink.database.config.HdfsConfig;
import com.example.metaflink.database.config.Socket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "Hdfs管理")
@RestController
@RequestMapping("/Hdfs")
@CrossOrigin
public class HdfsConfigController {
    @Autowired
    private HdfsConfigService hdfsConfigService;
    @RequestMapping("/FindAllHdfsConfig")
    @ApiOperation(value = "获取Hdfs信息",notes = "获取全部Hdfs信息")
    public List<HdfsConfig> findAll()
    {
        List<HdfsConfig> hdfsConfigs=hdfsConfigService.FindAllHdfsConfigs();
        return hdfsConfigs;
    }
    @RequestMapping("/FindHdfsConfigByid/{id}")
    @ApiOperation(value = "获取Hdfs信息",notes = "根据Id值获取对应Hdfs信息")
    public HdfsConfig findHdfsConfigbyid(@PathVariable Integer id)
    {
        HdfsConfig hdfsConfig=hdfsConfigService.FindHdfsConfigById(id);
        return hdfsConfig;
    }
    @RequestMapping("/DeleteHdfsConfigByid/{id}")
    @ApiOperation(value = "删除Hdfs信息",notes = "根据Id值删除对应Hdfs信息")
    public boolean deleteHdfsConfigByid(@PathVariable Integer id)
    {
        hdfsConfigService.DeleteHdfsConfigsById(id);
        return true;
    }
    @RequestMapping("/DeleteAll")
    @ApiOperation(value = "删除Hdfs信息",notes = "删除全部Hdfs信息")

    public String deleteAllHdfsConfig()
    {
        hdfsConfigService.DeleteAllHdfsConfigs();
        return "Successfully Delete!";
    }
    @RequestMapping("/insert")
    @ApiImplicitParams
    ({
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "Hdfs编号", required = false, example = "1"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "url", value = "URL", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类型", required = false)

    })
    @ApiOperation(value = "插入新的Hdfs信息",notes="根据传过来的KafKA信息来插入一个新的Hdfs详细信息")
    public HdfsConfig Insert(@RequestParam(value ="id" ,required = false)Integer id,
                             @RequestParam(value="url") String url,
                             @RequestParam(value="type")String type)
    {
        HdfsConfig hdfsConfig=new HdfsConfig();
        hdfsConfig.setId(id);
        hdfsConfig.setUrl(url);
        hdfsConfig.setType(type);
        hdfsConfigService.Insert(hdfsConfig);
        return hdfsConfig;

    }
    @RequestMapping("/update")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "Hdfs编号", required = true, example = "1"),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "url", value = "URL", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类型", required = false)

            })    @ApiOperation(value = "更新Hdfs信息",notes="根据传过来的KafKA信息来更新的Hdfs详细信息")
    public HdfsConfig UpdateRedisConfig(@RequestParam(value ="id",required = true)Integer id,
                                        @RequestParam(value="url",required = false) String url,
                                        @RequestParam(value = "type",required = false)String type)
    {
        HdfsConfig hdfsConfig=new HdfsConfig();
        hdfsConfig.setUrl(url);
        hdfsConfig.setId(id);
        hdfsConfig.setType(type);
        hdfsConfigService.Update(hdfsConfig);
        return hdfsConfig;
    }
}
