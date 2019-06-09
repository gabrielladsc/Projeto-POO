/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import Data.Instrutor;
import Data.MySqlConnector;
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
        Instrutor instrutor = new Instrutor("Yabu", "pipoca");
        InstrutorDao instrutorDao = new InstrutorDao();
        if(instrutorDao.atualizarInstrutor(instrutor)){
            System.out.println("SUCESSO");
        } else {
            System.out.println("ERRO");
        }
    }

}
