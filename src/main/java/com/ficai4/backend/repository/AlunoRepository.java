package com.ficai4.backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ficai4.backend.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID> {

    @Query("SELECT aluno FROM Aluno aluno WHERE aluno.cpf = :cpf ")
    Optional<Aluno> findByCpf(String cpf);

    @Query("SELECT distinct aluno FROM Aluno aluno " +
            "inner join Endereco ende on ende.aluno.id = aluno.id " +
            "inner join Cidade cid on cid.id = ende.cidade.id " +
            "WHERE (aluno.cpf  like %:word% " +
    " or lower(aluno.nome) like %:word% or lower(aluno.responsavelPrimario) like %:word% " +
            "or lower(cid.nome) like %:word%)")
    Optional<List<Aluno>> findByAnyWord(@Param("word") String word);
}
