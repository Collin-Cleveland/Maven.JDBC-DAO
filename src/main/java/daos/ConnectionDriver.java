package daos;

import com.mysql.cj.jdbc.Driver;
import models.Cars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ConnectionDriver {
    static String username = "collin1";
    static String password = "zipcode0";
    static String dbUrl = "jdbc:mysql://localhost:3306/JDBC_DAO_LAB";

    public static void main(String[] args) {
        //Connection test
//        Connection connection = ConnectionDriver.getConnection();
//        if (connection != null) {System.out.println("Successfully connected");}
        CarsDao test = new CarsDao();

        //Find by ID
//        Cars obj = test.findById(4);
//        System.out.println(obj.getMake());
//        System.out.println(obj.getModel());
//        System.out.println(obj.getYear());
//        System.out.println(obj.getColor());
//        System.out.println(obj.getVin());

        //Find all
        for (Cars car : test.findAll()) {
            System.out.println(car.getMake());
            System.out.println(car.getModel());
            System.out.println(car.getYear());
            System.out.println(car.getColor());
            System.out.println(car.getVin());
            System.out.println("----------");
        }

        //Update
//        System.out.println(test.update(
//                new Cars("Rolls Royce", "Phantom",
//                        2022, "Black", "55555"), 6));
//        Cars obj = test.findById(6);
//        System.out.println(obj.getMake());
//        System.out.println(obj.getModel());
//        System.out.println(obj.getYear());
//        System.out.println(obj.getColor());
//        System.out.println(obj.getVin());

        //Create
//        System.out.println(test.create(
//                new Cars("Tesla", "Roadster",
//                        2020, "White", "11111")));
//        Cars obj = test.findById(8);
//        System.out.println(obj.getMake());
//        System.out.println(obj.getModel());
//        System.out.println(obj.getYear());
//        System.out.println(obj.getColor());
//        System.out.println(obj.getVin());

        //Delete
//        System.out.println(test.delete(7));

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
