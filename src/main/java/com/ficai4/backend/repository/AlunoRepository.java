package com.ficai4.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ficai4.backend.model.AlunoAntiga;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoAntiga, Long> {
    
    @Query("SELECT aluno " + "FROM Aluno aluno " + "WHERE aluno.cpf = :cpf ")
    Optional<AlunoAntiga> findByCpf(String cpf);
}
