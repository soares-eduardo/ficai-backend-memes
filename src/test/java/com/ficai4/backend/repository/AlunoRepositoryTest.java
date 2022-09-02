package com.ficai4.backend.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.Cidade;
import com.ficai4.backend.model.Endereco;
import com.ficai4.backend.model.Telefone;

@DataJpaTest
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository underTest;

    @BeforeEach
    void setUp() {
        Aluno aluno1 = new Aluno("60076180050", "Eduardo Soares", "Vinicio Muller", "Maria Souto", true,
                true);

        Telefone telefone1 = new Telefone(aluno1, "051", "998732729");

        Cidade cidade1 = new Cidade("52345", "Porto Alegre", "Rio Grande do Sul", "RS");

        Endereco endereco1 = new Endereco("91360220", "Rua Limoeiro", "135", "Bela Vista",
                "AP 1709 B", aluno1, cidade1);

        aluno1.getTelefones().add(telefone1);
        aluno1.getEnderecos().add(endereco1);

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
