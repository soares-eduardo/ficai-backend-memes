package com.ficai4.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ficai4.backend.enums.SituacaoAluno;
import com.ficai4.backend.enums.Status;

@DataJpaTest
@DisplayName("Tests for Aluno model.")
public class AlunoTest {

    Aluno aluno = new Aluno("60076180050", "José Soares", "Vinicio Muller", "Maria Souto", "Maria Souto", true,
            true, LocalDate.now());

    Ficha ficha = new Ficha(SituacaoAluno.EVADIDO, Status.AGUARDANDO_VISITA, "Aluno falta demais", aluno,
            UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"),
            UUID.fromString("4fa85f64-5717-4562-b3fc-2c963f66afa6"), 1);

    Telefone telefone = new Telefone(aluno, "051", "998732729", "Jair");

    Cidade cidade = new Cidade("5234565", "Porto Alegre", "RS");

    Endereco endereco = new Endereco("91360-220", "Rua Limoeiro", "135", "Bela Vista",
            "AP 1709 B", aluno, cidade, "Ao lado da churrascaria Gauchinho");

    @Test
    void itShouldSetFichas() {
        // given
        // when
        aluno.setFichas(List.of(ficha));
        // then
        assertEquals(aluno.getFichas().size(), 1);
    }

    @Test
    void itShouldSetTelefones() {
        // given
        // when
        aluno.setTelefones(List.of(telefone));
        // then
        assertEquals(aluno.getTelefones().size(), 1);
    }

    @Test
    void itShouldSetEnderecos() {
        // given
        // when
        aluno.setEnderecos(List.of(endereco));
        // then
        assertEquals(aluno.getEnderecos().size(), 1);
    }
}
