package com.kelmerdev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping("/public")
    public String getProduct(){
        return "Lista de productos de la tienda";
    }

    @PostMapping("/create")
    public String createProduct(){
        return "Producto creado";
    }
}
