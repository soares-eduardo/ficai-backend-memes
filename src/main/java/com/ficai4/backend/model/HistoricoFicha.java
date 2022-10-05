package com.ficai4.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_historico_ficha")
public class HistoricoFicha implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "data_cadastro")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @Column(nullable = false, name = "status", length = 80)
    private String status;

    @Column(nullable = false, name = "responsavel", length = 80)
    private String responsavel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ficha_id")
    private Ficha ficha;

    public HistoricoFicha() {
    }

    public HistoricoFicha(LocalDate dataCadastro, String status, String responsavel, Ficha ficha) {
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.responsavel = responsavel;
        this.ficha = ficha;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
}
