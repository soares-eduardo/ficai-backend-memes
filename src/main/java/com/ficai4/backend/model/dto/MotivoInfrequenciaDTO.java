package com.ficai4.backend.model.dto;

import java.util.UUID;

public class MotivoInfrequenciaDTO {
    
    //TODO Validar os campos

    private UUID id;

    private String tipo;

    private String subTipo;

    private Integer recorrenciasParaEnvio;

    public MotivoInfrequenciaDTO() {
    }
    
    public MotivoInfrequenciaDTO(String tipo, String subTipo, Integer recorrenciasParaEnvio) {
        this.tipo = tipo;
        this.subTipo = subTipo;
        this.recorrenciasParaEnvio = recorrenciasParaEnvio;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubTipo() {
        return this.subTipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public Integer getRecorrenciasParaEnvio() {
        return this.recorrenciasParaEnvio;
    }

    public void setRecorrenciasParaEnvio(Integer recorrenciasParaEnvio) {
        this.recorrenciasParaEnvio = recorrenciasParaEnvio;
    }
}
