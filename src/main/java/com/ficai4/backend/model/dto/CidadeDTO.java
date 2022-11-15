package com.ficai4.backend.model.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ficai4.utils.LengthMessages;
import com.ficai4.utils.NullMessages;

public class CidadeDTO {

    @NotNull(message = "Código IBGE " + NullMessages.NULL_NOT_ALLOWED)
    @Length(min = 7, max = 7, message = LengthMessages.CODIGO_IBGE_VALIDATION)
    private String codigoIbge;

    @NotNull(message = "Nome " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 80, message = LengthMessages.NOME_CIDADE_VALIDATION)
    private String nome;

    @NotNull(message = "UF Sigla " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 2, min = 2, message = LengthMessages.UF_SIGLA_VALIDATION)
    private String ufSigla;

    public CidadeDTO() {
    }

    public CidadeDTO(String codigoIbge, String nome, String ufSigla) {
        this.codigoIbge = codigoIbge;
        this.nome = nome;
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

    public String getUfSigla() {
        return this.ufSigla;
    }

    public void setUfSigla(String ufSigla) {
        this.ufSigla = ufSigla;
    }
}
