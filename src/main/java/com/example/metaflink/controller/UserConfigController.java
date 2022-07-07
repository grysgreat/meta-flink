package com.example.metaflink.controller;

import com.example.metaflink.Service.UserConfigService;
import com.example.metaflink.Service.UserConfigServiceImpl;
import com.example.metaflink.database.config.Socket;
import com.example.metaflink.database.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/UserConfig")
public class UserConfigController {
    @Autowired
    UserConfigService userConfigService;

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public UserConfig UserConfigLogin (@RequestParam(value ="name",required = true)String name, @RequestParam(value="password",required = false) String password, HttpServletRequest request)
    {
        List<UserConfig> userConfigs = userConfigService.ListUserByName(name);

        HttpSession sessoin=request.getSession();

        UserConfig userConfig = new UserConfig();
        userConfig.setId(0);
        if(userConfigs.size()!=0) {
            userConfig=userConfigs.get(0);
            if(!userConfig.getPwd().equals(password)){
                userConfig.setId(0);
            } else {
                //设置已登录用户session
                sessoin.setAttribute("LoginUser",userConfig);
            }
        }
        return userConfig;
    }


}
