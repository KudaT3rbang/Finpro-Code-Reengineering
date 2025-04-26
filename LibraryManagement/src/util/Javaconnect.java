package util;

import java.sql.*;

public class Javaconnect {

    private static final String DB_URL = "jdbc:sqlite:LibraryDB.sqlite";

    public static Connection connectDb() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(DB_URL);
            
            createTablesIfNotExist(conn);
            
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error connecting to database", e);
        }
    }

    private static void createTablesIfNotExist(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String createAccountTableSQL = "CREATE TABLE IF NOT EXISTS Account (" +
                                          "username TEXT PRIMARY KEY," +
                                          "password TEXT NOT NULL," +
                                          "recoveryCode TEXT" +
                                          ");";
            stmt.execute(createAccountTableSQL);

            String createBookTableSQL = "CREATE TABLE IF NOT EXISTS Book (" +
                                        "ID TEXT PRIMARY KEY," +
                                        "title TEXT NOT NULL," +
                                        "writer TEXT NOT NULL," +
                                        "pageCount INTEGER" +
                                        ");";
            stmt.execute(createBookTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResources(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
