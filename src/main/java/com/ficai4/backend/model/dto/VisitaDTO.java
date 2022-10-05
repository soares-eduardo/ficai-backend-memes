package com.ficai4.backend.model.dto;

import java.time.LocalDate;
import java.util.UUID;

public class VisitaDTO {

    //TODO Validar os campos

    private UUID id;

    private String descricao;

    private String responvelVisita;

    private Boolean teveSucesso;

    private FichaDTO ficha;

    private UsuarioDTO usuario;

    private LocalDate dataVisita;

    public VisitaDTO() {
    }

    public VisitaDTO(String descricao, String responvelVisita, Boolean teveSucesso, FichaDTO ficha, UsuarioDTO usuario, LocalDate dataVisita) {
        this.descricao = descricao;
        this.responvelVisita = responvelVisita;
        this.teveSucesso = teveSucesso;
        this.ficha = ficha;
        this.usuario = usuario;
        this.dataVisita = dataVisita;
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

    public String getResponvelVisita() {
        return this.responvelVisita;
    }

    public void setResponvelVisita(String responvelVisita) {
        this.responvelVisita = responvelVisita;
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

    public FichaDTO getFicha() {
        return this.ficha;
    }

    public void setFicha(FichaDTO ficha) {
        this.ficha = ficha;
    }

    public UsuarioDTO getUsuario() {
        return this.usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataVisita() {
        return this.dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
    }    
}
