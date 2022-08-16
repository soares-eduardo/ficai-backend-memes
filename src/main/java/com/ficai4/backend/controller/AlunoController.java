package com.ficai4.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
    
    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }
}
