package daos;

import models.Car;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CarDao implements DaoInterface {
    Connection connection = ConnectionDriver.getConnection();

    public CarDao() {
    }

    public Car findById(int id) {
        return null;
    }

    public List<Car> findAll() {
        return null;
    }

    public Car update(Car dto) {
        return null;
    }

    public Car create(Car dto) {
        return null;
    }

    public void delete(int id) {

    }
}
