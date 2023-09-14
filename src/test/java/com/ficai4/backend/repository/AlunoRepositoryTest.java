package com.ficai4.backend.repository;

import java.time.LocalDate;
import java.util.Optional;

import com.ficai4.backend.model.Cidade;
import com.ficai4.backend.model.Endereco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.*;

import com.ficai4.backend.model.Aluno;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for AlunoRepository")
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository underTest;

    @BeforeEach
    void setUp() {
        Aluno aluno1 = new Aluno("60076180050", "José Soares", "Vinicio Muller", "", "Maria Souto", true,
                true, LocalDate.now());
        Cidade cidade = new Cidade("52345", "Caxias Do Sul", "RS");
        Endereco endereco = new Endereco("91360220", "Rua Limoeiro", "135", "Bela Vista",
                "AP 1709 B", aluno1, cidade, null);
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
        Optional<Page<Aluno>> expected = underTest.findByAnyWord(name, Pageable.ofSize(3));

        // then
        assertTrue(expected.isPresent());
    }

    @Test
    void itShouldCheckIfAlunoDoesNotExistsName() {
        // given
        String name = "claudio";

        // when
        Optional<Page<Aluno>> expected = underTest.findByAnyWord(name, Pageable.ofSize(3));

        // then
        assertTrue(expected.get().isEmpty());
    }

    @Test
    void itShouldCheckIfAlunoExistsResponsavelPrimario() {
        // given
        String name = "vini";

        // when
        Optional<Page<Aluno>> expected = underTest.findByAnyWord(name, Pageable.ofSize(3));

        // then
        assertTrue(expected.isPresent());
    }

    @Test
    void itShouldCheckIfAlunoDoesNotExistsResponsavelPrimario() {
        // given
        String name = "claudio";

        // when
        Optional<Page<Aluno>> expected = underTest.findByAnyWord(name, Pageable.ofSize(3));

        // then
        // assertNull(expected);
        assertTrue(expected.get().isEmpty());
    }

    @Test
    void itShouldCheckIfAlunoExistscpf() {
        // given
        String cpf = "60076180050";

        // when
        Optional<Page<Aluno>> expected = underTest.findByAnyWord(cpf, Pageable.ofSize(3));

        // then
        assertTrue(expected.isPresent());
    }

    @Test
    void itShouldCheckIfAlunoDoesNotExistscpf() {
        // given
        String cpf = "60076185450";

        // when
        Optional<Page<Aluno>> expected = underTest.findByAnyWord(cpf, Pageable.ofSize(3));

        // then
        // assertNull(expected);
        assertTrue(expected.get().isEmpty());
    }

    @Test
    void itShouldCheckIfAlunoExistsCidade() {
        // given
        String cidade = "caxias";

        // when
        Optional<Page<Aluno>> expected = underTest.findByAnyWord(cidade, Pageable.ofSize(3));

        // then
        assertTrue(expected.isPresent());
    }

    @Test
    void itShouldCheckIfAlunoDoesNotExistsCidade() {
        // given
        String cidade = "viamao";

        // when
        Optional<Page<Aluno>> expected = underTest.findByAnyWord(cidade, Pageable.ofSize(3));

        // then
        // assertNull(expected);
        assertTrue(expected.get().isEmpty());
    }
}
