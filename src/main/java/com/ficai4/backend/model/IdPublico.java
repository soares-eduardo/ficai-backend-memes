package com.ficai4.backend.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class IdPublico implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="ficha_id_publico_seq",
            sequenceName="ficha_id_publico",
            initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ficha_id_publico_seq")
    private Long idPublico;

    public IdPublico() {
    }

    public Long getIdPublico() {
        return idPublico;
    }

    public void setIdPublico(Long idPublico) {
        this.idPublico = idPublico;
    }
}
