package com.ficai4.backend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ficai4.backend.enums.SituacaoAluno;
import com.ficai4.backend.enums.Status;
import com.ficai4.backend.model.Ficha;
import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.repository.AlunoRepository;

@Component
public class FichaMapper {

    @Autowired
    AlunoMapper alunoMapper;

    @Autowired
    HistoricoFichaMapper historicoFichaMapper;

    @Autowired
    VisitaMapper visitaMapper;

    @Autowired
    AlunoRepository alunoRepository;

    public Ficha toEntity (FichaDTO fichaDto) {
        Ficha ficha = new Ficha();
        
        ficha.setAluno(alunoRepository.findById(fichaDto.getAluno()).get());
        ficha.setDataCadastro(fichaDto.getDataCadastro());
        ficha.setHistoricoFichas(historicoFichaMapper.toEntity(fichaDto.getHistoricoFichas()));
        ficha.setId(fichaDto.getId());
        ficha.setIdEscola(fichaDto.getIdEscola());
        ficha.setIdMotivoInfrequencia(fichaDto.getIdMotivoInfrequencia());
        ficha.setMotivoComplemento(fichaDto.getMotivoComplemento());
        ficha.setSituacaoAluno(SituacaoAluno.valueOf(fichaDto.getSituacaoAluno()));
        ficha.setStatus(Status.valueOf(fichaDto.getStatus()));
        ficha.setVisitas(visitaMapper.toEntity(fichaDto.getVisitas()));
        ficha.setResponsavel(fichaDto.getResponsavel());

        return ficha;
    }

    public List<Ficha> toEntity (List<FichaDTO> listFichaDto) {
        return listFichaDto.stream().map(this::toEntity).collect(Collectors.toList());
    }
    
    public FichaDTO toDto (Ficha ficha) {
        FichaDTO fichaDto = new FichaDTO();
        
        fichaDto.setAluno(ficha.getAluno().getId());
        fichaDto.setDataCadastro(ficha.getDataCadastro());
        fichaDto.setHistoricoFichas(historicoFichaMapper.toDto(ficha.getHistoricoFichas()));
        fichaDto.setId(ficha.getId());
        fichaDto.setIdEscola(ficha.getIdEscola());
        fichaDto.setIdMotivoInfrequencia(ficha.getIdMotivoInfrequencia());
        fichaDto.setMotivoComplemento(ficha.getMotivoComplemento());
        fichaDto.setSituacaoAluno(ficha.getSituacaoAluno().getCode());
        fichaDto.setStatus(ficha.getStatus().getCode());
        fichaDto.setVisitas(visitaMapper.toDto(ficha.getVisitas()));
        fichaDto.setResponsavel(ficha.getResponsavel());

        return fichaDto;
    }

    public List<FichaDTO> toDto (List<Ficha> listFicha) {
        return listFicha.stream().map(this::toDto).collect(Collectors.toList());
    }
}
