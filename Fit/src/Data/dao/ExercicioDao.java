/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.dao;

import Data.Exercicio;
import Data.MySqlConnector;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabi0
 */
public class ExercicioDao extends Dao {

    public ExercicioDao() {
        this.connection = MySqlConnector.getConnection();
    }

    public boolean adicionarExercicio(Exercicio exercicio) {
        try {
            this.statement = this.connection.createStatement();
            String query = "INSERT INTO exercicio (nome, serie, repeticoes) "
                    + "VALUES ('"
                    + exercicio.getNome() + "','" + exercicio.getSerie() + "','"
                    + exercicio.getRepeticoes() + "');";
            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }

    public List<Exercicio> recuperarExercicios() {
        String query = "SELECT * FROM exercicio";
        List<Exercicio> listaDeExercicios = new ArrayList();

        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                Exercicio exercicio = new Exercicio();
                exercicio.setId(this.resultSet.getInt("exercicio_id"));
                exercicio.setNome(this.resultSet.getString("nome"));
                exercicio.setSerie(this.resultSet.getString("serie"));
                exercicio.setRepeticoes(this.resultSet.getString("repeticoes"));
                listaDeExercicios.add(exercicio);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return listaDeExercicios;
    }

    public boolean atualizarExercicio(Exercicio exercicio) {
        try {
            this.statement = this.connection.createStatement();
            String queryAtualizar = "UPDATE exercicio SET "
                    + "nome = " + '"' + exercicio.getNome() + '"'
                    + ", serie = " + '"' + exercicio.getSerie() + '"'
                    + ", repeticoes = " + "'" + exercicio.getRepeticoes() + "'"
                    + " WHERE exercicio_id = " + '"'
                    + exercicio.getId() + '"';

            this.statement.executeUpdate(queryAtualizar);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }

    public boolean deletarExercicio(Exercicio exercicio) {
        try {
            this.statement = this.connection.createStatement();
            String queryDeletar = "DELETE FROM exercicio WHERE exercicio_id = "
                    + '"'+ exercicio.getId() + '"';
            this.statement.executeUpdate(queryDeletar);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }
}
