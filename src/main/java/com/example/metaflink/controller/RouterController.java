package com.example.metaflink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping({"/","/login","/index"})
    public String websshpage() {
        return "webssh";
    }

}
