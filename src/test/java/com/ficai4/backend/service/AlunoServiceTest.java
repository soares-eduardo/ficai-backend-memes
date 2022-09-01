// package com.ficai4.backend.service;

// import static org.junit.jupiter.api.Assertions.assertThrows;

// import java.util.List;
// import java.util.Optional;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.mockito.ArgumentMatchers;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import com.ficai4.backend.mapper.AlunoMapper;
// import com.ficai4.backend.model.AlunoAntiga;
// import com.ficai4.backend.model.dto.AlunoDTO;
// import com.ficai4.backend.repository.AlunoRepository;

// @SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = { AlunoService.class })
// @AutoConfigureMockMvc
// class AlunoServiceTest {

//     @MockBean
//     private AlunoRepository alunoRepository;

//     @MockBean
//     private AlunoMapper alunoMapper;

//     @Autowired
//     private AlunoService underTest;

//     @Test
//     void itShouldReturnAllAlunos() {
//         // given
//         // when
//         AlunoAntiga aluno = createAluno();
//         AlunoDTO alunoDto = createAlunoDTO();

//         List<AlunoAntiga> listAluno = List.of(aluno);
//         List<AlunoDTO> listAlunoDto = List.of(alunoDto);

//         Mockito.when(alunoRepository.findAll()).thenReturn(listAluno);
//         Mockito.when(alunoMapper.toDto(listAluno)).thenReturn(listAlunoDto);

//         underTest.findAll();

//         // then
//         Mockito.verify(alunoRepository, Mockito.times(1)).findAll();
//     }

//     @Test
//     void itShouldReturnAnEmptyAlunosList() {
//         // given
//         // when
//         Mockito.when(alunoRepository.findAll()).thenReturn(List.of());

//         List<AlunoDTO> expected = underTest.findAll();

//         // then
//         Assertions.assertThat(expected.isEmpty()).isTrue();
//     }

//     @Test
//     void itShouldCreateAnAluno() {
//         // given
//         AlunoDTO alunoDto = createAlunoDTO();

//         // when
//         AlunoAntiga aluno = createAluno();

//         Mockito.when(alunoRepository.findByCpf(
//                 alunoDto.getCpf())).thenReturn(Optional.empty());
//         Mockito.when(alunoMapper.toEntity(alunoDto)).thenReturn(aluno);
//         Mockito.when(alunoRepository.save(aluno)).thenReturn(aluno);
//         Mockito.when(alunoMapper.toDto(aluno)).thenReturn(alunoDto);

//         underTest.createAluno(alunoDto);

//         // then
//         Mockito.verify(alunoRepository, Mockito
//                 .times(1))
//                 .save(ArgumentMatchers.any(AlunoAntiga.class));
//     }

//     @Test
//     void itShouldThrowAnExceptionWhenCreatingAluno() {
//         // given
//         AlunoDTO alunoDto = createAlunoDTO();

//         // when
//         AlunoAntiga aluno = createAluno();

//         Mockito.when(alunoRepository.findByCpf(
//                 alunoDto.getCpf())).thenReturn(Optional.of(aluno));

//         // than
//         assertThrows(IllegalStateException.class, () -> underTest.createAluno(alunoDto),
//                 "Aluno is already registered.");
//     }

//     private AlunoAntiga createAluno() {
//         return Mockito.mock(AlunoAntiga.class);
//     }

//     private AlunoDTO createAlunoDTO() {
//         return Mockito.mock(AlunoDTO.class);
//     }
// }
