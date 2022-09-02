package com.ficai4.backend.model.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.ficai4.backend.model.Endereco;
import com.ficai4.backend.model.Telefone;

public class AlunoDTO {

    @NotNull
    private String cpf;

    @NotNull
    private String nome;

    @NotNull
    private String responsavelPrimario;

    @NotNull
    private String responsavelSecundario;

    @NotNull
    private Boolean beneficiarioRenda;

    @NotNull
    private Boolean beneficiarioBpc;

    @NotNull
    private List<Telefone> telefones;

    @NotNull
    private List<Endereco> enderecos;

    public AlunoDTO() {
    }

    public AlunoDTO(String cpf, String nome, String responsavelPrimario, String responsavelSecundario,
            Boolean beneficiarioRenda, Boolean beneficiarioBpc, List<Telefone> telefones, List<Endereco> enderecos) {
        this.cpf = cpf;
        this.nome = nome;
        this.responsavelPrimario = responsavelPrimario;
        this.responsavelSecundario = responsavelSecundario;
        this.beneficiarioRenda = beneficiarioRenda;
        this.beneficiarioBpc = beneficiarioBpc;
        this.telefones = telefones;
        this.enderecos = enderecos;
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
