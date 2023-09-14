package com.ficai4.backend.model.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.ficai4.utils.LengthMessages;
import com.ficai4.utils.NullMessages;

public class MotivoInfrequenciaDTO {

    private Long id;

    @NotNull(message = "Tipo " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 150, message = LengthMessages.TIPO_VALIDATION)
    private String tipo;

    @NotNull(message = "Subtipo " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 150, message = LengthMessages.SUBTIPO_VALIDATION)
    private String subTipo;

    @NotNull(message = "Recorrencias para envio " + NullMessages.NULL_NOT_ALLOWED)
    private Integer recorrenciasParaEnvio;

    public MotivoInfrequenciaDTO() {
    }

    public MotivoInfrequenciaDTO(String tipo, String subTipo, Integer recorrenciasParaEnvio) {
        this.tipo = tipo;
        this.subTipo = subTipo;
        this.recorrenciasParaEnvio = recorrenciasParaEnvio;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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
