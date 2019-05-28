/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Mushfika
 */
public class Connect {
    
    Connection conn=null;
    
    public static Connection ConnectDB()
    {
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn= DriverManager.getConnection("jdbc:sqlite:Library.sqlite");
          //  JOptionPane.showMessageDialog(null, "Connect");
            
            return conn;
        } catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
          
        return null;
    }
}
