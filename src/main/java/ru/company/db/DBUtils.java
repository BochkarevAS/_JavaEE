package ru.company.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/test_db";
        String user = "postgres";
        String pass = "root";

        Connection connection = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps = connection.prepareStatement(sql);

        return ps;
    }
}
