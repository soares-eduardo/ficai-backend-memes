package com.ficai4.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.service.FichaService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/ficha")
public class FichaController {

    @Autowired
    FichaService fichaService;

    // @GetMapping
    // public String helloWorld() {
    //     return "Hello World";
    // }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FichaDTO>> findAll() {
        return ResponseEntity.ok(fichaService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FichaDTO> createFicha(@RequestBody FichaDTO fichaDto) {
       return ResponseEntity.ok(fichaService.createFicha(fichaDto)); 
    }
}
