package com.ficai4.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.ArrayList;

import com.ficai4.backend.enums.SituacaoAluno;
import com.ficai4.backend.enums.Status;

@DataJpaTest
@DisplayName("Tests for Ficha model.")

public class FichaTest {

    Aluno aluno = new Aluno("60076180050", "José Soares", "Vinicio Muller", "Maria Souto", "Maria Souto", true,
            true, LocalDate.now());

    Ficha ficha = new Ficha(SituacaoAluno.EVADIDO, Status.AGUARDANDO_VISITA, "Aluno falta demais", aluno,
            UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"),
            1L, 1);

    HistoricoFicha historicoFicha = new HistoricoFicha(LocalDate.now(), 2,
            1, ficha);

    Visita visita = new Visita("Visita teste", "Secretaria teste", false, ficha,
            LocalDate.now());

    @Test
    void itShouldSetVisitas() {
        // given
        // when
        ficha.setVisitas(List.of(visita));
        // then
        assertEquals(ficha.getVisitas().size(), 1);
    }

    @Test
    void itShouldSetAnEmptyListOfVisitas() {
        // given
        List<Visita> visitasEmpty = new ArrayList<>();
        // when
        ficha.setVisitas(visitasEmpty);
        // then
        assertEquals(0, ficha.getVisitas().size());
    }

    @Test
    void itShouldSetHistoricoFichas() {
        // given
        // when
        ficha.setHistoricoFichas(List.of(historicoFicha));
        // then
        assertEquals(1, ficha.getHistoricoFichas().size());
    }

    @Test
    void itShouldSetAnEmptyListOfHistoricoFichas() {
        // given
        List<HistoricoFicha> historicoFichasEmpty = new ArrayList<>();
        // when
        ficha.setHistoricoFichas(historicoFichasEmpty);
        // then
        assertEquals(0, ficha.getHistoricoFichas().size());
    }

    @Test
    void itShouldSetSituacaoAluno() {
        // given
        // when
        ficha.setSituacaoAluno(SituacaoAluno.INFREQUENTE);
        // then
        assertEquals(1, ficha.getSituacaoAluno().getCode());
    }

    @Test
    void itShouldStatusAluno() {
        // given
        // when
        ficha.setStatus(Status.AGUARDANDO_REDE);
        // then
        assertEquals(3, ficha.getSituacaoAluno().getCode());
    }

    @Test
    void itShouldSetSituacaoAlunoAsNull() {
        // given
        // when
        ficha.setSituacaoAluno(null);
        // then
        assertEquals(SituacaoAluno.EVADIDO, ficha.getSituacaoAluno());
    }

    @Test
    void itShouldStatusAlunoAsNull() {
        // given
        // when
        ficha.setStatus(null);
        // then
        assertEquals(Status.AGUARDANDO_VISITA, ficha.getStatus());
    }
}
