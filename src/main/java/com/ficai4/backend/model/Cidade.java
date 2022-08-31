package com.ficai4.backend.model;

public class Cidade {
    private Long id;
    private String codigoIbge;
    private String nome;
    private String ufNome;
    private String ufSigla;

    public Cidade() {
    }

    public Cidade(Long id, String codigoIbge, String nome, String ufNome, String ufSigla) {
        this.id = id;
        this.codigoIbge = codigoIbge;
        this.nome = nome;
        this.ufNome = ufNome;
        this.ufSigla = ufSigla;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoIbge() {
        return this.codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUfNome() {
        return this.ufNome;
    }

    public void setUfNome(String ufNome) {
        this.ufNome = ufNome;
    }

    public String getUfSigla() {
        return this.ufSigla;
    }

    public void setUfSigla(String ufSigla) {
        this.ufSigla = ufSigla;
    }
}
