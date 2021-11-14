package com.example.javaexampleservlet.util;

import java.sql.*;

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

    public static DbUtil getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new DbUtil();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instance;
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (con != null)
                con.close();

            if (ps != null)
                ps.close();

            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
