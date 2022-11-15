package com.ficai4.backend.repository;

import com.ficai4.backend.model.Ficha;
import com.ficai4.backend.model.metrics.FichaMetric;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, UUID> {

    @Query("SELECT ficha FROM Ficha ficha WHERE ficha.aluno.id = :alunoId AND ficha.status <> 4 ORDER BY ficha.dataCadastro DESC")
    List<Ficha> findFichaByAlunoId(UUID alunoId);

    @Query("SELECT ficha FROM Ficha ficha WHERE ficha.status in (:status) " +
            "and (ficha.aluno.cpf like %:word% " +
            "or lower(ficha.aluno.nome) like %:word% " +
            "or cast(ficha.id as string) like %:word%) " +
            "ORDER BY ficha.dataCadastro DESC")
    Optional<Page<Ficha>> findFichaByStatus(@Param("word") String word, int[] status, Pageable pageable);
    @Query(
        "SELECT ficha " +
        "FROM Ficha ficha " +
        "WHERE (ficha.aluno.cpf like %:word% " +
           "or lower(ficha.aluno.nome) like %:word%) " +
        "ORDER BY ficha.status, ficha.aluno.nome"
        )
    Optional<List<Ficha>> findByAnyWord(@Param("word") String word);

    @Query("SELECT ficha FROM Ficha ficha where ficha.status = 1 or ficha.status = 2 or ficha.status = 3 ")
    Optional<List<Ficha>> findFichasAbertas();

    @Query("SELECT ficha FROM Ficha ficha where ficha.status = 4 ")
    Optional<List<Ficha>> findFichasArquivadas();

    @Query("SELECT ficha FROM Ficha ficha where ficha.situacaoAluno = 1 ")
    Optional<List<Ficha>> findALunosInfrequentesByFichas();

    @Query("SELECT ficha FROM Ficha ficha where ficha.situacaoAluno = 2 ")
    Optional<List<Ficha>> findALunosNaoMatriculadosByFichas();

    @Query("SELECT ficha FROM Ficha ficha where ficha.situacaoAluno = 3 ")
    Optional<List<Ficha>> findALunosEvadidosByFichas();

    @Query("SELECT distinct ficha FROM Ficha ficha " +
            "WHERE (ficha.aluno.cpf like %:word% " +
            "or lower(ficha.aluno.nome) like %:word% " +
            "or cast(ficha.id as string) like %:word%)")
    Optional<Page<Ficha>> findByAnyWord(@Param("word") String word, Pageable pageable);
}
