package com.example.docker.controller;

import com.example.docker.service.WebAppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
@AllArgsConstructor
class WebAppController {

    private final WebAppService service;

    @GetMapping("/test")
    public String getTest() {
        return service.getInfoTest();
    }
}
