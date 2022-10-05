package com.ficai4.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ficai4.backend.enums.SituacaoAluno;
import com.ficai4.backend.enums.Status;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_ficha")
public class Ficha implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "situacao_Aluno")
    private Integer situacaoAluno;

    @Column(nullable = false, name = "status")
    private Integer status;

    @Column(nullable = false, name = "motivo_complemento")
    private String motivoComplemento;

    @Column(nullable = false, name = "data_cadastro")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @Column(nullable = true, name = "id_escola")
    private UUID idEscola;

    @Column(nullable = false, name = "id_usuario")
    private UUID idUsuario;

    @Column(nullable = true, name = "id_motivo_infrequencia")
    private UUID idMotivoInfrequencia;

    @OneToMany(mappedBy = "ficha", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private List<Visita> visitas = new ArrayList<>();

    @OneToMany(mappedBy = "ficha", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private List<HistoricoFicha> historicoFichas = new ArrayList<>();

    public Ficha() {
    }

    public Ficha(SituacaoAluno situacaoAluno, Status status, String motivoComplemento, Aluno aluno, UUID idEscola,
            UUID idUsuario, UUID idMotivoInfrequencia) {
        setSituacaoAluno(situacaoAluno);
        setStatus(status);
        this.motivoComplemento = motivoComplemento;
        // this.dataCadastro = dataCadastro;
        this.aluno = aluno;
        this.idEscola = idEscola;
        this.idUsuario = idUsuario;
        this.idMotivoInfrequencia = idMotivoInfrequencia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SituacaoAluno getSituacaoAluno() {
        return SituacaoAluno.valueOf(situacaoAluno);
    }

    public void setSituacaoAluno(SituacaoAluno situacaoAluno) {
        if (situacaoAluno != null) {
            this.situacaoAluno = situacaoAluno.getCode();
        }
    }

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    public String getMotivoComplemento() {
        return motivoComplemento;
    }

    public void setMotivoComplemento(String motivoComplemento) {
        this.motivoComplemento = motivoComplemento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public UUID getIdMotivoInfrequencia() {
        return idMotivoInfrequencia;
    }

    public void setIdMotivoInfrequencia(UUID idMotivoInfrequencia) {
        this.idMotivoInfrequencia = idMotivoInfrequencia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public UUID getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(UUID idEscola) {
        this.idEscola = idEscola;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<Visita> visitas) {

        if (!visitas.isEmpty()) {
            this.visitas = visitas;

            for (Visita visita : visitas) {
                visita.setFicha(this);
            }
        }
    }

    public List<HistoricoFicha> getHistoricoFichas() {
        return historicoFichas;
    }

    public void setHistoricoFichas(List<HistoricoFicha> historicoFichas) {

        if (!historicoFichas.isEmpty()) {
            this.historicoFichas = historicoFichas;

            for (HistoricoFicha historico : historicoFichas) {
                historico.setFicha(this);
            }
        }
    }
}
