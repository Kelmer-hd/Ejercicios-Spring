package com.kelmerdev.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/public")
    private String getPublicEndpoint(){
        return "Hello this is public endpoint";
    }


    @GetMapping("/private")
    private String getPrivateEndpoint(){
        return "Hello this is private endpoint";
    }
}
