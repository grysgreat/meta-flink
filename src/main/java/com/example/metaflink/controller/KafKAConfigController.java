package com.example.metaflink.controller;

import com.example.metaflink.Service.KafKAService;
import com.example.metaflink.database.config.KafKAConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "KafKA管理")
@RestController
@RequestMapping("/KafKA")
public class KafKAConfigController {
    @Autowired
    private KafKAService kafKAService;

    @RequestMapping(value = "/FindAllKafKAConfigs",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ApiOperation(value = "获取KafKA信息",notes = "获取全部KafKA信息")
    public List<KafKAConfig> FindAll() {


        return kafKAService.FindAllKafKaConfigs();

    }

    @RequestMapping(value = "/FindKafKAById/{id}",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ApiOperation(value = "获取KafKA信息",notes = "根据Id值获取对应KafKA信息")
    public KafKAConfig FindById(@PathVariable Integer id) {

        return kafKAService.FindKafKaConfigById(id);
    }

    @RequestMapping(value = "/DeleteAllKafKAConfigs",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ApiOperation(value = "删除KafKA信息",notes = "删除全部KafKA信息")
    public Boolean DeleteAll() {
        kafKAService.DeleteAllKafKAConfigs();
        return true;
    }

    @RequestMapping(value = "/DeleteKafKAConfigByid/{id}",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ApiOperation(value = "删除KafKA信息",notes = "根据Id值删除对应KafKA信息")
    public boolean DeleteById(@PathVariable Integer id) {
        kafKAService.DeleteKafKAConfigById(id);
        return true;
    }

    @RequestMapping(value = "/Insert",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "KafKA编号", required = false, example = "1"),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "Url", value = "URL", required =false),
                    @ApiImplicitParam(paramType = "query", dataType = "String", name = "Topic", value = "主题", required = false),
                    @ApiImplicitParam(paramType = "query", dataType = "Long", name = "port", value = "端口号", required = false)

            })
    @ApiOperation(value = "插入新的KafKA信息",notes="根据传过来的KafKA信息来插入一个新的KafKA详细信息")
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
    @RequestMapping(value = "/update",method = {RequestMethod.GET,RequestMethod.OPTIONS})
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
