package com.ficai4.backend.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ficai4.backend.model.IdPublico;
import com.ficai4.utils.LengthMessages;
import com.ficai4.utils.NullMessages;

public class FichaInsertDTO {

    private UUID id;

    private IdPublico idPublico;

    @NotNull(message = "Situação do aluno " + NullMessages.NULL_NOT_ALLOWED)
    private Integer situacaoAluno;

    @NotNull(message = "Status " + NullMessages.NULL_NOT_ALLOWED)
    private Integer status;

    private Integer responsavel;

    @NotNull(message = "Motivo do complemento " + NullMessages.NULL_NOT_ALLOWED)
    @Length(max = 255, message = LengthMessages.MOTIVO_COMPLEMENTO_VALIDATION)
    private String motivoComplemento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @NotNull(message = "ID do aluno " + NullMessages.NULL_NOT_ALLOWED)
    private UUID aluno;

    private UUID idEscola;

    private Long idMotivoInfrequencia;

    @Valid
    private List<VisitaDTO> visitas = new ArrayList<>();

    @Valid
    private List<HistoricoFichaDTO> historicoFichas = new ArrayList<>();

    public FichaInsertDTO() {
    }

    public FichaInsertDTO(Integer situacaoAluno, Integer status, String motivoComplemento, LocalDate dataCadastro,
            UUID aluno, UUID idEscola, Long idMotivoInfrequencia, List<VisitaDTO> visitas,
            List<HistoricoFichaDTO> historicoFichas, Integer responsavel) {
        this.situacaoAluno = situacaoAluno;
        this.status = status;
        this.motivoComplemento = motivoComplemento;
        this.dataCadastro = dataCadastro;
        this.aluno = aluno;
        this.idEscola = idEscola;
        this.idMotivoInfrequencia = idMotivoInfrequencia;
        this.visitas = visitas;
        this.historicoFichas = historicoFichas;
        this.responsavel = responsavel;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public IdPublico getIdPublico() {
        return idPublico;
    }

    public void setIdPublico(IdPublico idPublico) {
        this.idPublico = idPublico;
    }

    public Integer getSituacaoAluno() {
        return this.situacaoAluno;
    }

    public void setSituacaoAluno(Integer situacaoAluno) {
        this.situacaoAluno = situacaoAluno;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMotivoComplemento() {
        return this.motivoComplemento;
    }

    public void setMotivoComplemento(String motivoComplemento) {
        this.motivoComplemento = motivoComplemento;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public UUID getAluno() {
        return aluno;
    }

    public void setAluno(UUID aluno) {
        this.aluno = aluno;
    }

    public UUID getIdEscola() {
        return this.idEscola;
    }

    public void setIdEscola(UUID idEscola) {
        this.idEscola = idEscola;
    }

    public Long getIdMotivoInfrequencia() {
        return this.idMotivoInfrequencia;
    }

    public void setIdMotivoInfrequencia(Long idMotivoInfrequencia) {
        this.idMotivoInfrequencia = idMotivoInfrequencia;
    }

    public List<VisitaDTO> getVisitas() {
        return this.visitas;
    }

    public void setVisitas(List<VisitaDTO> visitas) {
        this.visitas = visitas;
    }

    public List<HistoricoFichaDTO> getHistoricoFichas() {
        return this.historicoFichas;
    }

    public void setHistoricoFichas(List<HistoricoFichaDTO> historicoFichas) {
        this.historicoFichas = historicoFichas;
    }

    public Integer getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Integer responsavel) {
        this.responsavel = responsavel;
    }
}
