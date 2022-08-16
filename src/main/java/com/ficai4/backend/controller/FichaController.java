package com.ficai4.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ficha")
public class FichaController {
    
    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }
}
