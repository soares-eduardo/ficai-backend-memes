package com.ficai4.backend;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.ficai4.backend.enums.SituacaoAluno;
import com.ficai4.backend.enums.Status;
import com.ficai4.backend.enums.TipoPerfil;
import com.ficai4.backend.model.*;
import com.ficai4.backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendConfiguration {
        @Bean
        CommandLineRunner commandLineRunner(AlunoRepository alunoRepository, CidadeRepository cidadeRepository,
                                            EnderecoRepository enderecoRepository, TelefoneRepository telefoneRepository, FichaRepository fichaRepository) {
                return args -> {

                        UUID idUsuario = UUID.fromString("42024b9e-4363-11ed-b878-0242ac120002");
                        UUID idEscola = UUID.fromString("5eb2f2d4-4363-11ed-b878-0242ac120002");
                        UUID idMotivo = UUID.fromString("6c3aeb3c-4363-11ed-b878-0242ac120002");

                        Aluno aluno1 = new Aluno("60076180050", "jose  Soares", "Vinicio Muller", "Maria Souto", true,
                                        true);
                        Aluno aluno2 = new Aluno("60076180051", "Jose  Soares", "Silvio Muller", "Joaquina Souto", true,
                                        true);
                        Aluno aluno3 = new Aluno("60076180052", "Jose Soares", "Maria Muller", "Felipe Souto", true,
                                        true);

                        Aluno aluno4 = new Aluno("53597799054", "Arielson Soares", "Jair Soares", null, true, true);
                        Aluno aluno5 = new Aluno("60076180051", "Eduardo Soares", "Vinicio Muller", "Maria Souto", true,
                                        true);

                        Telefone telefone1 = new Telefone(aluno1, "051", "998732729", "Jair");
                        Telefone telefone2 = new Telefone(aluno2, "051", "998453729", "Maria");

                        aluno1.getTelefones().add(telefone1);
                        aluno2.getTelefones().add(telefone2);

                        Cidade cidade1 = new Cidade("5234565", "Porto Alegre", "RS");
                        Cidade cidade2 = new Cidade("5234578", "Caxias Do Sul", "RS");
                        Cidade cidade3 = new Cidade("5234574", "Anta Gorda", "RS");

                        // Cidade cidade1 = new Cidade("43149", "Porto Alegre", "Rio Grande do Sul",
                        // "RS");

                        Endereco endereco1 = new Endereco("91360-220", "Rua Limoeiro", "135", "Bela Vista",
                                        "AP 1709 B", aluno1, cidade1, "Ao lado da churrascaria Gauchinho");
                        Endereco endereco2 = new Endereco("91360-220", "Rua Andorinhas", "34", "Cristo Redentor",

                                        "AP 6905 A", aluno2, cidade2, null);
                        Endereco endereco3 = new Endereco("91360-220", "Avenida Ipiranga", "344", "Bom Fim",
                                        "AP 1709 B", aluno3, cidade3, null);

                        Endereco endereco4 = new Endereco("91360230", "Rua Jardineiro", "835", "Bela Vista",
                                        "AP 1709 B", aluno1, cidade1, "Em frente ao posto Ipiranga");

                        //Escolas
                        Escola escola1 = new Escola("12345678", "Dr. martins Costa Jr.", "91234332",
                                "Rua das Andorinhas", "434", "Prédio", "Cascata", "Caxias do Sul", "RS");


                        //Usuarios
                        Usuario usuario1 = new Usuario("Secretária de Escola", TipoPerfil.CONSELHO_TUTELAR);



                        //motivoInfrequencia
                        MotivoInfrequencia motivoInfrequencia = new MotivoInfrequencia("Evasão", "Teste", 2);

                        //Ficha
                        Ficha ficha1 = new Ficha(SituacaoAluno.EVADIDO, Status.AGUARDANDO_VISITA, "Aluno falta demais",  aluno1, idEscola, idUsuario, idMotivo);

                        //historicoFicha
                        HistoricoFicha historicoFicha = new HistoricoFicha(LocalDate.now(), "Status teste", "Responsavel teste", ficha1);

                        //visitas
                        Visita visita = new Visita("Visita teste", "Secretaria teste", false, ficha1, usuario1, LocalDate.now());

                        ficha1.getHistoricoFichas().add(historicoFicha);
                        ficha1.getVisitas().add(visita);

                        aluno1.getFichas().add(ficha1);

                        aluno1.getEnderecos().add(endereco4);
                        aluno1.getEnderecos().add(endereco1);
                        aluno2.getEnderecos().add(endereco2);
                        aluno3.getEnderecos().add(endereco3);

                        alunoRepository.saveAll(List.of(aluno1, aluno2, aluno3));
                        fichaRepository.save(ficha1);
                };
        }
}
