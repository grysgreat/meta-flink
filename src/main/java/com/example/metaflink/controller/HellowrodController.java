package com.example.metaflink.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/base")
public class HellowrodController {

    @RequestMapping(value ="/hello")
    public String Hellowrod(){
        return "Helloworld";
    }
}
