package daos;

import models.Cars;
import org.junit.Assert;
import org.junit.Test;


public class CarsDaoTest {

    @Test
    public void findByIdTest(){
        CarsDao test = new CarsDao();

        String actual = test.findById(1).getMake();
        String expected = "Nissan";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllTest(){
        CarsDao test = new CarsDao();

        String actual = test.findAll().get(3).getModel();
        String expected = "325xi";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateTest(){
        CarsDao test = new CarsDao();
        test.update(new  Cars("Hummer", "H1",
                        2012, "Yellow", "35213"), 2);

        Cars obj = test.findById(2);

        Assert.assertEquals("H1", obj.getModel());
        //DONT TEST AGAIN IT WILL FAIL AS TABLE HAS BEEN UPDATED
    }

    @Test
    public void createTest(){
        CarsDao test = new CarsDao();
        test.create(new Cars("Cadillac", "Escalade",
                        2020, "White", "44431"));

        Cars obj = test.findById(9);

        Assert.assertEquals("44431", obj.getVin());
        //DONT TEST AGAIN IT WILL FAIL AS TABLE HAS BEEN UPDATED
    }

    @Test
    public void deleteTest(){
        CarsDao test = new CarsDao();

        test.delete(3);

        Assert.assertNull(test.findById(3));
        //DONT TEST AGAIN IT WILL FAIL AS TABLE HAS BEEN UPDATED
    }
}
