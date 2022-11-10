package com.ficai4.backend.config;

import java.time.LocalDate;
import java.util.List;

import com.ficai4.backend.enums.SituacaoAluno;
import com.ficai4.backend.enums.Status;
import com.ficai4.backend.model.*;
import com.ficai4.backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BackendConfiguration {
        @Bean
        CommandLineRunner commandLineRunner(AlunoRepository alunoRepository, CidadeRepository cidadeRepository,
                        EnderecoRepository enderecoRepository, TelefoneRepository telefoneRepository,
                        FichaRepository fichaRepository, EscolaRepository escolaRepository,
                        MotivoInfrequenciaRepository motivoInfrequenciaRepository) {
                return args -> {

                        // Alunos

                        Aluno aluno1 = new Aluno("60076180050", "Ana Clara Soares", "Vinicio Soares", "Maria Soares",
                                        true,
                                        true, LocalDate.now());
                        Aluno aluno2 = new Aluno("60076180051", "Artur Mendes", "Silvio Mendes", "Joaquina Mendes",
                                        true,
                                        true, LocalDate.now());
                        Aluno aluno3 = new Aluno("67545633388", "Carolina da Silva", "Maria Muller", "", false,
                                        true, LocalDate.now());
                        Aluno aluno4 = new Aluno("90877834333", "Eduardo Gomes", "Luana Gomes", "Felipe Gomes", true,
                                        true, LocalDate.now());
                        Aluno aluno5 = new Aluno("67393834476", "Gabriela Roques", "Joana Roques", "Carlos Roques",
                                        false,
                                        false, LocalDate.now());
                        Aluno aluno6 = new Aluno("09878345678", "Henrique Medeiros", "Claudia Medeiros",
                                        "Roberto Medeiros", false,
                                        false, LocalDate.now());
                        Aluno aluno7 = new Aluno("78946278754", "Larissa Barros", "Maristela Silva", "Fábio Silva",
                                        true,
                                        false, LocalDate.now());
                        Aluno aluno8 = new Aluno("09823423465", "Manoella Lopes", "Karla Lopes", "Karina Padilha",
                                        false,
                                        false, LocalDate.now());
                        Aluno aluno9 = new Aluno("73253405643", "Natália Galina", "Juliana Galina", "Henry Galina",
                                        false,
                                        true, LocalDate.now());
                        Aluno aluno10 = new Aluno("89903432333", "Pedro Silva", "Martina Silva", "João Carlos Silva",
                                        true,
                                        true, LocalDate.now());
                        Aluno aluno11 = new Aluno("66563418767", "Raissa Farias", "Armando Farias", "Juliano Farias",
                                        false,
                                        false, LocalDate.now());
                        Aluno aluno12 = new Aluno("87654390877", "Sabrina Julian Freitas", "Gabriela Freitas", "",
                                        false,
                                        false, LocalDate.now());
                        Aluno aluno13 = new Aluno("65443378766", "Sofia Bento", "Maria Bento", "Vinicius Bento", false,
                                        true, LocalDate.now());
                        Aluno aluno14 = new Aluno("73253405643", "Vitor Lima", "Thiago Lima", "", false,
                                        false, LocalDate.now());
                        Aluno aluno15 = new Aluno("73253405643", "Yasmin Moraes", "Jaqueline Moraes", "", false,
                                        false, LocalDate.now());

                        // Telefones responsáveis

                        Telefone telefone1 = new Telefone(aluno1, "051", "998732729", "Vinicio");
                        Telefone telefone2 = new Telefone(aluno2, "051", "998453729", "Silvio");
                        Telefone telefone3 = new Telefone(aluno3, "054", "998988880", "Felipe");
                        Telefone telefone4 = new Telefone(aluno4, "055", "999932235", "Luana");
                        Telefone telefone5 = new Telefone(aluno5, "051", "985467323", "Carlos");
                        Telefone telefone6 = new Telefone(aluno6, "055", "955567878", "Cláudia");
                        Telefone telefone7 = new Telefone(aluno7, "051", "990876433", "Fabio");
                        Telefone telefone8 = new Telefone(aluno8, "054", "967444464", "Karla");
                        Telefone telefone9 = new Telefone(aluno9, "051", "997889442", "Juliana");
                        Telefone telefone10 = new Telefone(aluno10, "051", "999099999", "Martina");
                        Telefone telefone11 = new Telefone(aluno11, "054", "998765555", "Armando");
                        Telefone telefone12 = new Telefone(aluno12, "051", "998453729", "Gabriela");
                        Telefone telefone13 = new Telefone(aluno13, "051", "999997645", "Maria");
                        Telefone telefone14 = new Telefone(aluno14, "051", "999877655", "Thiago");
                        Telefone telefone15 = new Telefone(aluno15, "051", "999536767", "Jaqueline");

                        aluno1.getTelefones().add(telefone1);
                        aluno2.getTelefones().add(telefone2);
                        aluno3.getTelefones().add(telefone3);
                        aluno4.getTelefones().add(telefone4);
                        aluno5.getTelefones().add(telefone5);
                        aluno6.getTelefones().add(telefone6);
                        aluno7.getTelefones().add(telefone7);
                        aluno8.getTelefones().add(telefone8);
                        aluno9.getTelefones().add(telefone9);
                        aluno10.getTelefones().add(telefone10);
                        aluno11.getTelefones().add(telefone11);
                        aluno12.getTelefones().add(telefone12);
                        aluno13.getTelefones().add(telefone13);
                        aluno14.getTelefones().add(telefone14);
                        aluno15.getTelefones().add(telefone15);

                        // Cidades

                        Cidade cidade1 = new Cidade("5234565", "Porto Alegre", "RS");
                        Cidade cidade2 = new Cidade("5234578", "Caxias Do Sul", "RS");
                        Cidade cidade3 = new Cidade("5443233", "Canoas", "RS");
                        Cidade cidade4 = new Cidade("5678777", "Sapucaia do Sul", "RS");
                        Cidade cidade5 = new Cidade("5456888", "Pelotas", "RS");
                        Cidade cidade6 = new Cidade("5544323", "Bagé", "RS");
                        Cidade cidade7 = new Cidade("5367587", "Viamão", "RS");

                        // Endereços

                        Endereco endereco1 = new Endereco("91360-220", "Rua Limoeiro", "135", "Bela Vista", "AP 1709 B",
                                        aluno1, cidade1, "Ao lado da churrascaria Gauchinho");
                        Endereco endereco2 = new Endereco("91360-220", "Rua Andorinhas", "34", "Cristo Redentor",
                                        "AP 6905 A", aluno2, cidade2, null);
                        Endereco endereco3 = new Endereco("91360-220", "Avenida Ipiranga", "344", "Bom Fim",
                                        "AP 1709 B", aluno3, cidade3, null);
                        Endereco endereco4 = new Endereco("92412-226", "Rua dos Pardais", "835", "Igara", "AP 432",
                                        aluno4, cidade3, "Na frente da farmácia");
                        Endereco endereco5 = new Endereco("93218-680", "Rua Erva Mate", "54", "São José", "casa",
                                        aluno5, cidade4, "");
                        Endereco endereco6 = new Endereco("95045-300", "Rua Nilson Soares", "222", "Centenário",
                                        "ap 78", aluno6, cidade2, "Do lado da prefeitura");
                        Endereco endereco7 = new Endereco("96085-310", "Travessa José Nelcimar Laroque", "45", "Areal",
                                        "ap 505", aluno7, cidade5, "");
                        Endereco endereco8 = new Endereco("90610-384", "Rua Paulo Giovanni Neumann da Silva", "12",
                                        "Partenon", "Casa de esquina", aluno8, cidade1,
                                        "Bem perto do colégio Mãe de Deus");
                        Endereco endereco9 = new Endereco("91440-585", "Via Três", "43", "Jardim Carvalho", "Ap 43",
                                        aluno9, cidade1, "");
                        Endereco endereco10 = new Endereco("95098-100", "Rua Bortolo Triches", "34", "Salgado Filho",
                                        "ap 302", aluno10, cidade2, "Do lado da brigada");
                        Endereco endereco11 = new Endereco("90810-070", "Avenida Capivari", "1234", "Cristal", "ap 202",
                                        aluno11, cidade1, "");
                        Endereco endereco12 = new Endereco("91340-190", "Rua General Iba Mesquita Ilha Moreira", "34",
                                        "Boa Vista", "401", aluno12, cidade1, "");
                        Endereco endereco13 = new Endereco("96407-220", "Rua Antônio Llano Valls", "2341", "Popular",
                                        "casa 12", aluno13, cidade6, "");
                        Endereco endereco14 = new Endereco("95059-560", "Rua Angelo Orlandi", "45", "Serrano", "",
                                        aluno14, cidade2, "");
                        Endereco endereco15 = new Endereco("94415-370", "Rua Mauá", "20", "Tarumã",
                                        "Do lado da farmácia", aluno15, cidade7, "");

                        // Escolas

                        Escola escola1 = new Escola("12345678", "Dr. martins Costa Jr.", "91234332",
                                        "Rua das Andorinhas", "434", "Prédio", "Cascata", "Caxias do Sul", "RS");
                        Escola escola2 = new Escola("76645367", "Anjo da Guarda", "91790-043",
                                        "Rua C", "32", "", "Restinga", "Porto Alegre", "RS");
                        Escola escola3 = new Escola("32387677", "Menino Maluquinho", "90250-380",
                                        "Rua Gilson Soares Cardias", "423", "", "Farrapos", "Porto Alegre", "RS");
                        Escola escola4 = new Escola("45566634", "Mãe de Deus", "92020-030",
                                        "Rua Dona Rafaela", "54", "", "Marechal Rondon", "Canoas", "RS");
                        escolaRepository.save(escola1);

                        // motivoInfrequencia
                        MotivoInfrequencia motivoInfrequencia = new MotivoInfrequencia("Evasão", "Teste", 2);

                        motivoInfrequenciaRepository.save(motivoInfrequencia);

                        // Ficha
                        Ficha ficha1 = new Ficha(SituacaoAluno.EVADIDO, Status.AGUARDANDO_VISITA, "Aluno falta demais",
                                        aluno1, escola1.getId(), motivoInfrequencia.getId(), 1);

                        // HistoricoFicha

                        HistoricoFicha historicoFicha = new HistoricoFicha(LocalDate.now(), 2,
                                        1, ficha1);

                        ficha1.getHistoricoFichas().add(historicoFicha);

                        aluno1.getFichas().add(ficha1);

                        aluno1.getEnderecos().add(endereco1);
                        aluno2.getEnderecos().add(endereco2);
                        aluno3.getEnderecos().add(endereco3);
                        aluno4.getEnderecos().add(endereco4);
                        aluno5.getEnderecos().add(endereco5);
                        aluno6.getEnderecos().add(endereco6);
                        aluno7.getEnderecos().add(endereco7);
                        aluno8.getEnderecos().add(endereco8);
                        aluno9.getEnderecos().add(endereco9);
                        aluno10.getEnderecos().add(endereco10);
                        aluno11.getEnderecos().add(endereco11);
                        aluno12.getEnderecos().add(endereco12);
                        aluno13.getEnderecos().add(endereco13);
                        aluno14.getEnderecos().add(endereco14);
                        aluno15.getEnderecos().add(endereco15);

                        alunoRepository.saveAll(List.of(aluno1, aluno2, aluno3, aluno4, aluno5, aluno6, aluno7, aluno8,
                                        aluno9, aluno10, aluno11, aluno12, aluno13, aluno14, aluno15));
                        fichaRepository.save(ficha1);
                };
        }
}