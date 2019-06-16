/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.dao;

import Data.Aluno;
import Data.MySqlConnector;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabi0
 * 
 * Classe que gerencia os dados do aluno entre
 * a aplicação e o banco de dados.
 */
public class AlunoDao extends Dao {
    //Construtor que inicializa a conexão com o banco de dados
    public AlunoDao() {
        this.connection = MySqlConnector.getConnection();
    }

    //Através de uma instância do aluno cria um novo aluno no banco
    public boolean adicionarAluno(Aluno aluno) {
        try {
            //Insere um novo aluno no banco de dados através da Query SQL
            //Caso insira com sucesso, retorna true, senão, false
            this.statement = this.connection.createStatement();
            String query = "INSERT INTO aluno (idInstrutor, nome, "
                    + "idade, altura, objetivo, peso, sexo) "
                    + "VALUES ('"
                    + aluno.getInstrutorId() + "','" + aluno.getNome() + "','"
                    + aluno.getIdade() + "','" + aluno.getAltura() + "','"
                    + aluno.getObjetivo() + "','" + aluno.getPeso() + "','"
                    + aluno.getSexo() + "');";
            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }

    //Recupera todos os alunos do banco de dados e retorna em uma lista
    //contendo todos os alunos de acordo com o instrutor logado
    public List<Aluno> recuperarAlunos(int instrutorId) {
        String query = "SELECT * FROM aluno WHERE idInstrutor = " + '"' 
                + instrutorId + '"';
        List<Aluno> listaDeAlunos = new ArrayList();

        try {
            //Para cada aluno no banco, cria uma nova instância desse
            //aluno na aplicação
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(this.resultSet.getInt("aluno_id"));
                aluno.setInstrutorId(this.resultSet.getInt("idInstrutor"));
                aluno.setNome(this.resultSet.getString("nome"));
                aluno.setIdade(this.resultSet.getString("idade"));
                aluno.setAltura(this.resultSet.getString("altura"));
                aluno.setObjetivo(this.resultSet.getString("objetivo"));
                aluno.setPeso(this.resultSet.getString("peso"));
                aluno.setSexo(this.resultSet.getInt("sexo"));
                listaDeAlunos.add(aluno);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return listaDeAlunos;
    }

    //Recupera o id do aluno de acordo com seu nome
    public int recuperarIdAlunoPeloNome(String nome) {
        String query = "SELECT * FROM aluno WHERE nome = " + '"' + nome + '"' + " LIMIT 1";
        int id = 0;

        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                id = this.resultSet.getInt("aluno_id");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return id;
    }

    //Atualiza aluno. Caso atualize com sucesso,
    //retorna true, senão, false
    public boolean atualizarAluno(Aluno aluno) {
        try {
            this.statement = this.connection.createStatement();
            String queryAtualizar = "UPDATE aluno SET "
                    + "nome = " + '"' + aluno.getNome() + '"'
                    + ", idade = " + '"' + aluno.getIdade() + '"'
                    + ", altura = " + "'" + aluno.getAltura() + "'"
                    + ", objetivo = " + "'" + aluno.getObjetivo() + "'"
                    + ", peso = " + "'" + aluno.getPeso() + "'"
                    + ", sexo = " + "'" + aluno.getSexo() + "'"
                    + " WHERE aluno_id = " + '"' + aluno.getId() + '"';

            this.statement.executeUpdate(queryAtualizar);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }

    //Deleta o aluno. Caso delete com sucesso retorna true, senão, false
    public boolean deletarAluno(Aluno aluno) {
        try {
            this.statement = this.connection.createStatement();
            String queryDeletar = "DELETE FROM aluno WHERE aluno_id = "
                    + '"' + aluno.getId() + '"';
            this.statement.executeUpdate(queryDeletar);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }
}
