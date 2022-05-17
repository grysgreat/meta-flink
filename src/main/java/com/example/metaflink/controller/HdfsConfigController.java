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
public class HdfsConfigController {
    @Autowired
    private HdfsConfigService hdfsConfigService;
    @GetMapping("/FindAllHdfsConfig")
    public String findAll()
    {
        List<HdfsConfig> hdfsConfigs=hdfsConfigService.FindAllHdfsConfigs();
        try {
            String  databasejsons=new ObjectMapper().writeValueAsString(hdfsConfigs);
            return databasejsons;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
    @GetMapping("/FindHdfsConfigByid/{id}")
    public String findHdfsConfigbyid(@PathVariable Integer id)
    {
        HdfsConfig hdfsConfig=hdfsConfigService.FindHdfsConfigById(id);
        try {
            String dabasejson=new ObjectMapper().writeValueAsString(hdfsConfig);
            return dabasejson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
    @GetMapping("/DeleteHdfsConfigByid/{id}")
    public String deleteHdfsConfigByid(@PathVariable Integer id)
    {
        hdfsConfigService.DeleteHdfsConfigsById(id);
        return "SuccessfullyDeleted!";
    }
    @GetMapping("/DeleteAll")
    public String deleteAllHdfsConfig()
    {
        hdfsConfigService.DeleteAllHdfsConfigs();
        return "Successfully Delete!";
    }
    @GetMapping("/insert")
    public String Insert(@RequestParam(value ="id" ,required = false)Integer id, @RequestParam(value="url") String url)
    {
        HdfsConfig hdfsConfig=new HdfsConfig();
        hdfsConfig.setId(id);
        hdfsConfig.setUrl(url);
        hdfsConfigService.Insert(hdfsConfig);
        return "Successfully Inserted";
    }
    @RequestMapping("/update")
    public String UpdateRedisConfig(@RequestParam(value ="id",required = true)Integer id, @RequestParam(value="url",required = false) String url)
    {
        HdfsConfig hdfsConfig=new HdfsConfig();
        hdfsConfig.setUrl(url);
        hdfsConfig.setId(id);
        hdfsConfigService.Update(hdfsConfig);
        return "Update Successfully";
    }
}
