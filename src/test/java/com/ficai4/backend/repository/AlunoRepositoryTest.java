package com.ficai4.backend.repository;

import java.util.List;
import java.util.Optional;

import com.ficai4.backend.model.Cidade;
import com.ficai4.backend.model.Endereco;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ficai4.backend.model.Aluno;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for AlunoRepository")
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository underTest;

    @BeforeEach
    void setUp() {
        Aluno aluno1 = new Aluno("60076180050", "Eduardo Soares", "Vinicio Muller", "Maria Souto", true,
                true);
        Cidade cidade = new Cidade("52345", "Caxias Do Sul", "Rio Grande do Sul", "RS");
        Endereco endereco = new Endereco("91360220", "Rua Limoeiro", "135", "Bela Vista",
                "AP 1709 B", aluno1, cidade);
        aluno1.getEnderecos().add(endereco);

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

    @Test
    void itShouldCheckIfAlunoExistsName() {
        // given
        String name = "edu";

        // when
        Optional<List<Aluno>> expected = underTest.findByAnyWord(name);

        // then
        assertTrue(expected.isPresent());
    }

    @Test
    void itShouldCheckIfAlunoDoesNotExistsName() {
        // given
        String name = "claudio";

        // when
        Optional<List<Aluno>> expected = underTest.findByAnyWord(name);

        // then
        assertTrue(expected.get().isEmpty());
    }

    @Test
    void itShouldCheckIfAlunoExistsResponsavelPrimario() {
        // given
        String name = "vini";

        // when
        Optional<List<Aluno>> expected = underTest.findByAnyWord(name);

        // then
        assertTrue(expected.isPresent());
    }

    @Test
    void itShouldCheckIfAlunoDoesNotExistsResponsavelPrimario() {
        // given
        String name = "claudio";

        // when
        Optional<List<Aluno>> expected = underTest.findByAnyWord(name);

        // then
        //assertNull(expected);
        assertTrue(expected.get().isEmpty());
    }

    @Test
    void itShouldCheckIfAlunoExistscpf() {
        // given
        String cpf = "60076180050";

        // when
        Optional<List<Aluno>> expected = underTest.findByAnyWord(cpf);

        // then
        assertTrue(expected.isPresent());
    }

    @Test
    void itShouldCheckIfAlunoDoesNotExistscpf() {
        // given
        String cpf = "60076185450";

        // when
        Optional<List<Aluno>> expected = underTest.findByAnyWord(cpf);

        // then
        //assertNull(expected);
        assertTrue(expected.get().isEmpty());
    }

    @Test
    void itShouldCheckIfAlunoExistsCidade() {
        // given
        String cidade = "caxias";

        // when
        Optional<List<Aluno>> expected = underTest.findByAnyWord(cidade);

        // then
        assertTrue(expected.isPresent());
    }

    @Test
    void itShouldCheckIfAlunoDoesNotExistsCidade() {
        // given
        String cidade = "viamao";

        // when
        Optional<List<Aluno>> expected = underTest.findByAnyWord(cidade);

        // then
        //assertNull(expected);
        assertTrue(expected.get().isEmpty());
    }
}
