/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rafael Luna
 */
public class ConnectionDataBase {
    private static String url;
    private static String user;
    private static String password;
    
    private static Connection con = null;
    
    private ConnectionDataBase() {
    }

    public static void setUrl(String url)
    {
        ConnectionDataBase.url = url;
    }

    public static void setUser(String user)
    {
        ConnectionDataBase.user = user;
    }

    public static void setPassword(String password)
    {
        ConnectionDataBase.password = password;
    }
    
    public static Connection getConnection() 
    {
        
        if (con == null) {
            
            try {
                con = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Success");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }  
        
        return con;
    }
 
}
