package com.ficai4.backend.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;

import com.ficai4.backend.enums.SituacaoAluno;
import com.ficai4.backend.enums.Status;
import com.ficai4.backend.exceptions.NotFoundException;
import com.ficai4.backend.mapper.FichaInsertMapper;
import com.ficai4.backend.mapper.FichaMapper;
import com.ficai4.backend.mapper.VisitaMapper;
import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.Escola;
import com.ficai4.backend.model.Ficha;
import com.ficai4.backend.model.MotivoInfrequencia;
import com.ficai4.backend.model.Visita;
import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.model.dto.FichaInsertDTO;
import com.ficai4.backend.model.dto.VisitaDTO;
import com.ficai4.backend.repository.EscolaRepository;
import com.ficai4.backend.repository.FichaRepository;
import com.ficai4.backend.repository.MotivoInfrequenciaRepository;
import com.ficai4.backend.repository.VisitaRepository;

@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = { FichaService.class })
@AutoConfigureMockMvc
class FichaServiceTest {

        @MockBean
        private VisitaRepository visitaRepository;

        @MockBean
        private FichaRepository fichaRepository;

        @MockBean
        private EscolaRepository escolaRepository;

        @MockBean
        private MotivoInfrequenciaRepository motivoInfrequenciaRepository;

        @MockBean
        private FichaMapper fichaMapper;

        @MockBean
        private FichaInsertMapper fichaInsertMapper;

        @MockBean
        private VisitaMapper visitaMapper;

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
                Page<FichaDTO> expected = underTest.findAll();

                // then
                Assertions.assertThat(expected.isEmpty()).isTrue();
        }

        @Test
        void itShouldCreateFicha() {
                // given
                FichaInsertDTO fichaInsertDTO = createFichaInsertDTO();
                Ficha ficha = createFicha();
                Escola escola = createEscola();
                MotivoInfrequencia motivoInfrequencia = createMotivoInfrequencia();

                // when
                Mockito.when(escolaRepository.findById(fichaInsertDTO.getIdEscola())).thenReturn(Optional.of(escola));
                Mockito.when(motivoInfrequenciaRepository.findById(fichaInsertDTO.getIdMotivoInfrequencia()))
                                .thenReturn(Optional.of(motivoInfrequencia));
                Mockito.when(fichaInsertMapper.toEntity(fichaInsertDTO)).thenReturn(ficha);
                Mockito.when(fichaRepository.save(ficha)).thenReturn(ficha);
                Mockito.when(fichaInsertMapper.toDto(ficha)).thenReturn(fichaInsertDTO);

                underTest.createFicha(fichaInsertDTO);

                // then
                Mockito.verify(fichaRepository, Mockito.times(1)).save(ArgumentMatchers.any(Ficha.class));
        }

        @Test
        void itShouldReturnAnExceptionWhenAddingANonExistentIdEscola() {
                // given
                FichaInsertDTO fichaInsertDto = new FichaInsertDTO(1, 2, "Aluno não vai na aula.", LocalDate.now(),
                                UUID.randomUUID(),
                                UUID.randomUUID(), 1L, null, null, 1);

                // when
                Mockito.when(escolaRepository.findById(fichaInsertDto.getIdEscola())).thenReturn(Optional.empty());

                // then
                assertThrows(NotFoundException.class, () -> underTest.createFicha(fichaInsertDto),
                                "Escola não encontrada com o id informado.");
        }

        @Test
        void itShouldReturnAnExceptionWhenAddingANonExistentIdMotivoInfrequencia() {
                // given
                FichaInsertDTO fichaDto = new FichaInsertDTO(1, 2, "Aluno não vai na aula.", LocalDate.now(),
                                UUID.randomUUID(),
                                UUID.randomUUID(), 1L, null, null, 1);
                Escola escola = createEscola();

                // when
                Mockito.when(escolaRepository.findById(fichaDto.getIdEscola())).thenReturn(Optional.of(escola));
                Mockito.when(motivoInfrequenciaRepository.findById(fichaDto.getIdMotivoInfrequencia()))
                                .thenReturn(Optional.empty());

                // then
                assertThrows(NotFoundException.class, () -> underTest.createFicha(fichaDto),
                                "Motivo da infrequencia não encontrado com o id informado.");
        }

        @Test
        void itShouldReturnAFichaByAlunoId() {
                // given
                Ficha ficha = createFicha();
                FichaDTO fichaDto = createFichaDTO();

                UUID randomUuid = UUID.randomUUID();

                List<Ficha> listFicha = List.of(ficha);

                // when
                Mockito.when(fichaRepository.findFichaByAlunoId(randomUuid)).thenReturn(listFicha);
                Mockito.when(fichaMapper.toDto(ficha)).thenReturn(fichaDto);

                underTest.findFichaByAlunoId(randomUuid);

                // then
                Mockito.verify(fichaRepository, Mockito.times(1)).findFichaByAlunoId(randomUuid);
        }

        @Test
        void itShouldThrowAnExceptionWhenFindingFichaByAlunoId() {
                // given
                FichaInsertDTO fichaInsertDTO = new FichaInsertDTO(1, 2, "Aluno não vai na aula.", LocalDate.now(),
                                UUID.randomUUID(),
                                UUID.randomUUID(), 1L, null, null, 1);

                // when
                Mockito.when(fichaRepository.findFichaByAlunoId(fichaInsertDTO.getAluno())).thenReturn(List.of());

                // then
                assertThrows(NotFoundException.class, () -> underTest.createFicha(fichaInsertDTO),
                                "Ficha não encontrada com o id informado.");
        }

        @Test
        void itShouldCreateVisita() {
                // given

                VisitaDTO visitaDto = createVisitaDTO();
                Visita visita = createVisita();
                Ficha ficha = createFicha();

                // when

                Mockito.when(fichaRepository.findById(visitaDto.getFichaId())).thenReturn(Optional.of(ficha));
                Mockito.when(visitaMapper.toEntity(visitaDto)).thenReturn(visita);
                Mockito.when(visitaMapper.toDto(visita)).thenReturn(visitaDto);

                underTest.createVisita(visitaDto);

                // then

                Mockito.verify(visitaMapper, Mockito.times(1)).toDto(visita);
        }

        @Test
        void itShouldThrowAnExceptionWhenCreatingVisita() {
                // given
                VisitaDTO visitaDto = createVisitaDTO();

                // when
                Mockito.when(fichaRepository.findById(UUID.randomUUID())).thenReturn(Optional.empty());

                // then
                assertThrows(NotFoundException.class, () -> underTest.createVisita(visitaDto),
                                "Ficha não encontrada com o id informado.");
        }

        private Ficha createFicha() {
                Aluno aluno = new Aluno("60076180050", "José Soares", "Vinicio Muller", "Maria Souto", "Maria Souto",
                                true,
                                true, LocalDate.now());
                Ficha ficha = new Ficha(SituacaoAluno.EVADIDO, Status.AGUARDANDO_VISITA, "Aluno falta demais",
                                aluno, UUID.randomUUID(), 1L, 1);

                return ficha;
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

        private FichaInsertDTO createFichaInsertDTO() {
                return Mockito.mock(FichaInsertDTO.class);
        }

        private VisitaDTO createVisitaDTO() {
                return Mockito.mock(VisitaDTO.class);
        }

        private Visita createVisita() {
                return Mockito.mock(Visita.class);
        }
}
