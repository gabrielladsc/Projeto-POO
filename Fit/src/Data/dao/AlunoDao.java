/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.dao;

import Data.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class AlunoDao extends Dao {

    public boolean adicionarAluno(Aluno aluno) {
        try {
            this.statement = this.connection.createStatement();
            String query = "INSERT INTO aluno (idInstrutor, nome, idade, altura, objetivo, peso, sexo) "
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

    public List<Aluno> recuperarExercicios() {
        String query = "SELECT * FROM aluno";
        List<Aluno> listaDeAlunos = new ArrayList();

        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(this.resultSet.getInt("exercicio_id"));
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

    public boolean atualizarExercicio(Aluno aluno) {
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
