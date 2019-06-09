/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;
import View.LoginInstrutor;

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
        LoginInstrutor login = new LoginInstrutor();
        login.setVisible(true);
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {     // Mudar aqui o Look And Feel
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
