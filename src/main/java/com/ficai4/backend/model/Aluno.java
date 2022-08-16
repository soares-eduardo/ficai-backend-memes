package com.ficai4.backend.model;

import java.time.LocalDate;

public class Aluno {
    
    //TODO Efetuar validação dos campos nesta camada

    private String cpf;
    private String nome;
    private String telefone;
    private String responsavelLegal;
    private String beneficios;
    private String situacao;
    private Endereco endereco;
    private LocalDate dataNascimento;
    private Escola escola;

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

    public Endereco getEndereco() {
        return endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Escola getEscola() {
        return escola;
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

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
}
