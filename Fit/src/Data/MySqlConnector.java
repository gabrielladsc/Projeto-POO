/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabi0
 * 
 * Classe responsável por estabelecer uma conexão e retornar uma instância da
 * mesma para realizar transações com o banco de dados.
 */
public class MySqlConnector {
    
    public static String status = "Nao conectou...";
    
    public MySqlConnector(){
       
    } 
    
    //Obtém uma instância de conexão com o banco de dados
    public static Connection getConnection() {
        Connection connection = null; //Variável de conexão
        
        try {
            String driverName = "com.mysql.cj.jdbc.Driver"; //nome do driver de conexão
            Class.forName(driverName);
            
            String serverName = "localhost:3306"; //nome do servidor que possui o Banco de dados
            String database = "mydatabase"; //nome do banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + database + "?useTimezone=true&serverTimezone=UTC";
            String username = "root"; // nome de usuário para acesso ao banco de dados
            String password = ""; // senha para acesso ao banco de dados
            
            //Obter variável de conexão através dos dados criados anteriormente
            connection = DriverManager.getConnection(url, username, password);
            
            //Verificando se a conexão foi estabelecida com sucesso
            if (connection != null) {
                status = ("Conectado com sucesso!");
            } else {
                status = ("Não foi possível estabelecer uma conexão com o banco de dados");
            }
           
            return connection;
        } catch (ClassNotFoundException exception) {
            System.out.println("O driver não foi encontrado");
            return null;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return null;
        }
    }
    
    //Retorna o status da conexão
    public static String connectionStatus(){
        return status;
    }
    
    public static boolean closeConnection(){
        try {
           MySqlConnector.getConnection().close();
           return true;
        } catch (SQLException sqlException) {
            return false;
        }
    }
    
    public static Connection restartConnection(){
        closeConnection();
        return MySqlConnector.getConnection();
    }
}
