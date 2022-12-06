package daos;

import models.Cars;
import java.util.List;

public interface DaoInterface{

    public Cars findById(int id);

    public List<Cars> findAll();

    public Cars update(Cars dto);

    public Cars create(Cars dto);

    public void delete(int id);
}
