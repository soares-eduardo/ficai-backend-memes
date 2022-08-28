package com.ficai4.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno {
    
    //TODO Efetuar validação dos campos nesta camada

    public Aluno () {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id; // Atribute created as an exemple for auto generating id

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "responsavelLegal")
    private String responsavelLegal;
    
    @Column(name = "beneficios")
    private String beneficios;

    @Column(name = "situacao")
    private String situacao;

    // private Endereco endereco;
    
    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    // private Escola escola;

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getResponsavelLegal() {
        return responsavelLegal;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public String getSituacao() {
        return situacao;
    }

    // public Endereco getEndereco() {
    //     return endereco;
    // }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // public Escola getEscola() {
    //     return escola;
    // }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setResponsavelLegal(String responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    // public void setEndereco(Endereco endereco) {
    //     this.endereco = endereco;
    // }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // public void setEscola(Escola escola) {
    //     this.escola = escola;
    // }
}
