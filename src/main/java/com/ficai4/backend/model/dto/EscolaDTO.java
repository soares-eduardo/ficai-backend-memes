package com.ficai4.backend.model.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ficai4.utils.LengthMessages;
import com.ficai4.utils.NullMessages;

public class EscolaDTO {

    private UUID id;

    @NotNull(message = "Escola INEP " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 8, min = 8, message = LengthMessages.ESCOLA_INEP_VALIDATION)
    private String escolaInep;

    @NotNull(message = "Nome " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 50, message = LengthMessages.NOME_ESCOLA_VALIDATION)
    private String nome;

    @NotNull(message = "CEP " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 9, min = 9, message = LengthMessages.CEP_LENGTH_VALIDATION)
    private String cep;

    @NotNull(message = "Logradouro " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 80, message = LengthMessages.LOGRADOURO_LENGTH_VALIDATION)
    private String logradouro;

    @NotNull(message = "Número " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 9, message = LengthMessages.NUMERO_LENGTH_VALIDATION)
    private String numero;

    @Length(max = 50, message = LengthMessages.COMPLEMENTO_LENGTH_VALIDATION)
    private String complemento;

    @NotNull(message = "Bairro " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 50, message = LengthMessages.BAIRRO_LENGTH_VALIDATION)
    private String bairro;

    @NotNull(message = "Cidade " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 50, message = LengthMessages.CIDADE_VALIDATION)
    private String cidade;

    @NotNull(message = "Estado " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 2, message = LengthMessages.ESTADO_VALIDATION)
    private String estado;

    public EscolaDTO() {
    }

    public EscolaDTO(String escolaInep, String nome, String cep, String logradouro, String numero,
            String complemento, String bairro, String cidade, String estado) {
        this.escolaInep = escolaInep;
        this.nome = nome;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEscolaInep() {
        return this.escolaInep;
    }

    public void setEscolaInep(String escolaInep) {
        this.escolaInep = escolaInep;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
