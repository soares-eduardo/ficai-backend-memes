package com.ficai4.backend.model;

import java.time.LocalDate;

public class Telefone {
    private Long id;
    private Long alunoId;
    private String ddd;
    private String numero;
    private LocalDate dataCadastro;

    public Telefone() {

    }

    public Telefone(Long id, Long alunoId, String ddd, String numero, LocalDate dataCadastro) {
        this.id = id;
        this.alunoId = alunoId;
        this.ddd = ddd;
        this.numero = numero;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlunoId() {
        return this.alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public String getDdd() {
        return this.ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
