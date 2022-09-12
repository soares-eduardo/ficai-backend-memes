package com.ficai4.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_cidade")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, name = "codigo_ibge", length = 7)
    private String codigoIbge;

    @Column(nullable = false, name = "nome", length = 30)
    private String nome;

    @Column(nullable = false, name = "uf_sigla", length = 2)
    private String ufSigla;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JsonIgnore
    private List<Endereco> endereco = new ArrayList<>();

    public Cidade() {
    }

    public Cidade(String codigoIbge, String nome, String ufSigla) {
        this.codigoIbge = codigoIbge;
        this.nome = nome;
        this.ufSigla = ufSigla;
    }

    public UUID getId() {
        return this.id;
    }

    public String getCodigoIbge() {
        return this.codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUfSigla() {
        return this.ufSigla;
    }

    public void setUfSigla(String ufSigla) {
        this.ufSigla = ufSigla;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }
}
