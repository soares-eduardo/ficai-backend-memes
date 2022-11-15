package com.ficai4.backend.model.dto;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ficai4.utils.NullMessages;

public class HistoricoFichaDTO {

    private UUID id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @NotNull(message = "Status " + NullMessages.NULL_NOT_ALLOWED)
    private Integer status;

    @NotNull(message = "Responsável " + NullMessages.NULL_NOT_ALLOWED)
    private Integer responsavel;

    public HistoricoFichaDTO() {
    }

    public HistoricoFichaDTO(LocalDate dataCadastro, Integer status, Integer responsavel) {
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.responsavel = responsavel;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getResponsavel() {
        return this.responsavel;
    }

    public void setResponsavel(Integer responsavel) {
        this.responsavel = responsavel;
    }
}
