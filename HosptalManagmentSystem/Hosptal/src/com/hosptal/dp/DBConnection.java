package com.hosptal.dp;

import java.sql.*;

public class DBConnection {
    private static String url="jdbc:mysql://localhost:3306/hosptaldata";
    private static String userName="root";
    private static String password="Ananth@24";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,userName,password);
    }
}
