package com.ficai4.backend.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ficai4.backend.exceptions.EntityNotFoundException;
import com.ficai4.backend.exceptions.NotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ficai4.backend.exceptions.BusinessException;
import com.ficai4.backend.mapper.AlunoMapper;
import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.dto.AlunoDTO;
import com.ficai4.backend.repository.AlunoRepository;

@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = { AlunoService.class })
@AutoConfigureMockMvc
class AlunoServiceTest {

    @MockBean
    private AlunoRepository alunoRepository;

    @MockBean
    private AlunoMapper alunoMapper;

    @Autowired
    private AlunoService underTest;

    @Test
    void itShouldReturnAllAlunos() {
        // given
        // when
        Aluno aluno = createAluno();
        AlunoDTO alunoDto = createAlunoDTO();

        List<Aluno> listAluno = List.of(aluno);
        List<AlunoDTO> listAlunoDto = List.of(alunoDto);

        Mockito.when(alunoRepository.findAll()).thenReturn(listAluno);
        Mockito.when(alunoMapper.toDto(listAluno)).thenReturn(listAlunoDto);

        underTest.findAll();

        // then
        Mockito.verify(alunoRepository, Mockito.times(1)).findAll();
    }

    @Test
    void itShouldReturnAnAlunoById() {
        // given
        UUID id = UUID.fromString("9321d951-230f-48e5-8e95-02d74064c413");

        // when
        Aluno aluno = createAluno();
        AlunoDTO alunoDto = createAlunoDTO();

        Mockito.when(alunoRepository.findById(id)).thenReturn(Optional.of(aluno));
        Mockito.when(alunoMapper.toDto(aluno)).thenReturn(alunoDto);

        underTest.findAlunoById(id);

        // then
        Mockito.verify(alunoRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void itShouldThrowAnExceptionWhenFindingById() {
        // given
        UUID id = UUID.fromString("9321d951-230f-48e5-8e95-02d74064c413");

        // when
        Mockito.when(alunoRepository.findById(id)).thenReturn(Optional.empty());

        // than
        assertThrows(NotFoundException.class, () -> underTest.findAlunoById(id),
                "Aluno não encontrado.");
    }

    @Test
    void itShouldReturnAnEmptyAlunosList() {
        // given
        // when
        Mockito.when(alunoRepository.findAll()).thenReturn(List.of());

        List<AlunoDTO> expected = underTest.findAll();

        // then
        Assertions.assertThat(expected.isEmpty()).isTrue();
    }

    @Test
    void itShouldCreateAnAluno() {
        // given
        AlunoDTO alunoDto = createAlunoDTO();

        // when
        Aluno aluno = createAluno();

        Mockito.when(alunoRepository.findByCpf(
                alunoDto.getCpf())).thenReturn(Optional.empty());
        Mockito.when(alunoMapper.toEntity(alunoDto)).thenReturn(aluno);
        Mockito.when(alunoRepository.save(aluno)).thenReturn(aluno);
        Mockito.when(alunoMapper.toDto(aluno)).thenReturn(alunoDto);

        underTest.createAluno(alunoDto);

        // then
        Mockito.verify(alunoRepository, Mockito
                .times(1))
                .save(ArgumentMatchers.any(Aluno.class));
    }

    @Test
    void itShouldThrowAnExceptionWhenCreatingAluno() {
        // given
        AlunoDTO alunoDto = createAlunoDTO();

        // when
        Aluno aluno = createAluno();

        Mockito.when(alunoRepository.findByCpf(
                alunoDto.getCpf())).thenReturn(Optional.of(aluno));

        // than
        assertThrows(BusinessException.class, () -> underTest.createAluno(alunoDto),
                "Aluno já cadastrado.");
    }

    @Test
    void itShouldUpdateAnAluno() {
        // given
        AlunoDTO alunoDto = createAlunoDTO();

        // when
        Aluno aluno = createAluno();

        Mockito.when(alunoRepository.findByCpf(
                alunoDto.getCpf())).thenReturn(Optional.of(aluno));
        Mockito.when(alunoMapper.toEntity(alunoDto)).thenReturn(aluno);
        Mockito.when(alunoRepository.save(aluno)).thenReturn(aluno);
        Mockito.when(alunoMapper.toDto(aluno)).thenReturn(alunoDto);

        underTest.update(alunoDto);

        // then
        Mockito.verify(alunoRepository, Mockito
                .times(1))
                .save(ArgumentMatchers.any(Aluno.class));
    }

    @Test
    void itShouldThrowAnExceptionWhenUpdatingAluno() {
        // given
        AlunoDTO alunoDto = createAlunoDTO();

        // when
        Mockito.when(alunoRepository.findByCpf(
                alunoDto.getCpf())).thenReturn(Optional.empty());

        // than
        assertThrows(NotFoundException.class, () -> underTest.update(alunoDto),
        "Aluno não encontrado com o CPF informado.");
    }

    @Test
    void itShouldReturnAllAlunosWithAnyWord() {
        // given
        // when
        Aluno aluno = createAluno();
        AlunoDTO alunoDto = createAlunoDTO();

        Optional<List<Aluno>> listAluno = Optional.of(List.of(aluno));
        Optional<List<AlunoDTO>> listAlunoDto = Optional.of(List.of(alunoDto));

        Mockito.when(alunoRepository.findByAnyWord(aluno.getNome())).thenReturn(listAluno);
        Mockito.when(alunoMapper.toDto(listAluno.get())).thenReturn(listAlunoDto.get());

        underTest.findByAnyWord(aluno.getNome());

        // then
        Mockito.verify(alunoRepository, Mockito.times(1)).findByAnyWord(aluno.getNome());
    }

    @Test
    void itShouldThrowAnExceptionWhenDoesNotFindingAlunoByAnyWord() {
        // given
        AlunoDTO alunoDto = createAlunoDTO();

        //when
        Mockito.when(alunoRepository.findByAnyWord(
                alunoDto.getCpf())).thenReturn(Optional.empty());

        // than
        assertThrows(EntityNotFoundException.class, () -> underTest.findByAnyWord(alunoDto.getCpf()),
                "Aluno não encontrado.");
    }

    private Aluno createAluno() {
        return Mockito.mock(Aluno.class);
    }

    private AlunoDTO createAlunoDTO() {
        return Mockito.mock(AlunoDTO.class);
    }
}
