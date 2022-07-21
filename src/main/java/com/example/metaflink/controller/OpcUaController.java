package com.example.metaflink.controller;

import com.example.metaflink.database.config.OpcUaConfig;
import com.example.metaflink.mapper.OpcUaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OpcUa")
@CrossOrigin
public class OpcUaController {
    @Autowired
    private OpcUaMapper opcUaMapper;

    @RequestMapping(value = "/all")
    public List<OpcUaConfig> findAllOpcUa(){
        return opcUaMapper.AllOpcUaConfig();
    }

    @RequestMapping(value = "/findOpcUaConfigById/{id}")
    public OpcUaConfig findHdfsConfigById(@PathVariable Integer id){
        return opcUaMapper.ListOpcUaConfigById(id);
    }


    @RequestMapping(value = "/insert")
    public boolean InsertOpcUa(
                               @RequestParam(value="serverUrl",required = false) String serverUrl,
                               @RequestParam(value ="userName",required = false)String userName,
                               @RequestParam(value="password",required = false) String password,
                               @RequestParam(value="isAnonymous",required = false) Boolean isAnonymous,
                               @RequestParam(value="identifier",required = false) String identifier){
        OpcUaConfig opcUaConfig = new OpcUaConfig();
        opcUaConfig.setServerUrl(serverUrl);
        opcUaConfig.setUserName(userName);
        opcUaConfig.setPassword(password);
        opcUaConfig.setIdentifier(identifier);
        opcUaConfig.setIsAnonymous(isAnonymous);
        return opcUaMapper.InsertOpcUaConfig(opcUaConfig);
    }

    @RequestMapping(value = "/delete/{id}")
    public boolean DeleteOpcUa(@PathVariable Integer id){
        return opcUaMapper.DeleteOpcUaConfigById(id);
    }

    @RequestMapping(value = "/update")
    public OpcUaConfig UpdateOpcUa(@RequestParam(value ="id",required = true)Integer id,
                                   @RequestParam(value="serverUrl",required = false) String serverUrl,
                                   @RequestParam(value = "userName",required = false)String userName,
                                   @RequestParam(value="password",required = false) String password,
                                   @RequestParam(value="isAnonymous",required = false) Boolean isAnonymous,
                                   @RequestParam(value="identifier",required = false) String identifier){
        OpcUaConfig opcUaConfig = new OpcUaConfig();
        opcUaConfig.setId(id);
        opcUaConfig.setServerUrl(serverUrl);
        opcUaConfig.setUserName(userName);
        opcUaConfig.setPassword(password);
        opcUaConfig.setIdentifier(identifier);
        opcUaConfig.setIsAnonymous(isAnonymous);
        opcUaMapper.UpdateOpcUaConfig(opcUaConfig);
        return opcUaConfig;
    }
}
