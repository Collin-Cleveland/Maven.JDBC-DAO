package daos;

import models.Car;
import java.util.List;

public interface DaoInterface{

    public Car findById(int id);

    public List<Car> findAll();

    public Car update(Car dto);

    public Car create(Car dto);

    public void delete(int id);
}
