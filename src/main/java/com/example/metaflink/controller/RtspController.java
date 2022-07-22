package com.example.metaflink.controller;

import com.example.metaflink.database.config.RtspConfig;
import com.example.metaflink.mapper.RtmpaRtspMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rtsp")
@CrossOrigin
public class RtspController {
    @Autowired
    private RtmpaRtspMapper rtmpaRtspMapper;
    @RequestMapping(value = "/all")
    public List<RtspConfig> findAllRtsp(){
        return rtmpaRtspMapper.AllRtspConfig();
    }

    @RequestMapping(value = "/insert")
    public boolean InsertRtsp(@RequestParam(value ="url",required = true)String url){
        return rtmpaRtspMapper.InsertRtsp(url);
    }
    @RequestMapping(value = "/delete/{id}")
    public boolean DeleteRtsp(@PathVariable Integer id){
        return rtmpaRtspMapper.DeleteRtsp(id);
    }
    @RequestMapping(value = "/update")
    public RtspConfig UpdateRtsp(@RequestParam(value ="id",required = true)Integer Id,
                              @RequestParam(value ="url",required = true)String url){
        RtspConfig newrtsp = new RtspConfig();
        newrtsp.setId(Id);
        newrtsp.setUrl(url);
        rtmpaRtspMapper.updateRtsp(newrtsp);
        return newrtsp;
    }
}
