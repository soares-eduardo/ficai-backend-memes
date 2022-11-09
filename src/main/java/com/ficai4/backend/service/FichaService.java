package com.ficai4.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ficai4.backend.enums.Status;
import com.ficai4.backend.exceptions.EntityNotFoundException;
import com.ficai4.backend.exceptions.NotFoundException;
import com.ficai4.backend.mapper.FichaInsertMapper;
import com.ficai4.backend.mapper.FichaMapper;
import com.ficai4.backend.mapper.VisitaMapper;
import com.ficai4.backend.model.Escola;
import com.ficai4.backend.model.Ficha;
import com.ficai4.backend.model.MotivoInfrequencia;
import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.model.dto.FichaInsertDTO;
import com.ficai4.backend.model.dto.VisitaDTO;
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

    @Autowired
    FichaInsertMapper fichaInsertMapper;

    @Autowired
    VisitaMapper visitaMapper;

    @Transactional
    public Page<FichaDTO> findAll() {
        int page = 0;
        int size = 10;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");

        return new PageImpl<>(
                fichaMapper.toDto((List<Ficha>) fichaRepository.findAll()),
                pageRequest, size);

    }

    @Transactional
    public List<FichaDTO> findByAnyWord(String word) {

        Optional<List<Ficha>> response = fichaRepository.findByAnyWord(word);

       if(response.isEmpty() || response.get().isEmpty()){
          throw new EntityNotFoundException("Ficha não encontrada.");
        }

        return fichaMapper.toDto(response.get());
    }

    @Transactional
    public FichaInsertDTO createFicha(FichaInsertDTO fichaDto) {

        if (fichaDto.getIdEscola() != null) {
            Optional<Escola> escola = escolaRepository.findById(fichaDto.getIdEscola());
            if (escola.isEmpty()) {
                throw new NotFoundException("Escola não encontrada com o id informado.");
            }
        }

        if (fichaDto.getIdMotivoInfrequencia() != null) {
            Optional<MotivoInfrequencia> motivoInfrequencia = motivoInfrequenciaRepositoy
                    .findById(fichaDto.getIdMotivoInfrequencia());
            if (motivoInfrequencia.isEmpty()) {
                throw new NotFoundException("Motivo da infrequencia não encontrado com o id informado.");
            }
        }

        Ficha ficha = fichaInsertMapper.toEntity(fichaDto);

        fichaRepository.save(ficha);

        return fichaInsertMapper.toDto(ficha);
    }

    @Transactional
    public FichaDTO updateStatusFicha(UUID idFicha, Status statusFicha) {

        Optional<Ficha> ficha = fichaRepository.findById(idFicha);

        if (ficha.isEmpty()) {
            throw new NotFoundException("Ficha não encontrada com o id informado.");
        }

        ficha.get().setStatus(statusFicha);

        return fichaMapper.toDto(ficha.get());
    }

    public VisitaDTO createVisita(VisitaDTO visitaDto) {

        Ficha ficha = fichaRepository.findById(visitaDto.getFichaId())
                .orElseThrow(() -> new NotFoundException("Ficha não encontrada com o id informado."));

        ficha.setVisitas(List.of(visitaMapper.toEntity(visitaDto)));

        int sizeVisitaList = ficha.getVisitas().size();

        if (sizeVisitaList == 1) {
            ficha.setStatus(Status.EM_VISITACAO);
        }

        return visitaMapper.toDto(ficha.getVisitas().get(sizeVisitaList - 1));
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
