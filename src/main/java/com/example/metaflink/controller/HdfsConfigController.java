package com.example.metaflink.controller;

import com.example.metaflink.Service.HdfsConfigService;
import com.example.metaflink.Service.SocketService;
import com.example.metaflink.database.config.HdfsConfig;
import com.example.metaflink.database.config.Socket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hdfs")
@CrossOrigin
public class HdfsConfigController {
    @Autowired
    private HdfsConfigService hdfsConfigService;
    @RequestMapping("/FindAllHdfsConfig")
    public List<HdfsConfig> findAll()
    {
        List<HdfsConfig> hdfsConfigs=hdfsConfigService.FindAllHdfsConfigs();
        return hdfsConfigs;
    }
    @RequestMapping("/FindHdfsConfigByid/{id}")
    public HdfsConfig findHdfsConfigbyid(@PathVariable Integer id)
    {
        HdfsConfig hdfsConfig=hdfsConfigService.FindHdfsConfigById(id);
        return hdfsConfig;
    }
    @RequestMapping("/DeleteHdfsConfigByid/{id}")
    public boolean deleteHdfsConfigByid(@PathVariable Integer id)
    {
        hdfsConfigService.DeleteHdfsConfigsById(id);
        return true;
    }
    @RequestMapping("/DeleteAll")
    public String deleteAllHdfsConfig()
    {
        hdfsConfigService.DeleteAllHdfsConfigs();
        return "Successfully Delete!";
    }
    @RequestMapping("/insert")
    public HdfsConfig Insert(@RequestParam(value ="id" ,required = false)Integer id, @RequestParam(value="url") String url)
    {
        HdfsConfig hdfsConfig=new HdfsConfig();
        hdfsConfig.setId(id);
        hdfsConfig.setUrl(url);
        hdfsConfigService.Insert(hdfsConfig);
        return hdfsConfig;

    }
    @RequestMapping("/update")
    public HdfsConfig UpdateRedisConfig(@RequestParam(value ="id",required = true)Integer id, @RequestParam(value="url",required = false) String url)
    {
        HdfsConfig hdfsConfig=new HdfsConfig();
        hdfsConfig.setUrl(url);
        hdfsConfig.setId(id);
        hdfsConfigService.Update(hdfsConfig);
        return hdfsConfig;
    }
}
