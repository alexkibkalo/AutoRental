package ua.nure.kibkalo.database.DAO.User;

import org.junit.Test;
import ua.nure.kibkalo.beans.User;
import ua.nure.kibkalo.utils.SomeActions;

import java.util.List;

public class UserDaoImplTest {

    @Test
    public void check(){
        User user = new UserDaoImpl().checkUserConnection("user");
        assert user != null;
    }

    @Test
    public void allUser(){
        List<User> users = new UserDaoImpl().getAllUser();
        assert users != null;
    }

    @Test
    public void count(){
        new UserDaoImpl().countUpdate(100, "user");
        User user = new SomeActions().getUserByName("user");
        assert user.getCount() == 100;
    }

    @Test
    public void status(){
        new UserDaoImpl().statusUpdate("test", "user");
        User user = new SomeActions().getUserByName("user");
        assert user.getStatus().equals("test");
    }

}
