package com.example.metaflink.controller;

import com.example.metaflink.Service.UserConfigService;
import com.example.metaflink.Service.UserConfigServiceImpl;
import com.example.metaflink.database.config.Socket;
import com.example.metaflink.database.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/UserConfig")
@CrossOrigin
public class UserConfigController {
    @Autowired
    UserConfigService userConfigService;

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


}
