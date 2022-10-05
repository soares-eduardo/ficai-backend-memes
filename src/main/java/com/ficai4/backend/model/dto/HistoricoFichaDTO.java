package com.ficai4.backend.model.dto;

import java.time.LocalDate;
import java.util.UUID;

public class HistoricoFichaDTO {

    //TODO Validar os campos

    private UUID id;

    private LocalDate dataCadastro;

    private String status;

    private String responsavel;

    private FichaDTO ficha;

    public HistoricoFichaDTO() {
    }

    public HistoricoFichaDTO(LocalDate dataCadastro, String status, String responsavel, FichaDTO ficha) {
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.responsavel = responsavel;
        this.ficha = ficha;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsavel() {
        return this.responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public FichaDTO getFicha() {
        return this.ficha;
    }

    public void setFicha(FichaDTO ficha) {
        this.ficha = ficha;
    }
        
}
