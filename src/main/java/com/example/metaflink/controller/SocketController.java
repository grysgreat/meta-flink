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
    @GetMapping("/FindAllSocket")
    public String findAll()
    {
        List<Socket> sockets=socketService.ListAllSocket();
        try {
            String  databasejsons=new ObjectMapper().writeValueAsString(sockets);
            return databasejsons;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
    @GetMapping("/FindSocketByid/{id}")
    public String findSokcetbyid(@PathVariable Integer id)
    {
        Socket socket=socketService.ListSocketById(id);
        try {
            String dabasejson=new ObjectMapper().writeValueAsString(socket);
            return dabasejson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
    @GetMapping("/DeleteSocketByid/{id}")
    public String deleteSocketByid(@PathVariable Integer id)
    {
        socketService.DeleteSocketById(id);
        return "SuccessfullyDeleted!";
    }
    @GetMapping("/DeleteAll")
    public String deleteAllSocket()
    {
        socketService.DeleteAllSocket();
        return "Successfully Delete!";
    }
    @GetMapping("/insert")
    public String Insert(@RequestParam(value ="id")Integer id, @RequestParam(value="url") String url,
                         @RequestParam(value="port")Integer Port)
    {
       Socket socket=new Socket();
       socket.setId(id);
       socket.setPort(Port);
       socket.setUrl(url);
       socketService.InsertSocket(socket);
        return "Successfully Inserted";
    }
    @RequestMapping("/update")
    public String UpdateRedisConfig(@RequestParam(value ="id",required = true)Integer id, @RequestParam(value="url",required = false) String url,
                                    @RequestParam(value="port",required = false)Integer Port)
    {
        Socket socket=new Socket();
        socket.setUrl(url);
        socket.setId(id);
        socket.setPort(Port);
        socketService.UpdateSocket(socket);
        return "Update Successfully";
    }

}
