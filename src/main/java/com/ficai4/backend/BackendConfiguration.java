package com.ficai4.backend;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.repository.AlunoRepository;

@Configuration
public class BackendConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(AlunoRepository alunoRepository) {
        return args -> {
            Aluno aluno1 = new Aluno();

            aluno1.setNome("Eduardo Soares");
            aluno1.setTelefone("51 998732729");
            aluno1.setResponsavelLegal("Daniela Soares");
            aluno1.setBeneficios("BPC");
            aluno1.setSituacao("Não matriculado");
            aluno1.setDataNascimento(LocalDate.now());

            Aluno aluno2 = new Aluno();

            aluno2.setNome("Gabrielly Vedana");
            aluno2.setTelefone("51 996440312");
            aluno2.setResponsavelLegal("Kellen Vedana");
            aluno2.setBeneficios("BPC");
            aluno2.setSituacao("Não matriculado");
            aluno2.setDataNascimento(LocalDate.now());

            System.out.println(aluno1);

            alunoRepository.saveAll(List.of(aluno1, aluno2));
        };
    }
}
