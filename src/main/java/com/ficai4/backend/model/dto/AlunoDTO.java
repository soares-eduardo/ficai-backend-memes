package com.ficai4.backend.model.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class AlunoDTO {

    @NotNull
    private String cpf;

    @NotNull
    private String nome;

    @NotNull
    private String responsavelPrimario;

    private String responsavelSecundario;

    @NotNull
    private Boolean beneficiarioRenda;

    @NotNull
    private Boolean beneficiarioBpc;

    @NotNull
    private List<TelefoneDTO> telefones;

    @NotNull
    private List<EnderecoDTO> enderecos;

    public AlunoDTO() {
    }

    public AlunoDTO(String cpf, String nome, String responsavelPrimario, String responsavelSecundario,
            Boolean beneficiarioRenda, Boolean beneficiarioBpc, List<TelefoneDTO> telefones,
            List<EnderecoDTO> enderecos) {
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

    public List<TelefoneDTO> getTelefones() {
        return this.telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public List<EnderecoDTO> getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }
}
