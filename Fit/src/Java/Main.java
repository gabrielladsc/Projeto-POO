/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import Data.Exercicio;
import Data.Instrutor;
import Data.MySqlConnector;
import Data.dao.ExercicioDao;
import Data.dao.InstrutorDao;
import java.util.List;

/**
 *
 * @author gabi0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exercicio ex = new Exercicio("Supino", "3", "12");
        ex.setId(1);
        ExercicioDao dao = new ExercicioDao();
        dao.deletarExercicio(ex);
    }

}
