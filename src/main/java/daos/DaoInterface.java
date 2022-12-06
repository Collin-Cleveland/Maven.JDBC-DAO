package daos;

import models.Cars;
import java.util.List;

public interface DaoInterface{

    public Cars findById(int id);

    public List<Cars> findAll();

    public boolean update(Cars dto, int id);

    public boolean create(Cars dto);

    public boolean delete(int id);
}
