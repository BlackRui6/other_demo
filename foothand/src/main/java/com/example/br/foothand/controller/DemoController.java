package com.example.br.foothand.controller;


import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@Slf4j
@RestController
public class DemoController {



    @GetMapping("/hello")
    private String demoService(){

        return "<h1>Hello HandFoot !<h1>" +
                "<h2> First <h2>" +
                "";

    }
}
