
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/APM";
    private static String username = "root";
    private static String password = "";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}