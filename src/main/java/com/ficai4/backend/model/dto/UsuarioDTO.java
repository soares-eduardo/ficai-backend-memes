package com.ficai4.backend.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsuarioDTO {

    //TODO Validar os campos
    
    private UUID id;

    private String nome;

    private Integer tipoPerfil;

    private List<VisitaDTO> visitas = new ArrayList<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(UUID id, String nome, Integer tipoPerfil, List<VisitaDTO> visitas) {
        this.id = id;
        this.nome = nome;
        this.tipoPerfil = tipoPerfil;
        this.visitas = visitas;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipoPerfil() {
        return this.tipoPerfil;
    }

    public void setTipoPerfil(Integer tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public List<VisitaDTO> getVisitas() {
        return this.visitas;
    }

    public void setVisitas(List<VisitaDTO> visitas) {
        this.visitas = visitas;
    }
}
