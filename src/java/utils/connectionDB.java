package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/WEBMAYVITINH";
    private static final String USER = "root";
    private static final String PASSWORD = "745535";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // Test your connection here or perform any other tasks
        try {
            Connection conn = connectionDB.getConnection();
            System.out.println("Connected to database successfully!");
            // You can perform database operations here
            // Remember to close the connection when done
            connectionDB.closeConnection();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
