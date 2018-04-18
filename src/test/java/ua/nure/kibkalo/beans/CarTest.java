package ua.nure.kibkalo.beans;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void testGetAndSetCar(){
        Car car = new Car();
        Integer test_int = 10;
        String test_string = "car";

        car.setModel(test_string);
        Assert.assertEquals(test_string, car.getModel());
        car.setPrice(test_int);
        Assert.assertEquals(test_int, car.getPrice());
        car.setPower(test_int);
        assert 10.0 == car.getPower();
        car.setFuel_consumption(test_int);
        assert 10 == car.getFuel_consumption();
        car.setQualityClass(test_string);
        Assert.assertEquals(test_string, car.getQualityClass());
    }

}
