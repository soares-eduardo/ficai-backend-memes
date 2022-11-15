package com.ficai4.backend.model.metrics;

public class AlunoMetric {
    private Integer naoMatriculado;
    private Integer evasao;
    private Integer infrequente;

    public AlunoMetric() {
    }

    public AlunoMetric(Integer naoMatriculado, Integer evasao, Integer infrequente) {
        this.naoMatriculado = naoMatriculado;
        this.evasao = evasao;
        this.infrequente = infrequente;
    }

    public Integer getNaoMatriculado() {
        return naoMatriculado;
    }

    public void setNaoMatriculado(Integer naoMatriculado) {
        this.naoMatriculado = naoMatriculado;
    }

    public Integer getEvasao() {
        return evasao;
    }

    public void setEvasao(Integer evasao) {
        this.evasao = evasao;
    }

    public Integer getInfrequente() {
        return infrequente;
    }

    public void setInfrequente(Integer infrequente) {
        this.infrequente = infrequente;
    }
}
