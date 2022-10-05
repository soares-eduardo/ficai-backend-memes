package com.ficai4.backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_escola")
public class Escola implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, name = "escola_inep", length = 8)
    private String escolaInep;

    @Column(nullable = false, name = "nome", length = 50)
    private String nome;

    @Column(nullable = false, name = "cep", length = 9)
    private String cep;

    @Column(nullable = false, name = "logradouro", length = 80)
    private String logradouro;

    @Column(nullable = false, name = "numero", length = 9)
    private String numero;

    @Column(nullable = true, name = "complemento", length = 50)
    private String complemento;

    @Column(nullable = false, name = "bairro", length = 50)
    private String bairro;

    @Column(nullable = false, name = "cidade", length = 50)
    private String cidade;

    @Column(nullable = false, name = "estado", length = 2)
    private String estado;


    public Escola() {
    }

    public Escola(String escolaInep, String nome, String cep, String logradouro, String numero, String complemento, String bairro, String cidade, String estado) {
        this.escolaInep = escolaInep;
        this.nome = nome;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEscolaInep() {
        return escolaInep;
    }

    public void setEscolaInep(String escolaInep) {
        this.escolaInep = escolaInep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
