package com.example.javaexampleservlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static DbUtil instance;
    private static Connection conn;

    public DbUtil() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DB_JSPServlet_Exam", "sa", "123456aA@");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public DbUtil getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new DbUtil();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instance;
    }
}
