package com.ficai4.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ficai4.backend.mapper.FichaMapper;
import com.ficai4.backend.model.Ficha;
import com.ficai4.backend.model.dto.FichaDTO;
import com.ficai4.backend.repository.FichaRepository;

@Service
public class FichaService {
    
    @Autowired
    FichaRepository fichaRepository;

    @Autowired
    FichaMapper fichaMapper;

    @Transactional
    public List<FichaDTO> findAll() {
        return fichaMapper.toDto(fichaRepository.findAll());
    }

    @Transactional
    public FichaDTO createFicha(FichaDTO fichaDto) {  

        Ficha ficha = fichaMapper.toEntity(fichaDto);

        fichaRepository.save(ficha);

        return fichaMapper.toDto(ficha);
    }
}
