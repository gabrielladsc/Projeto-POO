/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.dao;

import Data.MySqlConnector;
import java.sql.SQLException;

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
                    + alunoId + "','" + exercicioId  + "');";
            this.statement.executeUpdate(query);
            return true;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return false;
        }
    }    
}
