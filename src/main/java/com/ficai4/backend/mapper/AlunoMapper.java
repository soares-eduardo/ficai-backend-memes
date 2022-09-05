package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.dto.AlunoDTO;

@Component
public class AlunoMapper {

    @Autowired
    TelefoneMapper telefoneMapper;

    @Autowired
    EnderecoMapper enderecoMapper;

    public Aluno toEntity(AlunoDTO alunoDto) {
        Aluno aluno = new Aluno();

        aluno.setCpf(alunoDto.getCpf());
        aluno.setNome(alunoDto.getNome());
        aluno.setTelefones(telefoneMapper.toEntity(alunoDto.getTelefones()));
        aluno.setResponsavelPrimario(alunoDto.getResponsavelPrimario());
        aluno.setResponsavelSecundario(alunoDto.getResponsavelSecundario());
        aluno.setBeneficiarioRenda(alunoDto.isBeneficiarioRenda());
        aluno.setBeneficiarioBpc(alunoDto.isBeneficiarioBpc());
        aluno.setEnderecos(enderecoMapper.toEntity(alunoDto.getEnderecos()));

        return aluno;
    }

    public AlunoDTO toDto(Aluno aluno) {
        AlunoDTO alunoDto = new AlunoDTO();

        alunoDto.setCpf(aluno.getCpf());
        alunoDto.setNome(aluno.getNome());
        alunoDto.setTelefones(telefoneMapper.toDto(aluno.getTelefones()));
        alunoDto.setResponsavelPrimario(aluno.getResponsavelPrimario());
        alunoDto.setResponsavelSecundario(aluno.getResponsavelSecundario());
        alunoDto.setBeneficiarioRenda(aluno.isBeneficiarioRenda());
        alunoDto.setBeneficiarioBpc(aluno.isBeneficiarioBpc());
        alunoDto.setEnderecos(enderecoMapper.toDto(aluno.getEnderecos()));

        return alunoDto;
    }

    public List<AlunoDTO> toDto(List<Aluno> listAluno) {
        return listAluno.stream().map(this::toDto).collect(Collectors.toList());
    }
}
