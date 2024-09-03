package com.example.icar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class icarController {
    @GetMapping("/")
    public String main(){
        return "index";
    }
}
