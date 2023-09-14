package com.ficai4.backend;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ficai4.backend.model.Aluno;
import com.ficai4.backend.model.Cidade;
import com.ficai4.backend.model.Endereco;
import com.ficai4.backend.repository.AlunoRepository;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@CucumberContextConfiguration
public class CucumberAlunoSteps {

    @Autowired
    private AlunoRepository alunoRepository;
    private String cpf;
    private Optional<Aluno> aluno;

    @BeforeEach
    void setUp() {
        Aluno aluno1 = new Aluno("60076180050", "José Soares", "Vinicio Muller", "", "Maria Souto", true,
                true, LocalDate.now());
        Cidade cidade = new Cidade("52345", "Caxias Do Sul", "RS");
        Endereco endereco = new Endereco("91360220", "Rua Limoeiro", "135", "Bela Vista",
                "AP 1709 B", aluno1, cidade, null);
        aluno1.getEnderecos().add(endereco);

        alunoRepository.save(aluno1);
    }

    @Given("a non existant CPF")
    public void iHaveACPF() {
        this.cpf = "60076180060";
    }

    @When("the database does not retrieve an Aluno")
    public void iRetrieveAnAlunoFromTheDatabase() {
        this.aluno = alunoRepository.findByCpf(cpf);
    }

    @Then("result should not be an Aluno")
    public void iShouldHaveAnAluno() {
        assertFalse(this.aluno.isPresent());
    }
}