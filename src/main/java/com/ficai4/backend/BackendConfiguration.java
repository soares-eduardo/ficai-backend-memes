package com.ficai4.backend;

import java.time.LocalDate;
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

                        Aluno aluno1 = new Aluno("60076180050", "Eduardo Soares", "Vinicio Muller", "Maria Souto", true,
                                        true);
                        Aluno aluno2 = new Aluno("60076180050", "Eduardo Soares", "Vinicio Muller", "Maria Souto", true,
                                        true);
                        Aluno aluno3 = new Aluno("60076180050", "Eduardo Soares", "Vinicio Muller", "Maria Souto", true,
                                        true);

                        Telefone telefone1 = new Telefone(aluno1, "051", "998732729");
                        Telefone telefone2 = new Telefone(aluno2, "051", "998453729");
                        Telefone telefone3 = new Telefone(aluno3, "051", "924234534");

                        aluno1.getTelefones().add(telefone1);
                        aluno2.getTelefones().add(telefone2);
                        aluno3.getTelefones().add(telefone3);

                        Cidade cidade1 = new Cidade("52345", "Porto Alegre", "Rio Grande do Sul", "RS");

                        Endereco endereco1 = new Endereco("91360220", "Rua Limoeiro", "135", "Bela Vista",
                                        "AP 1709 B", aluno1, cidade1);
                        Endereco endereco2 = new Endereco("91360220", "Rua Andorinhas", "34", "Cristo Redentor",
                                        "AP 6905 A", aluno2, cidade1);
                        Endereco endereco3 = new Endereco("91360220", "Avenida Ipiranga", "344", "Bom Fim",
                                        "AP 1709 B", aluno3, cidade1);

                        aluno1.getEnderecos().add(endereco1);
                        aluno2.getEnderecos().add(endereco2);
                        aluno3.getEnderecos().add(endereco3);

                        alunoRepository.saveAll(List.of(aluno1, aluno2, aluno3));
                        cidadeRepository.saveAll(List.of(cidade1));
                        enderecoRepository.saveAll(List.of(endereco1, endereco2, endereco3));
                        telefoneRepository.saveAll(List.of(telefone1, telefone2, telefone3));

                };
        }
}
