/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author gabi0
 * 
 * Classe mãe que possui variáveis de conexão.
 */
public abstract class Dao {
    //Variável que gerencia a conexão com o banco de dados.
    protected Connection connection = null;
    
    //Variável utilizada para executar comando SQL e retornar resultados
    protected Statement statement = null;
    
    //Variável que armazena dados providos do banco de dados e que é utilizada
    //para recuperar esses dados para a aplicação
    protected ResultSet resultSet = null;
}
