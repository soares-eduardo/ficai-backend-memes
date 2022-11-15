package com.ficai4.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_visita")
public class Visita implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, name = "descricao", length = 500)
    private String descricao;

    @Column(nullable = false, name = "responsavel_visita", length = 80)
    private String responsavelVisita;

    @Column(nullable = false, name = "teve_sucesso")
    private Boolean teveSucesso;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ficha_id")
    @JsonBackReference
    private Ficha ficha;

    @Column(nullable = false, name = "data_visita")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataVisita;

    public Visita() {
    }

    public Visita(String descricao, String responsavelVisita, Boolean teveSucesso, Ficha ficha, LocalDate dataVisita) {
        this.descricao = descricao;
        this.responsavelVisita = responsavelVisita;
        this.teveSucesso = teveSucesso;
        this.ficha = ficha;
        this.dataVisita = dataVisita;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavelVisita() {
        return responsavelVisita;
    }

    public void setResponsavelVisita(String responsavelVisita) {
        this.responsavelVisita = responsavelVisita;
    }

    public Boolean getTeveSucesso() {
        return teveSucesso;
    }

    public void setTeveSucesso(Boolean teveSucesso) {
        this.teveSucesso = teveSucesso;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public LocalDate getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.dataVisita = dataVisita;
    }
}
