package com.ficai4.backend.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, name = "data_cadastro")
    private Instant dataCadastro;

    @Column(nullable = false, name = "cep", length = 8)
    private String cep;

    @Column(nullable = false, name = "logradouro", length = 80)
    private String logradouro;

    @Column(nullable = false, name = "numero", length = 9)
    private String numero;

    @Column(nullable = false, name = "bairro", length = 50)
    private String bairro;

    @Column(nullable = false, name = "complemento", length = 50)
    private String complemento;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
    @JoinColumn(name = "aluno_id")
    @JsonBackReference
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
    @JoinColumn(name = "cidade_id")
    @JsonBackReference
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(String cep, String logradouro, String numero, String bairro,
            String complemento, Aluno aluno, Cidade cidade) {
        this.dataCadastro = Instant.now();
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.aluno = aluno;
        this.cidade = cidade;
    }

    public UUID getId() {
        return this.id;
    }

    public Instant getDataCadastro() {
        return this.dataCadastro;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
