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
 * @author Guilherme
 */
public class AlunoExercicioDao extends Dao {

    public AlunoExercicioDao() {
        this.connection = MySqlConnector.getConnection();
    }

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
