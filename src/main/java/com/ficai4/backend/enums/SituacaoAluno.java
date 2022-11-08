package com.ficai4.backend.enums;

public enum SituacaoAluno {
    INFREQUENTE(1),
    NAO_MATRICULADO(2),
    EVADIDO(3);

    private int code;

    private SituacaoAluno(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SituacaoAluno valueOf(int code) {
        for (SituacaoAluno value : SituacaoAluno.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código de Situação do aluno inválido. ");
    }
}
