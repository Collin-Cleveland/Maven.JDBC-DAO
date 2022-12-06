package models;

import org.junit.Assert;
import org.junit.Test;

public class CarsTest {

    @Test
    public void nullaryConstructorTest() {
        Cars car = new Cars();

        Assert.assertEquals(0, car.getId());
        Assert.assertNull(car.getMake());
        Assert.assertNull(car.getModel());
        Assert.assertEquals(0, car.getYear());
        Assert.assertNull(car.getColor());
        Assert.assertNull(car.getVin());
    }

    @Test
    public void constructorNoIdTest() {
        Cars car = new Cars("Rolls Royce", "Phantom", 2021, "Black", "45451");

        Assert.assertEquals("Rolls Royce", car.getMake());
        Assert.assertEquals("Phantom", car.getModel());
        Assert.assertEquals(2021, car.getYear());
        Assert.assertEquals("Black", car.getColor());
        Assert.assertEquals("45451", car.getVin());
    }

    @Test
    public void constructorTest() {
        Cars car = new Cars("Honda", "Civic", 2010, "White", "11111");

        Assert.assertEquals("Honda", car.getMake());
        Assert.assertEquals("Civic", car.getModel());
        Assert.assertEquals(2010, car.getYear());
        Assert.assertEquals("White", car.getColor());
        Assert.assertEquals("11111", car.getVin());
    }

    @Test
    public void setMakeTest() {
        Cars car = new Cars("Honda", "Civic", 2010, "White", "11111");

        car.setMake("Mazda");

        Assert.assertEquals("Mazda", car.getMake());
    }

    @Test
    public void setModelTest() {
        Cars car = new Cars("Mazda", "3", 2000, "Blue", "00000");

        car.setModel("Benz");

        Assert.assertEquals("Benz", car.getModel());
    }

    @Test
    public void setYearTest() {
        Cars car = new Cars("BMW", "325i", 2013, "Blue", "12354");

        car.setYear(2000);

        Assert.assertEquals(2000, car.getYear());
    }

    @Test
    public void setColorTest() {
        Cars car = new Cars("BMW", "325i", 2013, "Blue", "21124");

        car.setColor("Red");

        Assert.assertEquals("Red", car.getColor());
    }

    @Test
    public void setVinTest() {
        Cars car = new Cars("BMW", "325i", 2013, "Blue", "21124");

        car.setVin("00712");

        Assert.assertEquals("00712", car.getVin());
    }
}
