package com.ficai4.backend.repository;

import com.ficai4.backend.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, UUID> {
}
