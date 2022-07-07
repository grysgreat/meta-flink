package com.example.metaflink.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/base")
@CrossOrigin
public class HellowrodController {

    @RequestMapping(value ="/hello",method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public String Hellowrod(){
        return "Helloworld";
    }
}
