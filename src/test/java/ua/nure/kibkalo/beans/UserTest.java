package ua.nure.kibkalo.beans;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testGetAndSetCar(){
        User user = new User();
        Integer test_int = 10;
        String test_string = "user";

        user.setUsername(test_string);
        Assert.assertEquals(test_string, user.getUsername());
        user.setPassword(test_string);
        Assert.assertEquals(test_string, user.getPassword());
        user.setCount(test_int);
        Assert.assertEquals(test_int, user.getCount());
        user.setStatus(test_string);
        Assert.assertEquals(test_string, user.getStatus());
    }

}
