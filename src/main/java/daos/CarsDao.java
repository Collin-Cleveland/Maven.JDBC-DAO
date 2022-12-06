package daos;

import models.Cars;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarsDao implements DaoInterface {
    Connection connection = ConnectionDriver.getConnection();

    public CarsDao() {
    }

    public Cars extractCarsFromResultSet(ResultSet rs) throws SQLException {
        Cars car = new Cars();

        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("year"));
        car.setColor(rs.getString("color"));
        car.setVin(rs.getString("vin"));

        return car;
    }

    public Cars findById(int id) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cars WHERE id = " + id + ";");

            if (rs.next()){
                return extractCarsFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cars> findAll() {
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cars;");
            List<Cars> carsList = new ArrayList<>();

            while (rs.next()){
                Cars car = extractCarsFromResultSet(rs);
                carsList.add(car);
            }
            return carsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cars update(Cars dto) {
        return null;
    }

    public Cars create(Cars dto) {
        return null;
    }

    public void delete(int id) {

    }
}
