package com.ficai4.backend.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ficai4.backend.model.Aluno;

@DataJpaTest
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository underTest;

    @BeforeEach
    void setUp() {
        Aluno aluno1 = new Aluno("60076180050", "Eduardo Soares", "Vinicio Muller", "Maria Souto", true,
                true);

        underTest.save(aluno1);
    }

    @Test
    void itShouldCheckIfAlunoExistsCpf() {
        // given
        String cpf = "60076180050";

        // when
        Optional<Aluno> expected = underTest.findByCpf(cpf);

        // then
        assertTrue(expected.isPresent());
    }

    @Test
    void itShouldCheckIfAlunoDoesNotExistCpf() {
        // given
        String cpf = "60076180051";

        // when
        Optional<Aluno> expected = underTest.findByCpf(cpf);

        // then
        assertTrue(expected.isEmpty());
    }
}
