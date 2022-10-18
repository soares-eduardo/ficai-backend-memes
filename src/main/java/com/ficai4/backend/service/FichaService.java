package com.ficai4.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ficai4.backend.exceptions.NotFoundException;
import com.ficai4.backend.mapper.FichaMapper;
import com.ficai4.backend.model.Escola;
import com.ficai4.backend.model.Ficha;
import com.ficai4.backend.model.MotivoInfrequencia;
import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.repository.EscolaRepository;
import com.ficai4.backend.repository.FichaRepository;
import com.ficai4.backend.repository.MotivoInfrequenciaRepository;

@Service
public class FichaService {

    @Autowired
    FichaRepository fichaRepository;

    @Autowired
    EscolaRepository escolaRepository;

    @Autowired
    MotivoInfrequenciaRepository motivoInfrequenciaRepositoy;

    @Autowired
    FichaMapper fichaMapper;

    @Transactional
    public List<FichaDTO> findAll() {
        return fichaMapper.toDto(fichaRepository.findAll());
    }

    @Transactional
    public FichaDTO createFicha(FichaDTO fichaDto) {  

        Optional<Escola> escola = escolaRepository.findById(fichaDto.getIdEscola());
        if (escola.isEmpty()) {
            throw new NotFoundException("Escola não encontrada com o id informado.");
        }

        Optional<MotivoInfrequencia> motivoInfrequencia = motivoInfrequenciaRepositoy.findById(fichaDto.getIdMotivoInfrequencia());
        if (motivoInfrequencia.isEmpty()) {
            throw new NotFoundException("Motivo da infrequencia não encontrado com o id informado.");
        }

        Ficha ficha = fichaMapper.toEntity(fichaDto);

        fichaRepository.save(ficha);

        return fichaMapper.toDto(ficha);
    }

    @Transactional
    public FichaDTO findFichaByAlunoId(UUID alunoId) {
        List<Ficha> fichas = fichaRepository.findFichaByAlunoId(alunoId);

        if (fichas.isEmpty()) {
            throw new NotFoundException("Ficha não encontrada com o id informado.");
        }

        return fichaMapper.toDto(fichas.get(fichas.size() - 1));
    }
}
