package com.example.metaflink.controller;

import com.example.metaflink.Service.UserConfigService;
import com.example.metaflink.database.config.UserConfig;
import com.example.metaflink.database.config.UserJobConfig;
import com.example.metaflink.mapper.UserJobConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/UserJobConfig")
@CrossOrigin
public class UserJobConfigController {
    @Autowired
    UserJobConfigMapper userJobConfigMapper;

    @RequestMapping(value = "/CheckJob",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public UserConfig UserConfigLogin (HttpServletRequest request)
    {
        return null;
    }

    @RequestMapping(value = "addjobid" )
    public boolean AddUserJobid(@RequestParam(value ="jobid",required = true)String Jobid,@RequestParam(value ="userid",required = true)int userid){
        UserJobConfig userJobConfig = new UserJobConfig();
        userJobConfig.setJobId(Jobid);
        userJobConfig.setUserId(userid);
        this.userJobConfigMapper.InsertJob(userJobConfig);
        return true;
    }
}
