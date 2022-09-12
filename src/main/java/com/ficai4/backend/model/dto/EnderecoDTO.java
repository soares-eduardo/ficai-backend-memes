package com.ficai4.backend.model.dto;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ficai4.utils.LengthMessages;
import com.ficai4.utils.NullMessages;

public class EnderecoDTO {

    private UUID id;

    @NotNull(message = "CEP " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 9, min = 9, message = LengthMessages.CEP_LENGTH_VALIDATION)
    private String cep;

    @NotNull(message = "Logradouro " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 80, message = LengthMessages.LOGRADOURO_LENGTH_VALIDATION)
    private String logradouro;

    @NotNull(message = "Número " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 9, message = LengthMessages.NUMERO_ENDERECO_LENGTH_VALIDATION)
    private String numero;

    @NotNull(message = "Bairro " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 50, message = LengthMessages.BAIRRO_LENGTH_VALIDATION)
    private String bairro;

    @NotNull(message = "Complemento " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 50, message = LengthMessages.COMPLEMENTO_LENGTH_VALIDATION)
    private String complemento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @Valid
    @NotNull(message = "Cidade " + NullMessages.NULL_NOT_ALLOWED)
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
