/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import Data.MySqlConnector;

/**
 *
 * @author gabi0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySqlConnector.getConnection();
        System.out.println(MySqlConnector.status);
    }
    
}
