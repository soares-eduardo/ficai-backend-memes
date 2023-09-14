Feature: Aluno

    Scenario: Buscar alunos por id
        Given a non existant CPF
        When the database does not retrieve an Aluno
        Then result should not be an Aluno
