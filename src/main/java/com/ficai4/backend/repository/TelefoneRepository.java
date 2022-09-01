package com.ficai4.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ficai4.backend.model.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, UUID>{
    
}
