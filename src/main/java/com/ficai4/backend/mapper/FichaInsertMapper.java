package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ficai4.backend.enums.SituacaoAluno;
import com.ficai4.backend.enums.Status;
import com.ficai4.backend.model.Ficha;
import com.ficai4.backend.model.dto.FichaInsertDTO;
import com.ficai4.backend.repository.AlunoRepository;

@Component
public class FichaInsertMapper {

    @Autowired
    AlunoMapper alunoMapper;

    @Autowired
    HistoricoFichaMapper historicoFichaMapper;

    @Autowired
    VisitaMapper visitaMapper;

    @Autowired
    AlunoRepository alunoRepository;

    public Ficha toEntity (FichaInsertDTO fichaInsertDto) {
        Ficha ficha = new Ficha();
        
        ficha.setAluno(alunoRepository.findById(fichaInsertDto.getAluno()).get());
        ficha.setDataCadastro(fichaInsertDto.getDataCadastro());
        ficha.setHistoricoFichas(historicoFichaMapper.toEntity(fichaInsertDto.getHistoricoFichas()));
        ficha.setId(fichaInsertDto.getId());
        ficha.setIdEscola(fichaInsertDto.getIdEscola());
        ficha.setIdMotivoInfrequencia(fichaInsertDto.getIdMotivoInfrequencia());
        ficha.setMotivoComplemento(fichaInsertDto.getMotivoComplemento());
        ficha.setSituacaoAluno(SituacaoAluno.valueOf(fichaInsertDto.getSituacaoAluno()));
        ficha.setStatus(Status.valueOf(fichaInsertDto.getStatus()));
        ficha.setVisitas(visitaMapper.toEntity(fichaInsertDto.getVisitas()));
        ficha.setResponsavel(fichaInsertDto.getResponsavel());

        return ficha;
    }

    public List<Ficha> toEntity (List<FichaInsertDTO> listFichaDto) {
        return listFichaDto.stream().map(this::toEntity).collect(Collectors.toList());
    }
    
    public FichaInsertDTO toDto (Ficha ficha) {
        FichaInsertDTO fichaInsertDto = new FichaInsertDTO();
        
        fichaInsertDto.setAluno(ficha.getAluno().getId());
        fichaInsertDto.setDataCadastro(ficha.getDataCadastro());
        fichaInsertDto.setHistoricoFichas(historicoFichaMapper.toDto(ficha.getHistoricoFichas()));
        fichaInsertDto.setId(ficha.getId());
        fichaInsertDto.setIdPublico(ficha.getIdPublico());
        fichaInsertDto.setIdEscola(ficha.getIdEscola());
        fichaInsertDto.setIdMotivoInfrequencia(ficha.getIdMotivoInfrequencia());
        fichaInsertDto.setMotivoComplemento(ficha.getMotivoComplemento());
        fichaInsertDto.setSituacaoAluno(ficha.getSituacaoAluno().getCode());
        fichaInsertDto.setStatus(ficha.getStatus().getCode());
        fichaInsertDto.setVisitas(visitaMapper.toDto(ficha.getVisitas()));
        fichaInsertDto.setResponsavel(ficha.getResponsavel());

        return fichaInsertDto;
    }

    public List<FichaInsertDTO> toDto (List<Ficha> listFicha) {
        return listFicha.stream().map(this::toDto).collect(Collectors.toList());
    }
}
