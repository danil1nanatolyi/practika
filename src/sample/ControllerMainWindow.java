package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerMainWindow implements Initializable {
    @FXML TableView<WeatherDay> table;
    @FXML TableColumn<WeatherDay, Integer> dayColumn;
    @FXML TableColumn<WeatherDay, Integer> monthColumn;
    @FXML TableColumn<WeatherDay, Integer> precipitationColumn;
    @FXML TableColumn<WeatherDay, Integer> temperatureColumn;
    @FXML TableColumn<WeatherDay, Integer> pressureColumn;
    @FXML TableColumn<WeatherDay, Integer> humidityColumn;

    ArrayList<WeatherDay> days = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dayColumn.setCellValueFactory(new PropertyValueFactory<>("day"));
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        precipitationColumn.setCellValueFactory(new PropertyValueFactory<>("precipitation"));
        temperatureColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        pressureColumn.setCellValueFactory(new PropertyValueFactory<>("pressure"));
        humidityColumn.setCellValueFactory(new PropertyValueFactory<>("humidity"));


        try {
            Connection connection = WeatherDAO.getConnection("weather");
            String sql = "SELECT * FROM weather.temperatures";

            ResultSet resultSet = WeatherDAO.query(connection, sql);

            while (resultSet.next()){
                int day = resultSet.getInt(2);
                int month = resultSet.getInt(3);
                int precipitation = resultSet.getInt(4);
                int temperature = resultSet.getInt(5);
                int pressure = resultSet.getInt(6);
                int humidity = resultSet.getInt(7);

                WeatherDay weatherDay = new WeatherDay(day, month, precipitation, temperature, pressure, humidity);
                days.add(weatherDay);
            }

            table.getItems().addAll(days);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
