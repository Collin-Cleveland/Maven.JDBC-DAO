package daos;

import models.Cars;

import java.sql.*;
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
    public boolean update(Cars dto, int id) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("UPDATE cars SET make = ?, model = ?, " +
                            "year = ?, color = ?, vin = ? WHERE id = ?;");
            ps.setInt(6, id);
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            int i = ps.executeUpdate();

            if (i == 1){return true;}

        } catch (SQLException e) {
            throw new RuntimeException("Could not update database.", e);
        }

        return false;
    }

    public boolean create(Cars dto) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO cars (make, model, year, color, vin)" +
                            "VALUES (?, ?, ?, ?, ?);");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            int i = ps.executeUpdate();

            if (i == 1){return true;}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public boolean delete(int id) {
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Cars WHERE id = " + id + ";");

            if (i == 1){return true;}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
