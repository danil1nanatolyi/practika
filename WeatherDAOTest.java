package sample;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class WeatherDAOTest {

    @Test
    public void getConnectionTest(){
        try {
            Assert.assertNotNull(WeatherDAO.getConnection("weather"));
            Assert.assertNotNull(WeatherDAO.getConnection("session1_01"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
