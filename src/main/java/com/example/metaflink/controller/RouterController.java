package com.example.metaflink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class RouterController {
    @RequestMapping({"/","/login","/index"})
    public String websshpage() {
        return "webssh";
    }

}
