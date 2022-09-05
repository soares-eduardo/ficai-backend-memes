package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ficai4.backend.model.Cidade;
import com.ficai4.backend.model.dto.CidadeDTO;

@Component
public class CidadeMapper {
    
    public Cidade toEntity (CidadeDTO cidadeDto) {
        Cidade cidade = new Cidade();

        cidade.setCodigoIbge(cidadeDto.getCodigoIbge());
        cidade.setNome(cidadeDto.getNome());
        cidade.setUfNome(cidadeDto.getUfNome());
        cidade.setUfSigla(cidadeDto.getUfSigla());

        return cidade;
    }

    public CidadeDTO toDto (Cidade cidade) {
        CidadeDTO cidadeDto = new CidadeDTO();

        cidadeDto.setCodigoIbge(cidade.getCodigoIbge());
        cidadeDto.setNome(cidade.getNome());
        cidadeDto.setUfNome(cidade.getUfNome());
        cidadeDto.setUfSigla(cidade.getUfSigla());

        return cidadeDto;
    }

    public List<CidadeDTO> toDto(List<Cidade> listCidade) {
        return listCidade.stream().map(this::toDto).collect(Collectors.toList());
    }
}
