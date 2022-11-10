package com.ficai4.backend.repository;

import com.ficai4.backend.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID> {

        @Query("SELECT aluno FROM Aluno aluno WHERE aluno.cpf = :cpf ")
        Optional<Aluno> findByCpf(@Param("cpf") String cpf);

        @Query("SELECT distinct aluno FROM Aluno aluno " +
                        "inner join Endereco ende on ende.aluno.id = aluno.id " +
                        "inner join Cidade cid on cid.id = ende.cidade.id " +
                        "WHERE (aluno.cpf  like %:word% " +
                        " or lower(aluno.nome) like %:word% or lower(aluno.responsavelPrimario) like %:word% " +
                        "or lower(cid.nome) like %:word%)")
        Optional<Page<Aluno>> findByAnyWord(@Param("word") String word, Pageable pageable);
}
