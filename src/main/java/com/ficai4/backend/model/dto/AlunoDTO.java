package com.ficai4.backend.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

// import com.ficai4.backend.model.Endereco;
// import com.ficai4.backend.model.Escola;

public class AlunoDTO {
    
    //TODO Efetuar validação dos campos nesta camada

    private Long id;

    @NotNull
    private String cpf;

    @NotNull
    private String nome;

    @NotNull
    private String telefone;
    
    @NotNull
    private String responsavelLegal;
    
    @NotNull
    private String beneficios;
    
    @NotNull
    private String situacao;

    // private Endereco endereco;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    // private Escola escola;

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getResponsavelLegal() {
        return responsavelLegal;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public String getSituacao() {
        return situacao;
    }

    // public Endereco getEndereco() {
    //     return endereco;
    // }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // public Escola getEscola() {
    //     return escola;
    // }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setResponsavelLegal(String responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    // public void setEndereco(Endereco endereco) {
    //     this.endereco = endereco;
    // }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // public void setEscola(Escola escola) {
    //     this.escola = escola;
    // }
}
