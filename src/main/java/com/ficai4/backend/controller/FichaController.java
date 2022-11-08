package com.ficai4.backend.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ficai4.backend.enums.Status;
import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.model.dto.FichaInsertDTO;
import com.ficai4.backend.model.dto.VisitaDTO;
import com.ficai4.backend.service.FichaService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/ficha")
public class FichaController {

    @Autowired
    FichaService fichaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<FichaDTO>> findAll() {
        return ResponseEntity.ok(fichaService.findAll());
    }

    @GetMapping(value = "/buscarFicha", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FichaDTO>> findByAnyWord(@RequestParam("palavra") String palavra) {
        String wordLowerCase = palavra.toLowerCase();
        return ResponseEntity.ok().body(fichaService.findByAnyWord(wordLowerCase));
    }

    @GetMapping(value = "/alunoId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FichaDTO> findFichaByAlunoId(@RequestParam("alunoId") UUID alunoId) {
        return ResponseEntity.ok(fichaService.findFichaByAlunoId(alunoId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FichaInsertDTO> createFicha(@Valid @RequestBody FichaInsertDTO fichaInsertDTO) {
       return ResponseEntity.status(HttpStatus.CREATED).body(fichaService.createFicha(fichaInsertDTO)); 
    }

    @PatchMapping(value = "/visita", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VisitaDTO> createVisita(@Valid @RequestBody VisitaDTO visitaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fichaService.createVisita(visitaDto));
    }

    @PostMapping(value = "/updateStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FichaDTO> updateStatusFicha(@Valid @RequestParam UUID idFicha, Status statusFicha) {
        return ResponseEntity.ok(fichaService.updateStatusFicha(idFicha, statusFicha));
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
