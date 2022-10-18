package com.ficai4.backend.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ficai4.backend.exceptions.NotFoundException;
import com.ficai4.backend.mapper.FichaMapper;
import com.ficai4.backend.model.Escola;
import com.ficai4.backend.model.Ficha;
import com.ficai4.backend.model.MotivoInfrequencia;
import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.repository.EscolaRepository;
import com.ficai4.backend.repository.FichaRepository;
import com.ficai4.backend.repository.MotivoInfrequenciaRepository;

@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = { FichaService.class })
@AutoConfigureMockMvc
class FichaServiceTest {

    @MockBean
    private FichaRepository fichaRepository;

    @MockBean
    private EscolaRepository escolaRepository;

    @MockBean
    private MotivoInfrequenciaRepository motivoInfrequenciaRepository;

    @MockBean
    private FichaMapper fichaMapper;

    @Autowired
    private FichaService underTest;

    @Test
    void itShouldReturnAllFichas() {
        // given
        Ficha ficha = createFicha();
        FichaDTO fichaDto = createFichaDTO();

        List<Ficha> listFicha = List.of(ficha);
        List<FichaDTO> listFichaDto = List.of(fichaDto);

        // when
        Mockito.when(fichaRepository.findAll()).thenReturn(listFicha);
        Mockito.when(fichaMapper.toDto(listFicha)).thenReturn(listFichaDto);

        underTest.findAll();

        // then
        Mockito.verify(fichaRepository, Mockito.times(1)).findAll();
    }

    @Test
    void itShouldReturnAnEmptyFichaList() {
        // given
        // when
        Mockito.when(fichaRepository.findAll()).thenReturn(List.of());
        List<FichaDTO> expected = underTest.findAll();

        // then
        Assertions.assertThat(expected.isEmpty()).isTrue();
    }

    @Test
    void itShouldCreateFicha() {
        // given
        FichaDTO fichaDto = createFichaDTO();
        Ficha ficha = createFicha();
        Escola escola = createEscola();
        MotivoInfrequencia motivoInfrequencia = createMotivoInfrequencia();

        // when
        Mockito.when(escolaRepository.findById(fichaDto.getIdEscola())).thenReturn(Optional.of(escola));
        Mockito.when(motivoInfrequenciaRepository.findById(fichaDto.getIdMotivoInfrequencia())).thenReturn(Optional.of(motivoInfrequencia));
        Mockito.when(fichaMapper.toEntity(fichaDto)).thenReturn(ficha);
        Mockito.when(fichaRepository.save(ficha)).thenReturn(ficha);
        Mockito.when(fichaMapper.toDto(ficha)).thenReturn(fichaDto);

        underTest.createFicha(fichaDto);

        // then
        Mockito.verify(fichaRepository, Mockito.times(1)).save(ArgumentMatchers.any(Ficha.class));
    }

    @Test
    void itShouldReturnAnExceptionWhenAddingANonExistentIdEscola() {
        // given
        FichaDTO fichaDto = createFichaDTO();

        // when
        Mockito.when(escolaRepository.findById(fichaDto.getIdEscola())).thenReturn(Optional.empty());

        // then
        assertThrows(NotFoundException.class, () -> underTest.createFicha(fichaDto),
        "Escola não encontrada com o id informado.");
    }

    @Test
    void itShouldReturnAnExceptionWhenAddingANonExistentIdMotivoInfrequencia() {
        // given
        FichaDTO fichaDto = createFichaDTO();
        Escola escola = createEscola();

        // when
        Mockito.when(escolaRepository.findById(fichaDto.getIdEscola())).thenReturn(Optional.of(escola));
        Mockito.when(motivoInfrequenciaRepository.findById(fichaDto.getIdMotivoInfrequencia())).thenReturn(Optional.empty());

        // then
        assertThrows(NotFoundException.class, () -> underTest.createFicha(fichaDto),
        "Motivo da infrequencia não encontrado com o id informado.");
    }

    @Test
    void itShouldReturnAFichaByAlunoId() {
        // given
        Ficha ficha = createFicha();
        FichaDTO fichaDto = createFichaDTO();

        List<Ficha> listFicha = List.of(ficha);

        // when
        Mockito.when(fichaRepository.findFichaByAlunoId(fichaDto.getAluno())).thenReturn(listFicha);
        Mockito.when(fichaMapper.toDto(ficha)).thenReturn(fichaDto);

        underTest.findFichaByAlunoId(fichaDto.getAluno());

        // then
        Mockito.verify(fichaRepository, Mockito.times(1)).findFichaByAlunoId(fichaDto.getAluno());
    }

    @Test
    void itShouldThrowAnExceptionWhenFindingFichaByAlunoId() {
        // given
        FichaDTO fichaDto = createFichaDTO();

        // when
        Mockito.when(fichaRepository.findFichaByAlunoId(fichaDto.getAluno())).thenReturn(List.of());

        // then
        assertThrows(NotFoundException.class, () -> underTest.createFicha(fichaDto),
        "Ficha não encontrada com o id informado.");
    }

    private Ficha createFicha() {
        return Mockito.mock(Ficha.class);
    }

    private Escola createEscola() {
        return Mockito.mock(Escola.class);
    }

    private MotivoInfrequencia createMotivoInfrequencia() {
        return Mockito.mock(MotivoInfrequencia.class);
    }

    private FichaDTO createFichaDTO() {
        return Mockito.mock(FichaDTO.class);
    }
}
