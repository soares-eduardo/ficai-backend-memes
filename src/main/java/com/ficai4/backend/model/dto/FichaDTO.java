package com.ficai4.backend.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FichaDTO {

    //TODO Validar os campos

    private UUID id;

    private Integer situacaoAluno;

    private Integer status;

    private String motivoComplemento;

    private LocalDate dataCadastro;

    private UUID aluno;

    private UUID idEscola;

    private UUID idUsuario;

    private UUID idMotivoInfrequencia;

    private List<VisitaDTO> visitas = new ArrayList<>();

    private List<HistoricoFichaDTO> historicoFichas = new ArrayList<>();

    public FichaDTO() {
    }

    public FichaDTO(Integer situacaoAluno, Integer status, String motivoComplemento, LocalDate dataCadastro,
            UUID aluno, UUID idEscola, UUID idUsuario, UUID idMotivoInfrequencia, List<VisitaDTO> visitas,
            List<HistoricoFichaDTO> historicoFichas) {
        this.situacaoAluno = situacaoAluno;
        this.status = status;
        this.motivoComplemento = motivoComplemento;
        this.dataCadastro = dataCadastro;
        this.aluno = aluno;
        this.idEscola = idEscola;
        this.idUsuario = idUsuario;
        this.idMotivoInfrequencia = idMotivoInfrequencia;
        this.visitas = visitas;
        this.historicoFichas = historicoFichas;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public UUID getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UUID getIdMotivoInfrequencia() {
        return this.idMotivoInfrequencia;
    }

    public void setIdMotivoInfrequencia(UUID idMotivoInfrequencia) {
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
}
