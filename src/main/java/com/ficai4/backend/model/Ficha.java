package com.ficai4.backend.model;

public class Ficha {
    
    //TODO Efetuar validação dos campos nesta camada

    private Long id;
    private Aluno aluno;
    private String versao;
    private String motivoInfrequencia;

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getVersao() {
        return versao;
    }

    public String getMotivoInfrequencia() {
        return motivoInfrequencia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public void setVersao(String versao) {
        this.versao = versao;
    }

    public void setMotivoInfrequencia(String motivoInfrequencia) {
        this.motivoInfrequencia = motivoInfrequencia;
    }
}
