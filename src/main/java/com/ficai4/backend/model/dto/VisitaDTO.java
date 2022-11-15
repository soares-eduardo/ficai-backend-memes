package com.ficai4.backend.model.dto;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ficai4.utils.LengthMessages;
import com.ficai4.utils.NullMessages;

public class VisitaDTO {

    private UUID id;

    private UUID fichaId;

    @NotNull(message = "Descrição " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 200, message = LengthMessages.CEP_LENGTH_VALIDATION)
    private String descricao;

    @NotNull(message = "Responsável pela vista " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 80, message = LengthMessages.CEP_LENGTH_VALIDATION)
    private String responsavelVisita;

    @NotNull(message = "Teve sucesso " + NullMessages.NULL_NOT_ALLOWED)
    private Boolean teveSucesso;

    private LocalDate dataVisita;

    public VisitaDTO() {
    }

    public VisitaDTO(String descricao, String responsavelVisita, Boolean teveSucesso, LocalDate dataVisita) {
        this.descricao = descricao;
        this.responsavelVisita = responsavelVisita;
        this.teveSucesso = teveSucesso;
        this.dataVisita = dataVisita;
    }

    public VisitaDTO(String descricao, String responsavelVisita, Boolean teveSucesso, LocalDate dataVisita,
            UUID fichaId) {
        this.descricao = descricao;
        this.responsavelVisita = responsavelVisita;
        this.teveSucesso = teveSucesso;
        this.dataVisita = dataVisita;
        this.fichaId = fichaId;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavelVisita() {
        return this.responsavelVisita;
    }

    public void setResponsavelVisita(String responsavelVisita) {
        this.responsavelVisita = responsavelVisita;
    }

    public Boolean isTeveSucesso() {
        return this.teveSucesso;
    }

    public Boolean getTeveSucesso() {
        return this.teveSucesso;
    }

    public void setTeveSucesso(Boolean teveSucesso) {
        this.teveSucesso = teveSucesso;
    }

    public LocalDate getDataVisita() {
        return this.dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
    }

    public UUID getFichaId() {
        return fichaId;
    }

    public void setFichaId(UUID fichaId) {
        this.fichaId = fichaId;
    }
}
