package com.ficai4.backend.repository;

import com.ficai4.backend.model.Ficha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, UUID> {

    @Query("SELECT ficha FROM Ficha ficha WHERE ficha.aluno.id = :alunoId AND ficha.status <> 4 ORDER BY ficha.dataCadastro DESC")
    List<Ficha> findFichaByAlunoId(UUID alunoId);
}
