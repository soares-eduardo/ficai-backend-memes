package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.dto.AlunoDTO;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoDTO alunoDto) {
        Aluno aluno = new Aluno();

        aluno.setId(alunoDto.getId());
        aluno.setCpf(alunoDto.getCpf());
        aluno.setNome(alunoDto.getNome());
        aluno.setTelefone(alunoDto.getTelefone());
        aluno.setResponsavelLegal(alunoDto.getResponsavelLegal());
        aluno.setBeneficios(alunoDto.getBeneficios());
        aluno.setSituacao(alunoDto.getSituacao());
        aluno.setDataNascimento(alunoDto.getDataNascimento());

        return aluno;
    }

    public AlunoDTO toDto(Aluno aluno) {
        AlunoDTO alunoDto = new AlunoDTO();

        alunoDto.setId(aluno.getId());
        alunoDto.setCpf(aluno.getCpf());
        alunoDto.setNome(aluno.getNome());
        alunoDto.setTelefone(aluno.getTelefone());
        alunoDto.setResponsavelLegal(aluno.getResponsavelLegal());
        alunoDto.setBeneficios(aluno.getBeneficios());
        alunoDto.setSituacao(aluno.getSituacao());
        alunoDto.setDataNascimento(aluno.getDataNascimento());

        return alunoDto;
    }

    public List<AlunoDTO> toDto(List<Aluno> listAluno) {
        return listAluno.stream().map(this::toDto).collect(Collectors.toList());
    }
}