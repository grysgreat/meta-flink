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
@CrossOrigin
public class KafKAConfigController {
    @Autowired
    private KafKAService kafKAService;

    @RequestMapping(value = "/FindAllKafKAConfigs",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public List<KafKAConfig> FindAll() {


        return kafKAService.FindAllKafKaConfigs();

    }

    @RequestMapping(value = "/FindKafKAById/{id}",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public KafKAConfig FindById(@PathVariable Integer id) {

        return kafKAService.FindKafKaConfigById(id);
    }

    @RequestMapping(value = "/DeleteAllKafKAConfigs",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public Boolean DeleteAll() {
        kafKAService.DeleteAllKafKAConfigs();
        return true;
    }

    @RequestMapping(value = "/DeleteKafKAConfigByid/{id}",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public boolean DeleteById(@PathVariable Integer id) {
        kafKAService.DeleteKafKAConfigById(id);
        return true;
    }

    @RequestMapping(value = "/Insert",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public KafKAConfig Insert(@RequestParam(value = "id",required = false) Integer id,
                         @RequestParam(value = "Url") String url,
                         @RequestParam(value = "Topic") String Topic,
                         @RequestParam(value = "port") Integer DestPort)
    {
        KafKAConfig kaConfig=new KafKAConfig();
        kaConfig.setId(id);
        kaConfig.setPort(DestPort);
        kaConfig.setUrl(url);
        kaConfig.setTopic(Topic);
        kafKAService.InsertKafKAConfig(kaConfig);
        return kaConfig;
    }
    @RequestMapping(value = "/update",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
    public KafKAConfig UpdateKafKAConfig(@RequestParam(value = "id",required = true) Integer id, @RequestParam(value = "Url",required = false) String url,
                                    @RequestParam(value = "Topic",required = false) String Topic, @RequestParam(value = "port",required = false) Integer DestPort)
    {
        KafKAConfig kafKAConfig=new KafKAConfig();
        kafKAConfig.setTopic(Topic);
        kafKAConfig.setPort(DestPort);
        kafKAConfig.setId(id);
        kafKAConfig.setUrl(url);
        kafKAService.UpdateKafKAConfig(kafKAConfig);
        return kafKAConfig;
    }

}
