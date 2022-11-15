package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ficai4.backend.model.Escola;
import com.ficai4.backend.model.dto.EscolaDTO;

@Component
public class EscolaMapper {

    public Escola toEntity(EscolaDTO escolaDto) {
        Escola escola = new Escola();

        escola.setBairro(escolaDto.getBairro());
        escola.setCep(escolaDto.getCep());
        escola.setCidade(escolaDto.getCidade());
        escola.setComplemento(escolaDto.getComplemento());
        escola.setEscolaInep(escolaDto.getEscolaInep());
        escola.setEstado(escolaDto.getEstado());
        escola.setId(escolaDto.getId());
        escola.setLogradouro(escolaDto.getLogradouro());
        escola.setNome(escolaDto.getNome());
        escola.setNumero(escolaDto.getNumero());

        return escola;
    }

    public List<Escola> toEntity(List<EscolaDTO> listEscolaDto) {
        return listEscolaDto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public EscolaDTO toDto(Escola escola) {
        EscolaDTO escolaDto = new EscolaDTO();

        escolaDto.setBairro(escola.getBairro());
        escolaDto.setCep(escola.getCep());
        escolaDto.setCidade(escola.getCidade());
        escolaDto.setComplemento(escola.getComplemento());
        escolaDto.setEscolaInep(escola.getEscolaInep());
        escolaDto.setEstado(escola.getEstado());
        escolaDto.setId(escola.getId());
        escolaDto.setLogradouro(escola.getLogradouro());
        escolaDto.setNome(escola.getNome());
        escolaDto.setNumero(escola.getNumero());

        return escolaDto;
    }

    public List<EscolaDTO> toDto(List<Escola> listEscola) {
        return listEscola.stream().map(this::toDto).collect(Collectors.toList());
    }
}
