package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    @FXML
    TextField loginTF;
    @FXML
    TextField passwordTF;

    @FXML
    Button loginBtn;
    @FXML
    Button exitBtn;
    @FXML
    Label timerL;

    @FXML
    public void login(){
        try {
            Connection connection = WeatherDAO.getConnection("session1_01");

            String login = loginTF.getText();
            String password = passwordTF.getText();
            String sql = String.format("SELECT * FROM session1_01.users WHERE Email='%1$s' AND Password='%2$s'", login, password);

            ResultSet resultSet = WeatherDAO.query(connection, sql);

            //Если нет пользователя с таким логином/паролем
            if (!resultSet.next()){
                alert("INCORRECT LOGIN/PASSWORD", "Некорректные данные");
            } else {
//                alert("SUCCESS", "Введены корректные данные");
                Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Погодка");
                stage.setScene(new Scene(root, 540, 400));
                stage.show();
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    public void exit(){
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    private void alert(String head, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(head);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
