package com.ficai4.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.ficai4.backend.model.metrics.AlunoMetric;
import com.ficai4.backend.model.metrics.FichaMetric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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

import java.util.*;

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
    public Page<FichaDTO> findByAnyWord(String word, int page, int size, Sort.Direction direction, String atributo,
            int[] status) {

        if (status.length > 0) {
            return pagePorStatus(word, page, size, status);
        }

        if (atributo.toLowerCase().equals("nome")) {
            return pagePorNome(word, page, size, direction, atributo);
        } else if (atributo.toLowerCase().equals("cpf")) {
            return pagePorCPF(word, page, size, direction, atributo);
        }

        PageRequest pageRequest = PageRequest.of(page, size, direction, atributo);

        Optional<Page<Ficha>> response = fichaRepository.findByAnyWord(word, pageRequest);

        if (response.isEmpty() || response.get().isEmpty()) {
            throw new EntityNotFoundException("Ficha não encontrada.");
        }
        List<FichaDTO> dto = fichaMapper.toDto(response.get().stream().collect(Collectors.toList()));

        return new PageImpl<>(dto, response.get().getPageable(),
                response.get().getTotalElements());
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

    @Transactional
    public FichaDTO updateResponsavelFicha(UUID idFicha, Integer responsavel) {

        Optional<Ficha> ficha = fichaRepository.findById(idFicha);

        if (ficha.isEmpty()) {
            throw new NotFoundException("Ficha não encontrada com o id informado.");
        }

        ficha.get().setResponsavel(responsavel);

        return fichaMapper.toDto(ficha.get());

    }

    @Transactional
    public VisitaDTO createVisita(VisitaDTO visitaDto) {

        Ficha ficha = fichaRepository.findById(visitaDto.getFichaId())
                .orElseThrow(() -> new NotFoundException("Ficha não encontrada com o id informado."));

        ficha.setVisitas(List.of(visitaMapper.toEntity(visitaDto)));

        int sizeVisitaList = ficha.getVisitas().size();

        if (sizeVisitaList == 1) {
            ficha.setStatus(Status.EM_VISITACAO);
        }

        fichaRepository.save(ficha);

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

    @Transactional
    public FichaMetric findFichaMetrics(){
        FichaMetric fichaMetric = new FichaMetric();
        fichaMetric.setOpenFichas(fichaRepository.findFichasAbertas().get().size());
        fichaMetric.setClosedFichas(fichaRepository.findFichasArquivadas().get().size());
        return fichaMetric;
    }

    @Transactional
    public AlunoMetric findAlunoMetricsByFicha(){
        AlunoMetric alunoMetric = new AlunoMetric();

        alunoMetric.setInfrequente(fichaRepository.findALunosInfrequentesByFichas().get().size());
        alunoMetric.setNaoMatriculado(fichaRepository.findALunosNaoMatriculadosByFichas().get().size());
        alunoMetric.setEvasao(fichaRepository.findALunosEvadidosByFichas().get().size());

        return alunoMetric;
    }
    private void ordenarPorNomeAlunoAsc(List<FichaDTO> dtos) {
        dtos.sort(Comparator.comparing(fichaDTO -> fichaDTO.getAluno().getNome().toLowerCase()));
    }

    private void ordenarPorNomeAlunoDesc(List<FichaDTO> dtos) {
        dtos.sort(Comparator.comparing(fichaDTO -> fichaDTO.getAluno().getNome().toLowerCase()));
        Collections.reverse(dtos);
    }

    private void ordenarPorCPFAlunoAsc(List<FichaDTO> dtos) {
        dtos.sort(Comparator.comparing(fichaDTO -> fichaDTO.getAluno().getCpf()));
    }

    private void ordenarPorCPFAlunoDesc(List<FichaDTO> dtos) {
        dtos.sort(Comparator.comparing(fichaDTO -> fichaDTO.getAluno().getCpf()));
        Collections.reverse(dtos);
    }

    private Page<FichaDTO> pagePorNome(String palavra, int page, int size, Sort.Direction direction, String atributo) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Optional<Page<Ficha>> response = fichaRepository.findByAnyWord(palavra, pageRequest);
        if (response.isEmpty() || response.get().isEmpty()) {
            throw new EntityNotFoundException("Ficha não encontrada.");
        }
        List<FichaDTO> dto = fichaMapper.toDto(response.get().stream().collect(Collectors.toList()));
        if (direction.isAscending()) {
            ordenarPorNomeAlunoAsc(dto);
        } else {
            ordenarPorNomeAlunoDesc(dto);
        }

        return new PageImpl<>(
                dto,
                response.get().getPageable(),
                response.get().getTotalElements());
    }

    private Page<FichaDTO> pagePorStatus(String palavra, int page, int size, int[] status) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Optional<Page<Ficha>> response = fichaRepository.findFichaByStatus(palavra, status, pageRequest);
        if (response.isEmpty() || response.get().isEmpty()) {
            throw new EntityNotFoundException("Ficha não encontrada.");
        }
        List<FichaDTO> dto = fichaMapper.toDto(response.get().stream().collect(Collectors.toList()));

        return new PageImpl<>(
                dto,
                response.get().getPageable(),
                response.get().getTotalElements());
    }

    private Page<FichaDTO> pagePorCPF(String palavra, int page, int size, Sort.Direction direction, String atributo) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Optional<Page<Ficha>> response = fichaRepository.findByAnyWord(palavra, pageRequest);
        if (response.isEmpty() || response.get().isEmpty()) {
            throw new EntityNotFoundException("Ficha não encontrada.");
        }

        List<FichaDTO> dto = fichaMapper.toDto(response.get().stream().collect(Collectors.toList()));
        if (direction.isAscending()) {
            ordenarPorCPFAlunoAsc(dto);
        } else {
            ordenarPorCPFAlunoDesc(dto);
        }

        return new PageImpl<>(
                dto,
                response.get().getPageable(),
                response.get().getTotalElements());
    }

}
