package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;

public class HomeController {

    public void logout(ActionEvent actionEvent) throws IOException {

        Helper.loadWindow(actionEvent, "Login.fxml");

    }

    public void changePassword(ActionEvent actionEvent) throws IOException {

        Helper.loadWindow(actionEvent, "ChangePassword.fxml");

    }
}
