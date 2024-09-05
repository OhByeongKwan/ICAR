package com.example.icar.controller;

import com.example.icar.domain.Icar;
import com.example.icar.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class mainApiController {
    private final MainService mainService;

    @PostMapping("/test")
    public String  test(@RequestBody Icar icar){
        System.out.println(icar);
        return mainService.test(icar);
    }
}
