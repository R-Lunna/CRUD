/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.JFrameRoot;

/**
 *
 * @author Rafael Luna
 */
public class ConnectionDataBase {
    private static String url;
    private static String user;
    private static String password;
    
    private static Connection connection = null;
    
    private ConnectionDataBase() {
    }

    public static void setUrl(String url)
    throws NullPointerException
    {
        if( url == null )
            throw new NullPointerException("Url cannot be null");
        
        ConnectionDataBase.url = url;
    }

    public static void setUser(String user)
    throws NullPointerException
    {
        if( url == null )
            throw new NullPointerException("Url cannot be null");
        
        ConnectionDataBase.user = user;
    }

    public static void setPassword(String password)
    throws NullPointerException
    {
        if( url == null )
            throw new NullPointerException("Url cannot be null");
        
        ConnectionDataBase.password = password;
    }
    
    public static Connection getConnection() 
    {
        
        if (connection == null) {
            
            try 
            {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Success");
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog( new JFrameRoot().getFrame() ,"Error creating database connection", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }  
        
        return connection;
    }
 
}
