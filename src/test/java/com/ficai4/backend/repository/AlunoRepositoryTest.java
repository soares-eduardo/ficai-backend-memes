package com.ficai4.backend.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
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
        Aluno aluno1 = new Aluno();

        aluno1.setNome("Eduardo Soares");
        aluno1.setCpf("60076180050");
        aluno1.setTelefone("51 998732729");
        aluno1.setResponsavelLegal("Daniela Soares");
        aluno1.setBeneficios("BPC");
        aluno1.setSituacao("Não matriculado");
        aluno1.setDataNascimento(LocalDate.now());

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
