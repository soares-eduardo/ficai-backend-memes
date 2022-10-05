package com.ficai4.backend.model;

import com.ficai4.backend.enums.TipoPerfil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, name = "nome", length = 50)
    private String nome;

    @Column(nullable = false, name = "tipo_perfil")
    private Integer tipoPerfil;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private List<Visita> visitas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nome, TipoPerfil tipoPerfil) {
        this.nome = nome;
        setTipoPerfil(tipoPerfil);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPerfil getTipoPerfil() {
        return TipoPerfil.valueOf(tipoPerfil);
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        if(tipoPerfil != null){
            this.tipoPerfil = tipoPerfil.getCode();
        }
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
        for (Visita visita : visitas) {
            visita.setUsuario(this);
        }
    }
}
