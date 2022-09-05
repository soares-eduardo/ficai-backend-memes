package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ficai4.backend.model.Telefone;
import com.ficai4.backend.model.dto.TelefoneDTO;

@Component
public class TelefoneMapper {
    
    public Telefone toEntity (TelefoneDTO telefoneDto) {
        Telefone telefone = new Telefone();

        telefone.setDdd(telefoneDto.getDdd());
        telefone.setNumero(telefoneDto.getNumero());
        
        return telefone;
    }

    public List<Telefone> toEntity (List<TelefoneDTO> listTelefoneDto) {
        return listTelefoneDto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public TelefoneDTO toDto (Telefone telefone) {
        TelefoneDTO telefoneDto = new TelefoneDTO();

        telefoneDto.setDdd(telefone.getDdd());
        telefoneDto.setNumero(telefone.getNumero());
        
        return telefoneDto;
    }

    public List<TelefoneDTO> toDto (List<Telefone> listTelefone) {
        return listTelefone.stream().map(this::toDto).collect(Collectors.toList());
    }
}
