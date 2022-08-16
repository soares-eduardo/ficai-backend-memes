package com.ficai4.backend.model;

public class Usuario {
    
    //TODO Efetuar validação dos campos nesta camada

    private String cpf;
    private String nome;
    private String perfil;

    public Usuario() {

    }

    public Usuario(String cpf, String nome, String perfil) {
        this.cpf = cpf;
        this.nome = nome;
        this.perfil = perfil;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
