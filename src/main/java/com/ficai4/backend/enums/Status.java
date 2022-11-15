package com.ficai4.backend.enums;

public enum Status {

    AGUARDANDO_VISITA(1),
    EM_VISITACAO(2),
    AGUARDANDO_REDE(3),
    ARQUIVADA(4);

    private int code;

    private Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Status valueOf(int code) {
        for (Status value : Status.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código de Status da ficha inválido. ");
    }
}
