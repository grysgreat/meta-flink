package com.example.metaflink.controller;

import com.example.metaflink.Service.SocketService;
import com.example.metaflink.database.config.RedisConfig1;
import com.example.metaflink.database.config.Socket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Socket")
public class SocketController {
    @Autowired
    private SocketService socketService;
    @RequestMapping(value = "/FindAllSocket",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public List<Socket> findAll()
    {
        return socketService.ListAllSocket();
    }
    @RequestMapping(value = "/FindSocketByid/{id}",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public Socket findSokcetbyid(@PathVariable Integer id)
    {
        Socket socket=socketService.ListSocketById(id);

        return socket;
    }
    @RequestMapping(value = "/DeleteSocketByid/{id}",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public boolean deleteSocketByid(@PathVariable Integer id)
    {
        socketService.DeleteSocketById(id);
        System.out.println(id);
        return true;
    }
    @RequestMapping(value = "/DeleteAll",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public String deleteAllSocket()
    {
        socketService.DeleteAllSocket();
        return "Successfully Delete!";
    }
    @RequestMapping(value = "/insert",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
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
    @RequestMapping(value = "/update",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
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
