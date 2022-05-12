package com.example.metaflink.controller;

import com.example.metaflink.Service.KafKAService;
import com.example.metaflink.database.config.KafKAConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/KafKA")
public class KafKAConfigController {
    @Autowired
    private KafKAService kafKAService;

    @GetMapping("/FindAllKafKAConfigs")
    public String FindAll() {
        List<KafKAConfig> kafKAConfigs = kafKAService.FindAllKafKaConfigs();
        try {
            String databasejsons = new ObjectMapper().writeValueAsString(kafKAConfigs);
            return databasejsons;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("/FindKafKAById/{id}")
    public String FindById(@PathVariable Integer id) {
        KafKAConfig kafKAConfig = kafKAService.FindKafKaConfigById(id);
        try {
            String databasejsons = new ObjectMapper().writeValueAsString(kafKAConfig);
            return databasejsons;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("/DeleteAllKafKAConfigs")
    public String DeleteAll() {
        kafKAService.DeleteAllKafKAConfigs();
        return "Successfully Deleted!";
    }

    @GetMapping("/DeleteKafKAConfigByid/{id}")
    public String DeleteById(@PathVariable Integer id) {
        kafKAService.DeleteKafKAConfigById(id);
        return "SuccessfullyDeleted";
    }

    @GetMapping("/Insert")
    public String Insert(@RequestParam(value = "id") Integer id, @RequestParam(value = "Ip") String ip,
                         @RequestParam(value = "Topic") String Topic, @RequestParam(value = "DestPort") Integer DestPort)
    {
        KafKAConfig kaConfig=new KafKAConfig();
        kaConfig.setId(id);
        kaConfig.setDestPort(DestPort);
        kaConfig.setIp(ip);
        kaConfig.setTopic(Topic);
        kafKAService.InsertKafKAConfig(kaConfig);
        return "Successfully Inserted";
    }
    @RequestMapping("/update")
    public String UpdateKafKAConfig(@RequestParam(value = "id",required = true) Integer id, @RequestParam(value = "Ip",required = false) String ip,
                                    @RequestParam(value = "Topic",required = false) String Topic, @RequestParam(value = "DestPort",required = false) Integer DestPort)
    {
        KafKAConfig kafKAConfig=new KafKAConfig();
        kafKAConfig.setTopic(Topic);
        kafKAConfig.setDestPort(DestPort);
        kafKAConfig.setId(id);
        kafKAConfig.setIp(ip);
        kafKAService.UpdateKafKAConfig(kafKAConfig);
        return "Update Successfully";
    }

}
