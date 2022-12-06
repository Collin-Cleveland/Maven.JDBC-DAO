package daos;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDriver {
    static String username = "collin1";
    static String password = "zipcode0";
    static String dbUrl = "jdbc:mysql://localhost.3306/JDBC_DAO_LAB";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("Connection Successful!!!");
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException exception) {
            System.out.println("Error connecting with the database!!!");
        }
        return null;
    }
}
