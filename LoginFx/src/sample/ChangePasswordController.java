package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangePasswordController {

    public void change(ActionEvent actionEvent) throws IOException {

        Helper.loadWindow(actionEvent, "Home.fxml");

    }

    public void cancel(ActionEvent actionEvent) throws IOException {

        Helper.loadWindow(actionEvent, "Home.fxml");

    }
}
