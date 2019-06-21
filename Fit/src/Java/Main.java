/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import View.LoginInstrutor;

/**
 *
 * @author gabi0
 * 
 * Classe para inicializar a aplicação
 */
public class Main {

    /**
     * @param args the command line arguments
     *
     *
     */
    public static void main(String[] args) {
        //Instancia e deixa visível a tela que será a inicialização da aplicação
        LoginInstrutor login = new LoginInstrutor();
        login.setVisible(true);

        //Muda o tema da aplicação
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {// Muda o Look And Feel da aplicacação
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
