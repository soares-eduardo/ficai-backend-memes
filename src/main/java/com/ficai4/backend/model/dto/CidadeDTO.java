package com.ficai4.backend.model.dto;

import java.util.List;

public class CidadeDTO {

    private String codigoIbge;

    private String nome;

    private String ufNome;

    private String ufSigla;

    public CidadeDTO() {
    }

    public CidadeDTO(String codigoIbge, String nome, String ufNome, String ufSigla, List<EnderecoDTO> endereco) {
        this.codigoIbge = codigoIbge;
        this.nome = nome;
        this.ufNome = ufNome;
        this.ufSigla = ufSigla;
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
