package com.example.metaflink.controller;

import com.example.metaflink.database.config.RtmpConfig;
import com.example.metaflink.mapper.RtmpaRtspMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rtmp")
@CrossOrigin
public class RtmpController {

    @Autowired
    private RtmpaRtspMapper rtmpaRtspMapper;
    @RequestMapping(value = "/all")
    public List<RtmpConfig> findAllRtmp(){
        return rtmpaRtspMapper.AllRtmpConfig();
    }

    @RequestMapping(value = "/insert")
    public boolean InsertRtmp(@RequestParam(value ="url",required = true)String url){
       return rtmpaRtspMapper.InsertRtmp(url);
    }
    @RequestMapping(value = "/delete/{id}")
    public boolean DeleteRtmp(@PathVariable Integer id){
        return rtmpaRtspMapper.DeleteRtmp(id);
    }
    @RequestMapping(value = "/update")
    public RtmpConfig UpdateRtmp(@RequestParam(value ="id",required = true)Integer Id,
                              @RequestParam(value ="url",required = true)String url){
        RtmpConfig newrtmp = new RtmpConfig();
        newrtmp.setId(Id);
        newrtmp.setUrl(url);
        rtmpaRtspMapper.updateRtmp(newrtmp);
        return newrtmp;
    }
}
