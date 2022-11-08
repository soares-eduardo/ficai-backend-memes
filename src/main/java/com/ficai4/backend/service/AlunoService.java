package com.ficai4.backend.service;

import com.ficai4.backend.exceptions.BusinessException;
import com.ficai4.backend.exceptions.EntityNotFoundException;
import com.ficai4.backend.exceptions.NotFoundException;
import com.ficai4.backend.mapper.AlunoMapper;
import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.dto.AlunoDTO;
import com.ficai4.backend.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    @Transactional
    public Page<AlunoDTO> findAll() {
        int page = 0;
        int size = 10;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

        return new PageImpl<>(
                alunoMapper.toDto((List<Aluno>) alunoRepository.findAll()),
                pageRequest, size);
        // return alunoMapper.toDto(alunoRepository.findAll());
    }

    @Transactional
    public AlunoDTO findAlunoById(UUID id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if (optionalAluno.isEmpty()) {
            throw new NotFoundException("Aluno não encontrado.");
        }

        return alunoMapper.toDto(optionalAluno.get());
    }

    @Transactional
    public AlunoDTO createAluno(AlunoDTO alunoDto) {
        Optional<Aluno> optionalAluno = alunoRepository.findByCpf(alunoDto.getCpf());

        if (optionalAluno.isPresent()) {
            throw new BusinessException("Aluno já cadastrado.");
        }

        Aluno aluno = alunoMapper.toEntity(alunoDto);

        alunoRepository.save(aluno);

        return alunoMapper.toDto(aluno);
    }

    @Transactional
    public Page<AlunoDTO> findByAnyWord(String word, int page, int size, Sort.Direction direction, String atributo) {
        if (atributo.toLowerCase().equals("cidade")) {
            return pagePorCidade(word, page, size, direction, atributo);
        }

        PageRequest pageRequest = PageRequest.of(page, size, direction, atributo);

        Optional<Page<Aluno>> response = alunoRepository.findByAnyWord(word, pageRequest);

        if (response.isEmpty() || response.get().isEmpty()) {
            throw new EntityNotFoundException("Aluno não encontrado.");
        }

        return new PageImpl<>(
                alunoMapper.toDto(response.get().stream().collect(Collectors.toList())),
                pageRequest, response.get().getSize());
    }

    public AlunoDTO update(AlunoDTO alunoDto) {
        Optional<Aluno> optionalAluno = alunoRepository.findByCpf(alunoDto.getCpf());

        if (optionalAluno.isEmpty()) {
            throw new NotFoundException("Aluno não encontrado com o CPF informado.");
        }

        Aluno aluno = alunoMapper.toEntity(alunoDto);

        aluno.setId(optionalAluno.get().getId());

        alunoRepository.save(aluno);

        return alunoMapper.toDto(aluno);

    }

    private void ordenarPorCidadeAsc(List<AlunoDTO> dtos) {
        dtos.sort(Comparator.comparing(
                alunoDTO -> alunoDTO.getEnderecos().get(alunoDTO.getEnderecos().size() - 1).getCidade().getNome()));
    }

    private void ordenarPorCidadeDesc(List<AlunoDTO> dtos) {
        dtos.sort(Comparator.comparing(
                alunoDTO -> alunoDTO.getEnderecos().get(alunoDTO.getEnderecos().size() - 1).getCidade().getNome()));
        Collections.reverse(dtos);
    }

    private Page<AlunoDTO> pagePorCidade(String word, int page, int size, Sort.Direction direction, String atributo) {
        PageRequest pageRequest2 = PageRequest.of(page, size);

        Optional<Page<Aluno>> response = alunoRepository.findByAnyWord(word, pageRequest2);
        if (response.isEmpty() || response.get().isEmpty()) {
            throw new EntityNotFoundException("Aluno não encontrado.");
        }

        List<AlunoDTO> dto = alunoMapper.toDto(response.get().stream().collect(Collectors.toList()));
        if (direction.isAscending()) {
            ordenarPorCidadeAsc(dto);
        } else {
            ordenarPorCidadeDesc(dto);
        }

        return new PageImpl<>(
                dto,
                pageRequest2, response.get().getSize());
    }
}
