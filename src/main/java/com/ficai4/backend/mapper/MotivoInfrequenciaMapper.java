package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ficai4.backend.model.MotivoInfrequencia;
import com.ficai4.backend.model.dto.MotivoInfrequenciaDTO;

@Component
public class MotivoInfrequenciaMapper {
    public MotivoInfrequencia toEntity(MotivoInfrequenciaDTO motivoInfrequenciaDto) {
        MotivoInfrequencia motivoInfrequencia = new MotivoInfrequencia();

        motivoInfrequencia.setId(motivoInfrequenciaDto.getId());
        motivoInfrequencia.setRecorrenciasParaEnvio(motivoInfrequenciaDto.getRecorrenciasParaEnvio());
        motivoInfrequencia.setSubTipo(motivoInfrequenciaDto.getSubTipo());
        motivoInfrequencia.setTipo(motivoInfrequenciaDto.getTipo());

        return motivoInfrequencia;
    }

    public List<MotivoInfrequencia> toEntity(List<MotivoInfrequenciaDTO> listMotivoInfrequenciaDto) {
        return listMotivoInfrequenciaDto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public MotivoInfrequenciaDTO toDto(MotivoInfrequencia motivoInfrequencia) {
        MotivoInfrequenciaDTO motivoInfrequenciaDto = new MotivoInfrequenciaDTO();

        motivoInfrequenciaDto.setId(motivoInfrequencia.getId());
        motivoInfrequenciaDto.setRecorrenciasParaEnvio(motivoInfrequencia.getRecorrenciasParaEnvio());
        motivoInfrequenciaDto.setSubTipo(motivoInfrequencia.getSubTipo());
        motivoInfrequenciaDto.setTipo(motivoInfrequencia.getTipo());

        return motivoInfrequenciaDto;
    }

    public List<MotivoInfrequenciaDTO> toDto(List<MotivoInfrequencia> listMotivoInfrequencia) {
        return listMotivoInfrequencia.stream().map(this::toDto).collect(Collectors.toList());
    }
}
