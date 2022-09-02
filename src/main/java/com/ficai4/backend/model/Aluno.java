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

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, name = "cpf", length = 11)
    private String cpf;

    @Column(nullable = false, name = "nome", length = 80)
    private String nome;

    @Column(nullable = false, name = "responsavel_primario", length = 80)
    private String responsavelPrimario;

    @Column(name = "responsavel_secundario", length = 80)
    private String responsavelSecundario;

    @Column(nullable = false, name = "beneficiario_renda")
    private Boolean beneficiarioRenda;

    @Column(nullable = false, name = "beneficiario_bpc")
    private Boolean beneficiarioBpc;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
    private List<Telefone> telefones = new ArrayList<Telefone>();

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    public Aluno() {
    }

    public Aluno(String cpf, String nome, String responsavelPrimario, String responsavelSecundario,
            Boolean beneficiarioRenda, Boolean beneficiarioBpc) {
        this.cpf = cpf;
        this.nome = nome;
        this.responsavelPrimario = responsavelPrimario;
        this.responsavelSecundario = responsavelSecundario;
        this.beneficiarioRenda = beneficiarioRenda;
        this.beneficiarioBpc = beneficiarioBpc;
    }

    public UUID getId() {
        return this.id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavelPrimario() {
        return this.responsavelPrimario;
    }

    public void setResponsavelPrimario(String responsavelPrimario) {
        this.responsavelPrimario = responsavelPrimario;
    }

    public String getResponsavelSecundario() {
        return this.responsavelSecundario;
    }

    public void setResponsavelSecundario(String responsavelSecundario) {
        this.responsavelSecundario = responsavelSecundario;
    }

    public Boolean isBeneficiarioRenda() {
        return this.beneficiarioRenda;
    }

    public Boolean getBeneficiarioRenda() {
        return this.beneficiarioRenda;
    }

    public void setBeneficiarioRenda(Boolean beneficiarioRenda) {
        this.beneficiarioRenda = beneficiarioRenda;
    }

    public Boolean isBeneficiarioBpc() {
        return this.beneficiarioBpc;
    }

    public Boolean getBeneficiarioBpc() {
        return this.beneficiarioBpc;
    }

    public void setBeneficiarioBpc(Boolean beneficiarioBpc) {
        this.beneficiarioBpc = beneficiarioBpc;
    }

    public List<Telefone> getTelefones() {
        return this.telefones;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
