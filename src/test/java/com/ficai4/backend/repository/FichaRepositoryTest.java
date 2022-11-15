package com.ficai4.backend.repository;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ficai4.backend.enums.SituacaoAluno;
import com.ficai4.backend.enums.Status;
import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.Ficha;

@DataJpaTest
@DisplayName("Tests for FichaRepository")
public class FichaRepositoryTest {

    @Autowired
    private FichaRepository underTest;

    @BeforeEach
    void setUp() {
        Aluno aluno = new Aluno("60076180050", "José Soares", "Vinicio Muller", "", "Maria Souto", true,
                true, LocalDate.now());
        Ficha ficha = new Ficha(SituacaoAluno.EVADIDO, Status.AGUARDANDO_VISITA, "Aluno falta demais",
                aluno, UUID.randomUUID(), UUID.randomUUID(), 1);

        underTest.save(ficha);
    }
}
