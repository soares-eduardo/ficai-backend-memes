package com.ficai4.backend.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH })
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Column(nullable = false, name = "ddd", length = 3)
    private String ddd;

    @Column(nullable = false, name = "numero", length = 9)
    private String numero;

    @Column(nullable = false, name = "data_cadastro")
    private LocalDate dataCadastro;

    public Telefone() {

    }

    public Telefone(Aluno aluno, String ddd, String numero, LocalDate dataCadastro) {
        this.aluno = aluno;
        this.ddd = ddd;
        this.numero = numero;
        this.dataCadastro = dataCadastro;
    }

    public UUID getId() {
        return this.id;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getDdd() {
        return this.ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
