package com.example.metaflink.controller;

import com.example.metaflink.Service.HdfsConfigService;
import com.example.metaflink.database.config.HdfsConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hdfs")
@CrossOrigin
public class HdfsConfigController {
    @Autowired
    private HdfsConfigService hdfsConfigService;
    @RequestMapping(value = "/FindAllHdfsConfig",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<HdfsConfig> findAll()
    {
        List<HdfsConfig> hdfsConfigs=hdfsConfigService.FindAllHdfsConfigs();
        return hdfsConfigs;
    }
    @RequestMapping(value = "/FindHdfsConfigByid/{id}",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public HdfsConfig findHdfsConfigbyid(@PathVariable Integer id)
    {
        HdfsConfig hdfsConfig=hdfsConfigService.FindHdfsConfigById(id);
        return hdfsConfig;
    }
    @RequestMapping(value = "/DeleteHdfsConfigByid/{id}",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public boolean deleteHdfsConfigByid(@PathVariable Integer id)
    {
        hdfsConfigService.DeleteHdfsConfigsById(id);
        return true;
    }
    @RequestMapping(value = "/DeleteAll",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public String deleteAllHdfsConfig()
    {
        hdfsConfigService.DeleteAllHdfsConfigs();
        return "Successfully Delete!";
    }
    @RequestMapping(value = "/insert",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
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
    @RequestMapping(value = "/update",method = {RequestMethod.GET, RequestMethod.OPTIONS})
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
