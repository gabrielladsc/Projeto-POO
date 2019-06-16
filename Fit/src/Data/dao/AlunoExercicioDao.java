/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.dao;

import Data.AlunoExercicio;
import Data.MySqlConnector;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabi0
 * 
 * Classe que gerencia a relação no banco entre um aluno e seus exercícios, 
 * espelhando esse comportamento na aplicação
 */
public class AlunoExercicioDao extends Dao {
    //Construtor que inicializa a conexão com o banco de dados
    public AlunoExercicioDao() {
        this.connection = MySqlConnector.getConnection();
    }

    //Através do id do aluno escolhido e do id do exercicio selecionado, cria
    //uma nova relação entre eles no banco
    public boolean adicionar(int alunoId, int exercicioId) {
        try {
            this.statement = this.connection.createStatement();
            String query = "INSERT INTO alunoxexercicio (alunoId, exercicioId) "
                    + "VALUES ('"
                    + alunoId + "','" + exercicioId + "');";
            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }

    //Recuperar todos os exercícios relacionados com um aluno específico,
    //através do id do aluno
    public List<AlunoExercicio> recuperar(int alunoId) {
        String queryRecuperar = "SELECT * FROM alunoxexercicio WHERE alunoId = " + '"' + alunoId + '"';
        List<AlunoExercicio> listaDeExerciciosAluno = new ArrayList();
        try {

            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(queryRecuperar);
            while (this.resultSet.next()) {
                AlunoExercicio alunoExercicio = new AlunoExercicio();
                alunoExercicio.setAlunoId(this.resultSet.getInt("alunoId"));
                alunoExercicio.setExercicioId(this.resultSet.getInt("exercicioId"));
                listaDeExerciciosAluno.add(alunoExercicio);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return listaDeExerciciosAluno;
    }

    //Remove a relação entre um aluno e um exercício. 
    //Contudo, ambos continuam existindo separadamente
    public boolean remover(int alunoId, int exercicioId) {
        try {
            this.statement = this.connection.createStatement();
            String query = "DELETE FROM alunoxexercicio WHERE alunoId = " + alunoId + " and exercicioId = " +  exercicioId;
            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }
    
    //Quando um aluno é excluido, remove todas as relações com quaisquer 
    //exercícios envolvendo o aluno em questão
    public boolean removerAluno(int alunoId) {
        try {
            this.statement = this.connection.createStatement();
            String query = "DELETE FROM alunoxexercicio WHERE alunoId = " + alunoId;
            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }
}
