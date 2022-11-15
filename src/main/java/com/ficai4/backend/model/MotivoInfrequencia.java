package com.ficai4.backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_motivo_infrequencia")
public class MotivoInfrequencia implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, name = "tipo", length = 50)
    private String tipo;

    @Column(nullable = false, name = "subtipo", length = 50)
    private String subTipo;

    @Column(nullable = false, name = "recorrencias_para_envio")
    private Integer recorrenciasParaEnvio;

    public MotivoInfrequencia() {
    }

    public MotivoInfrequencia(String tipo, String subTipo, Integer recorrenciasParaEnvio) {
        this.tipo = tipo;
        this.subTipo = subTipo;
        this.recorrenciasParaEnvio = recorrenciasParaEnvio;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(String subTipo) {
        this.subTipo = subTipo;
    }

    public Integer getRecorrenciasParaEnvio() {
        return recorrenciasParaEnvio;
    }

    public void setRecorrenciasParaEnvio(Integer recorrenciasParaEnvio) {
        this.recorrenciasParaEnvio = recorrenciasParaEnvio;
    }
}
