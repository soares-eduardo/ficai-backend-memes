package com.ficai4.backend.service;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.ficai4.backend.exceptions.NotFoundException;
import com.ficai4.backend.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ficai4.backend.exceptions.BusinessException;
import com.ficai4.backend.mapper.AlunoMapper;
import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.dto.AlunoDTO;
import com.ficai4.backend.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    @Transactional
    public List<AlunoDTO> findAll() {
        return alunoMapper.toDto(alunoRepository.findAll());
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
    public List<AlunoDTO> findByAnyWord(String word) {

        Optional<List<Aluno>> response = alunoRepository.findByAnyWord(word);

       if(response.isEmpty() || response.get().isEmpty()){
          throw new EntityNotFoundException("Aluno não encontrado.");
        }

        return alunoMapper.toDto(response.get());
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
}
