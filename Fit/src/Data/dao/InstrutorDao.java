/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.dao;

import Data.Instrutor;
import Data.MySqlConnector;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabi0
 */
public class InstrutorDao extends Dao {

    public InstrutorDao() {
        this.connection = MySqlConnector.getConnection();
    }

    public boolean adicionarInstrutor(Instrutor instrutor) {
        try {
            this.statement = this.connection.createStatement();
            String query = "INSERT INTO instrutor (nome, senha) VALUES ('" + 
                    instrutor.getNome() + "','" + instrutor.getSenha() + "');";
            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }

    public List<Instrutor> recuperarInstrutor() {
        String query = "SELECT * FROM instrutor";
        List<Instrutor> listaDeInstrutores = new ArrayList();

        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                Instrutor instrutor = new Instrutor();
                instrutor.setId(this.resultSet.getInt("instrutor_id"));
                instrutor.setNome(this.resultSet.getString("nome"));
                instrutor.setSenha(this.resultSet.getString("senha"));
                listaDeInstrutores.add(instrutor);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return listaDeInstrutores;
    }

    public boolean atualizarInstrutor(Instrutor instrutor) {
        String queryRecuperarInstrutor = "SELECT * FROM instrutor WHERE nome = "
                + '"' + instrutor.getNome() + '"' + " LIMIT 1";
        Instrutor novoInstrutor = new Instrutor();

        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(queryRecuperarInstrutor);
            while (this.resultSet.next()) {
                novoInstrutor.setId(this.resultSet.getInt("instrutor_id"));
                novoInstrutor.setNome(this.resultSet.getString("nome"));
                novoInstrutor.setSenha(instrutor.getSenha());
            }

            String queryAtualizar = "UPDATE instrutor SET senha = " + '"'
                    + instrutor.getSenha() + '"' + " WHERE instrutor_id = " + '"'
                    + novoInstrutor.getId() + '"';

            this.statement.executeUpdate(queryAtualizar);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }

    }
}
