package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Helper {

    public static boolean loadWindow(ActionEvent actionEvent, String window) throws IOException {

        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

        Scene scene = new Scene(FXMLLoader.load(Helper.class.getResource(window)));
        stage.setScene(scene);
        stage.show();

        return true;

    }

}
