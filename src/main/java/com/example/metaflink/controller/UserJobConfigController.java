package com.example.metaflink.controller;

import com.example.metaflink.Service.UserConfigService;
import com.example.metaflink.database.config.UserConfig;
import com.example.metaflink.database.config.UserJobConfig;
import com.example.metaflink.mapper.UserJobConfigMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/UserJobConfig")
@CrossOrigin
public class UserJobConfigController {
    @Autowired
    UserJobConfigMapper userJobConfigMapper;

    @RequestMapping(value = "/CheckJob",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<String> UserConfigLogin (HttpServletRequest request)
    {
        HttpSession sessoin=request.getSession();

        UserConfig userConfig = (UserConfig) sessoin.getAttribute("LoginUser");

        List<UserJobConfig> userJobConfigs = userJobConfigMapper.ListJobById(userConfig.getId());


        //返回jobId列表
        List<String> jobNum = new ArrayList<String>();

        for (UserJobConfig userJobConfig : userJobConfigs) {
            jobNum.add(userJobConfig.getJobId());
        }

        return jobNum;
    }

    @RequestMapping(value = "/addjobid" )
    public boolean AddUserJobid(@RequestParam(value ="jobid",required = true)String Jobid,@RequestParam(value ="userid",required = true)int userid){
        UserJobConfig userJobConfig = new UserJobConfig();
        userJobConfig.setJobId(Jobid);
        userJobConfig.setUserId(userid);
        this.userJobConfigMapper.InsertJob(userJobConfig);
        return true;
    }


    @RequestMapping(value = "/jobUsername")
    public String Findjobuser(@RequestParam(value ="jobid",required = true)String Jobid){
        String UserName =  this.userJobConfigMapper.FindJobuser(Jobid);
        if(UserName == null) UserName = "unKnow";
        return  UserName;
    }
}
