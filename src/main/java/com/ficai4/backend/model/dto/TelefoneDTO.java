package com.ficai4.backend.model.dto;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ficai4.utils.LengthMessages;
import com.ficai4.utils.NullMessages;

public class TelefoneDTO {

    private UUID id;

    @NotNull(message = "DDD " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 3, min = 3, message = LengthMessages.DDD_LENGTH_VALIDATION)
    private String ddd;

    @NotNull(message = "Numero " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 9, min = 9, message = LengthMessages.NUMERO_LENGTH_VALIDATION)
    private String numero;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    public TelefoneDTO() {
    }

    public TelefoneDTO(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
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
}
