package sample;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ControllerMainWindowTest {

    @Test
    public void isAllDaysNotEmptyTest(){
        ControllerMainWindow controllerMainWindow = new ControllerMainWindow();
        ArrayList<WeatherDay> days = controllerMainWindow.getAllDays("weather", "SELECT * FROM weather.temperatures");
        Assert.assertTrue(days.size() > 0);
    }

    @Test
    public void getAllDaysTest(){
        ArrayList<WeatherDay> list = new ArrayList<>();
        list.add(new WeatherDay(1, 1, 9, -2, 748, 99));
        list.add(new WeatherDay(1, 2, 6, -10, 762, 95));
        list.add(new WeatherDay(1, 3, 6, -5, 747, 94));
        ControllerMainWindow controllerMainWindow = new ControllerMainWindow();
        ArrayList<WeatherDay> days = controllerMainWindow.getAllDays("weather", "SELECT * FROM weather.temperatures WHERE numberDay = '1'");

        String expected = "";
        for (int i = 0; i < list.size(); i++){
            expected += list.get(i).getDay() + " " + list.get(i).getMonth() + " " + list.get(i).getTemperature() + " ";
        }
        String real = "";
        for (int i = 0; i < days.size(); i++){
            real += days.get(i).getDay() + " " + days.get(i).getMonth() + " " + days.get(i).getTemperature() + " ";
        }
        Assert.assertEquals(expected, real);

    }
}
