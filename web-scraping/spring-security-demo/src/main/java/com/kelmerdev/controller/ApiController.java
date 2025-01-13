package com.kelmerdev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Este es un endpoint público.";
    }

    @GetMapping("/private")
    public String privateEndpoint() {
        return "Este es un endpoint protegido. Solo usuarios autenticados pueden acceder.";
    }
}
