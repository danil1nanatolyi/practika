package sample;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerTest {

    @Test
    public void loginTest(){
        try {
            Connection connection = WeatherDAO.getConnection("session1_01");
            String sql = String.format("SELECT * FROM session1_01.users WHERE Email='%1$s' AND Password='%2$s'", "j.doe@amonic.com", "123");
            ResultSet resultSet = WeatherDAO.query(connection, sql);
            Assert.assertTrue(resultSet.next());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
