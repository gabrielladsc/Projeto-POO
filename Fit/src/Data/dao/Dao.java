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
 * @author Guilherme
 */
public abstract class Dao {
    
    protected Connection connection = null;
    protected Statement statement = null;
    protected ResultSet resultSet = null;
}
