package com.ficai4.backend.model.dto;

public class EnderecoDTO {

    private String cep;

    private String logradouro;

    private String numero;

    private String bairro;

    private String complemento;

    private CidadeDTO cidade;

    public EnderecoDTO() {
    }

    public EnderecoDTO(String cep, String logradouro, String numero, String bairro, String complemento, CidadeDTO cidade) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public CidadeDTO getCidade() {
        return this.cidade;
    }

    public void setCidade(CidadeDTO cidade) {
        this.cidade = cidade;
    }

}
