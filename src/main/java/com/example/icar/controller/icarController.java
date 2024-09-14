package com.example.icar.controller;

import com.example.icar.domain.Item;
import com.example.icar.repasitory.MainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class icarController {
    private final MainRepository mainRepository;
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

    @GetMapping("/detail")
    public String detail(@RequestParam("idx") Long idx, Model model){
        Optional<Item> getOne = mainRepository.findById(idx);
        Item item = getOne.orElse(null);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String currentTime = LocalDateTime.now().format(formatter);
        model.addAttribute("item", item);
        model.addAttribute("currentTime", currentTime);
        return "detail";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("idx") Long idx, Model model){
        Optional<Item> getOne = mainRepository.findById(idx);
        Item item = getOne.orElse(null);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String currentTime = LocalDateTime.now().format(formatter);
        model.addAttribute("item", item);
        model.addAttribute("currentTime", currentTime);
        return "edit";
    }
}
