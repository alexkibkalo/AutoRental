package ua.nure.kibkalo.database;

import org.junit.Test;

import java.sql.Connection;

public class ConnectionDBTest {
    @Test
    public void connection(){
        Connection connection = ConnectionDB.getConnection();
        assert connection != null;
    }
}
