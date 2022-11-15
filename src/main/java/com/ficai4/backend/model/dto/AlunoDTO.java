package com.ficai4.backend.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ficai4.utils.LengthMessages;
import com.ficai4.utils.NullMessages;

public class AlunoDTO {

    private UUID id;

    @NotNull(message = "CPF " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 11, min = 11, message = LengthMessages.CPF_LENGTH_VALIDATION)
    private String cpf;

    @NotNull(message = "Nome " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 80, message = LengthMessages.NOME_LENGTH_VALIDATION)
    private String nome;

    @NotNull(message = "Responsavel Primario " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 80, message = LengthMessages.RESPONSAVEL_PRIMARIO_VALIDATION)
    private String responsavelPrimario;

    private String responsavelSecundario;

    private String responsavelOpcional;

    @NotNull(message = "Beneficiario Renda " + NullMessages.NULL_NOT_ALLOWED)
    private Boolean beneficiarioRenda;

    @NotNull(message = "Beneficiario BPC " + NullMessages.NULL_NOT_ALLOWED)
    private Boolean beneficiarioBpc;

    @NotNull(message = "Data de nascimento " + NullMessages.NULL_NOT_ALLOWED)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Valid
    @NotNull(message = "Telefone " + NullMessages.NULL_NOT_ALLOWED)
    private List<TelefoneDTO> telefones;

    @Valid
    @NotNull(message = "Endereco " + NullMessages.NULL_NOT_ALLOWED)
    private List<EnderecoDTO> enderecos;

    public AlunoDTO() {
    }

    public AlunoDTO(String cpf, String nome, String responsavelPrimario, String responsavelSecundario,
            String responsavelOpcional,
            Boolean beneficiarioRenda, Boolean beneficiarioBpc, List<TelefoneDTO> telefones,
            List<EnderecoDTO> enderecos, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.responsavelPrimario = responsavelPrimario;
        this.responsavelSecundario = responsavelSecundario;
        this.beneficiarioRenda = beneficiarioRenda;
        this.beneficiarioBpc = beneficiarioBpc;
        this.telefones = telefones;
        this.enderecos = enderecos;
        this.dataNascimento = dataNascimento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getResponsavelOpcional() {
        return this.responsavelOpcional;
    }

    public void setResponsavelOpcional(String responsavelOpcional) {
        this.responsavelOpcional = responsavelOpcional;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
