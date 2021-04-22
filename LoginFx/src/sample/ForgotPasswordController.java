package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ForgotPasswordController {


    public void send(ActionEvent actionEvent) throws IOException {

        Helper.loadWindow(actionEvent, "Login.fxml");

    }

    public void cancel(ActionEvent actionEvent) throws IOException {

        Helper.loadWindow(actionEvent, "Login.fxml");

    }
}
