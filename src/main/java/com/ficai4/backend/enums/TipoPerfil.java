package com.ficai4.backend.enums;

public enum TipoPerfil {
    CONSELHO_DE_EDUCACAO(1),
    CONSELHO_TUTELAR(2),
    ESCOLA(3),
    MINISTERIO_PUBLICO(4),
    RAE(5);

    private int code;

    private TipoPerfil(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoPerfil valueOf(int code) {
        for (TipoPerfil value : TipoPerfil.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código de tipo de perfil inválido. ");
    }
}
