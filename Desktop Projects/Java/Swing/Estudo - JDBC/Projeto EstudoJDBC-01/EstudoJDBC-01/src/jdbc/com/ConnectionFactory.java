/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mag
 */
public class ConnectionFactory {
    public Connection getConexao() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/javajdbc";
        String user = "root";
        String passwd = "root";
        try {
            Connection connection = DriverManager.getConnection(url, user, passwd);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
