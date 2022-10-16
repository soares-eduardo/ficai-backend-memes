package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ficai4.backend.model.Visita;
import com.ficai4.backend.model.dto.VisitaDTO;

@Component
public class VisitaMapper {
    
    public Visita toEntity(VisitaDTO visitaDto) {
        Visita visita = new Visita();

        visita.setDataVisita(visitaDto.getDataVisita());
        visita.setDescricao(visitaDto.getDescricao());
        visita.setId(visitaDto.getId());
        visita.setResponsavelVisita(visitaDto.getResponsavelVisita());
        visita.setTeveSucesso(visitaDto.getTeveSucesso());

        return visita;
    }

    public List<Visita> toEntity(List<VisitaDTO> listVisitaDto) {
        return listVisitaDto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public VisitaDTO toDto(Visita visita) {
        VisitaDTO visitaDto = new VisitaDTO();

        visitaDto.setDataVisita(visita.getDataVisita());
        visitaDto.setDescricao(visita.getDescricao());
        visitaDto.setId(visita.getId());
        visitaDto.setResponsavelVisita(visita.getResponsavelVisita());
        visitaDto.setTeveSucesso(visita.getTeveSucesso());

        return visitaDto;
    }

    public List<VisitaDTO> toDto(List<Visita> listVisita) {
        return listVisita.stream().map(this::toDto).collect(Collectors.toList());
    }
}
