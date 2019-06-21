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
 *
 * Classe que gerencia os dados do instrutor entre a aplicação e o banco de
 * dados.
 */
public class InstrutorDao extends Dao {

    //Construtor que inicializa a conexão com o banco de dados
    public InstrutorDao() {
        this.connection = MySqlConnector.getConnection();
    }

    //Através de uma instância do instrutor cria um novo instrutor no banco
    public boolean adicionarInstrutor(Instrutor instrutor) {
        try {
            /*insere um novo instrutor no banco de dados através da Query SQL
            Caso insira com sucesso, retorna true, senão, false*/
            this.statement = this.connection.createStatement();
            String query = "INSERT INTO instrutor (nome, senha, logado) VALUES ('"
                    + instrutor.getNome() + "','" + instrutor.getSenha() + "'," + false + ");";
            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }

    //Recupera todos os instrutores do banco de dados e retorna em uma lista
    //contendo todos os instrutores
    public List<Instrutor> recuperarInstrutor() {
        String query = "SELECT * FROM instrutor";
        List<Instrutor> listaDeInstrutores = new ArrayList();

        try {
            //Para cada instrutor no banco, cria uma nova instância desse
            //instrutor na aplicação
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                Instrutor instrutor = new Instrutor();
                instrutor.setId(this.resultSet.getInt("instrutor_id"));
                instrutor.setNome(this.resultSet.getString("nome"));
                instrutor.setSenha(this.resultSet.getString("senha"));
                instrutor.setLogado(this.resultSet.getBoolean("logado"));
                listaDeInstrutores.add(instrutor);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return listaDeInstrutores;
    }

    //Recupera o instrutor que tem o status logado = true para cadastrar
    //o aluno corretamente
    public Instrutor recuperarInstrutorLogado() {
        String query = "SELECT * FROM instrutor WHERE logado = true LIMIT 1";
        Instrutor instrutorLogado = null;

        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                instrutorLogado = new Instrutor();
                instrutorLogado.setId(this.resultSet.getInt("instrutor_id"));
                instrutorLogado.setNome(this.resultSet.getString("nome"));
                instrutorLogado.setSenha(this.resultSet.getString("senha"));
                instrutorLogado.setLogado(this.resultSet.getBoolean("logado"));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return instrutorLogado;
    }

    /**
     * Atualiza instrutor se esquecer a senha. Caso atualize com sucesso,
     * retorna true, senão, false
     */
    public boolean atualizarSenhaInstrutor(Instrutor instrutor) {
        //Query que recupera um instrutor de acordo com seu nome
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

            //Query que atualiza a senha do instrutor
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

    /**
     *
     * Atualiza um instrutor. Caso atualize com sucesso, retorna true, senão,
     * false
     */
    public boolean atualizarInstrutor(Instrutor instrutor) {
        try {
            this.statement = this.connection.createStatement();
            //Query que atualiza instrutor
            String queryAtualizar = "UPDATE instrutor SET senha = " + '"'
                    + instrutor.getSenha() + '"' 
                    + ", nome = " + '"' + instrutor.getNome() + '"'
                    + " WHERE instrutor_id = " + '"' 
                    + instrutor.getId() + '"';
            this.statement.executeUpdate(queryAtualizar);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }

    //Quando um instrutor loga, o status logado é setado para true
    public boolean alterarLogadoInstrutor(Instrutor instrutor, boolean logado) {
        try {
            this.statement = this.connection.createStatement();
            String queryAtualizar = "UPDATE instrutor SET logado = " + logado
                    + " WHERE instrutor_id = " + '"' + instrutor.getId() + '"';

            this.statement.executeUpdate(queryAtualizar);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }
    
    //Deleta o instrutor. Caso delete com sucesso retorna true, senão, false
    public boolean deletarInstrutor(Instrutor instrutor) {
        try {
            this.statement = this.connection.createStatement();
            String queryDeletar = "DELETE FROM instrutor WHERE instrutor_id = "
                    + '"' + instrutor.getId() + '"';
            this.statement.executeUpdate(queryDeletar);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }
}
