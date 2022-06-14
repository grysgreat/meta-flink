package com.example.metaflink.controller;

import com.example.metaflink.Service.SocketService;
import com.example.metaflink.database.config.RedisConfig1;
import com.example.metaflink.database.config.Socket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "接口管理")
@RestController
@RequestMapping("/Socket")
@CrossOrigin
public class SocketController {
    @Autowired
    private SocketService socketService;

    @RequestMapping("/FindAllSocket")
    @ApiOperation(value = "获取接口信息",notes = "获取全部接口信息")
    public List<Socket> findAll()
    {
        return socketService.ListAllSocket();
    }

    @RequestMapping("/FindSocketByid/{id}")
    @ApiOperation(value = "获取接口信息",notes="根据Id值获取接口信息")
    public Socket findSokcetbyid(@PathVariable Integer id)
    {
        Socket socket=socketService.ListSocketById(id);

        return socket;
    }
    @RequestMapping("/DeleteSocketByid/{id}")
    @ApiOperation(value = "删除接口信息",notes="根据给定的Id值删除接口信息")
    public boolean deleteSocketByid(@PathVariable Integer id)
    {
        socketService.DeleteSocketById(id);
        System.out.println(id);
        return true;
    }
    @RequestMapping("/DeleteAll")
    @ApiOperation(value = "删除接口信息",notes="删除全部接口信息")
    public String deleteAllSocket()
    {
        socketService.DeleteAllSocket();
        return "Successfully Delete!";
    }
    @RequestMapping("/insert")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "接口编号", required = false, example = "1"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "url", value = "URL", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "port", value = "端口号", required = false, example = "3306")

    })
    @ApiOperation(value = "插入新的接口信息",notes="根据传过来的接口信息来插入一个新的接口详细信息")
    public Socket Insert(@RequestParam(value ="id",required = false)Integer id, @RequestParam(value="url") String url,
                         @RequestParam(value="port")Integer Port)
    {
       Socket socket=new Socket();
       socket.setId(id);
       socket.setPort(Port);
       socket.setUrl(url);
       socketService.InsertSocket(socket);
        return socket;
    }
    @RequestMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "id", value = "接口编号", required =true, example = "1"),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "url", value = "URL", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "port", value = "端口号", required = false, example = "3306")

    })
    @ApiOperation(value = "更新接口信息",notes="根据url的id来指定更新对象，并根据传过来的接口信息来更新接口详细信息")
    public Socket UpdateRedisConfig(@RequestParam(value ="id",required = true)Integer id, @RequestParam(value="url",required = false) String url,
                                    @RequestParam(value="port",required = false)Integer Port)
    {
        Socket socket=new Socket();
        socket.setUrl(url);
        socket.setId(id);
        socket.setPort(Port);
        socketService.UpdateSocket(socket);
        return socket;
    }

}
