package com.example.icar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class icarController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/regist")
    public String regist(){
        return "regist";
    }
}
