package com.ficai4.backend.model.dto;

public class TelefoneDTO {

    private String ddd;

    private String numero;

    public TelefoneDTO() {
    }

    public TelefoneDTO(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return this.ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
