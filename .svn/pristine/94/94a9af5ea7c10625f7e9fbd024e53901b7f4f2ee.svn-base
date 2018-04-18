package ua.nure.kibkalo.utils;

import org.junit.Test;
import ua.nure.kibkalo.beans.Car;
import ua.nure.kibkalo.beans.User;

public class SomeActionsTest {

    @Test
    public void price(){
        int price = new SomeActions().getPriceAcrossModel("BMW 2");
        assert price == 600;
    }

    @Test
    public void count(){
        int count = new SomeActions().getCountAcrossName("user");
        assert count == 468;
    }

    @Test
    public void car(){
        Car car = null;
        car = new SomeActions().getCarByModel("BMW 2");
        assert car != null;
    }

    @Test
    public void user(){
        User user = null;
        user = new SomeActions().getUserByName("user");
        assert user != null;
    }
}
