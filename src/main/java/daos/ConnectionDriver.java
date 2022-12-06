package daos;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDriver {
    static String username = "collin1";
    static String password = "zipcode0";
    static String dbUrl = "jdbc:mysql://localhost:3306/JDBC_DAO_LAB";

    public static void main(String[] args) {
        Connection connection = ConnectionDriver.getConnection();
        if (connection != null) {System.out.println("Successfully connected");}
    }

        public static Connection getConnection () {
            try {
                DriverManager.registerDriver(new Driver());
                System.out.println("Connection processing...");
                return DriverManager.getConnection(dbUrl, username, password);
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting with the database!!!", e);
            }
        }
    }
