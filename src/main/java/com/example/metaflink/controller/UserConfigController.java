package com.example.metaflink.controller;

import com.alibaba.fastjson.JSON;
import com.example.metaflink.Service.FlinkMiddleware;
import com.example.metaflink.Service.UserConfigService;
import com.example.metaflink.Service.UserConfigServiceImpl;
import com.example.metaflink.database.config.Socket;
import com.example.metaflink.database.config.UserConfig;
import com.example.metaflink.entity.FlinkJob;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/UserConfig")
@CrossOrigin
public class UserConfigController {
    @Autowired
    UserConfigService userConfigService;
    @Autowired
    FlinkMiddleware flinkMiddleware;

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public UserConfig UserConfigLogin (@RequestParam(value ="name",required = true)String name, @RequestParam(value="pwd",required = true) String password, HttpServletRequest request)
    {
        List<UserConfig> userConfigs = userConfigService.ListUserByNameandPwd(name,password);
        UserConfig userConfig = new UserConfig();
        userConfig.setId(-1);
        userConfig.setPriority(0);
        if(userConfigs.size()==0){
            return userConfig;
        }else{
            return userConfigs.get(0);
        }
    }

    //用户管理：所有用户列表
    @RequestMapping(value = "/listAllUser",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public List<UserConfig> ListAllUser (HttpServletRequest request)
    {
        List<UserConfig> userConfigs = userConfigService.ListAllUser();
        return userConfigs;
    }


    //用户管理：通过名字删除用户
    @RequestMapping(value = "/deleteUser",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public boolean DeleteUser (@RequestParam(value ="name",required = true)String name,HttpServletRequest request)
    {
        return userConfigService.DeleteUserByName(name);
    }

    //用户管理：插入新用户
    @RequestMapping(value = "/insertUser",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public void InsertUser (@RequestParam(value ="name",required = true)String name,@RequestParam(value="pwd",required = true) String password,@RequestParam(value="priority",required = true) Integer priority,HttpServletRequest request)
    {
        UserConfig userConfig= new UserConfig();
        userConfig.setName(name);
        userConfig.setPwd(password);
        userConfig.setPriority(priority);
        userConfigService.InsertUser(userConfig);
    }


    @RequestMapping(value = "/joblist",method ={RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS} )
    public String GetJobByuserid(@RequestParam(value ="userid",required = true)int userid){
        List<FlinkJob> joblist = this.flinkMiddleware.GetAllJobListApi(userid);
        HashMap<String,List<FlinkJob>> resjob = new HashMap<>();
        resjob.put("jobs",joblist);
        return JSON.toJSONString(resjob);
    }




}
