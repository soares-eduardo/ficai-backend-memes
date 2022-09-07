package com.ficai4.backend;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.Cidade;
import com.ficai4.backend.model.Endereco;
import com.ficai4.backend.model.Telefone;
import com.ficai4.backend.repository.AlunoRepository;
import com.ficai4.backend.repository.CidadeRepository;
import com.ficai4.backend.repository.EnderecoRepository;
import com.ficai4.backend.repository.TelefoneRepository;

@Configuration
public class BackendConfiguration {
        @Bean
        CommandLineRunner commandLineRunner(AlunoRepository alunoRepository, CidadeRepository cidadeRepository,
                        EnderecoRepository enderecoRepository, TelefoneRepository telefoneRepository) {
                return args -> {

                        Aluno aluno1 = new Aluno("53597799054", "Arielson Soares", "Jair Soares", null, true, true);
                        Aluno aluno2 = new Aluno("60076180051", "Eduardo Soares", "Vinicio Muller", "Maria Souto", true,
                                        true);

                        Telefone telefone1 = new Telefone(aluno1, "051", "998732729");
                        Telefone telefone2 = new Telefone(aluno2, "051", "998453729");

                        aluno1.getTelefones().add(telefone1);
                        aluno2.getTelefones().add(telefone2);

                        Cidade cidade1 = new Cidade("43149", "Porto Alegre", "Rio Grande do Sul", "RS");

                        Endereco endereco1 = new Endereco("91360220", "Rua Limoeiro", "135", "Bela Vista",
                                        "AP 1709 B", aluno1, cidade1);
                        Endereco endereco2 = new Endereco("91360220", "Rua Andorinhas", "34", "Cristo Redentor",
                                        "AP 6905 A", aluno2, cidade1);

                        aluno1.getEnderecos().add(endereco1);
                        aluno2.getEnderecos().add(endereco2);

                        alunoRepository.saveAll(List.of(aluno1, aluno2));
                };
        }
}
