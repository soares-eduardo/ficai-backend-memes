package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ficai4.backend.model.HistoricoFicha;
import com.ficai4.backend.model.dto.HistoricoFichaDTO;

@Component
public class HistoricoFichaMapper {

    public HistoricoFicha toEntity(HistoricoFichaDTO historicoFichaDto) {
        HistoricoFicha historicoFicha = new HistoricoFicha();

        historicoFicha.setDataCadastro(historicoFichaDto.getDataCadastro());
        historicoFicha.setResponsavel(historicoFichaDto.getResponsavel());
        historicoFicha.setStatus(historicoFichaDto.getStatus());
        historicoFicha.setId(historicoFichaDto.getId());

        return historicoFicha;
    }

    public List<HistoricoFicha> toEntity(List<HistoricoFichaDTO> listHistoricoFichaDto) {
        return listHistoricoFichaDto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public HistoricoFichaDTO toDto(HistoricoFicha historicoFicha) {
        HistoricoFichaDTO historicoFichaDto = new HistoricoFichaDTO();

        historicoFichaDto.setDataCadastro(historicoFicha.getDataCadastro());
        historicoFichaDto.setResponsavel(historicoFicha.getResponsavel());
        historicoFichaDto.setStatus(historicoFicha.getStatus());
        historicoFichaDto.setId(historicoFicha.getId());

        return historicoFichaDto;
    }

    public List<HistoricoFichaDTO> toDto(List<HistoricoFicha> listHistoricoFicha) {
        return listHistoricoFicha.stream().map(this::toDto).collect(Collectors.toList());
    }
}
