package com.ficai4.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
    public AlunoDTO createAluno(AlunoDTO alunoDto) {
        Optional<Aluno> optionalAluno = alunoRepository.findByCpf(alunoDto.getCpf());

        if (optionalAluno.isPresent()) {
            throw new BusinessException("Aluno já cadastrado.");
        }

        Aluno aluno = alunoMapper.toEntity(alunoDto);

        alunoRepository.save(aluno);

        return alunoMapper.toDto(aluno);
    }
}
