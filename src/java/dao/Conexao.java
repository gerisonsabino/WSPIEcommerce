package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao 
{
    public static Connection getConnection() throws Exception 
    {
        Connection con = null;
        
        String serverName = "localhost";
        String portNumber = "3306";
        String mydatabase = "pi_ecommerce";

        String username = "root";
        String password = "root";

        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName);

        String url = "jdbc:mysql://" + serverName +  ":"+ portNumber+"/" + mydatabase+"?useSSL=false";
        con = DriverManager.getConnection(url, username, password);

        return con;
    }
}