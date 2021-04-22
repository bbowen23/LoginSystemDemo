package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LoginController {

    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField txtPassword;

    public void login(ActionEvent actionEvent) throws IOException, NoSuchAlgorithmException {

        User user = new User();

        for (int x = 0; x < Main.users.size(); x++) {
            if (Main.users.get(x).getUsername().equals(txtUsername.getText())) {

                user = Main.users.get(x);
                continue;

            } else {
                // TODO: Show message "Username or password are incorrect"
            }

        }

        if (user != null) {

            Hash hash = new Hash();
            byte[] saltByte = Base64.getDecoder().decode(user.getSalt());
            String hashedPassword = hash.getHash(txtPassword.getText(), saltByte);

            if (user.getPassword().equals(hashedPassword)) {
                Helper.loadWindow(actionEvent, "Home.fxml");
            } else {
                // TODO: Show message "Username or password are incorrect"
            }

        }

    }

    public void signup(ActionEvent actionEvent) throws IOException {

        Helper.loadWindow(actionEvent, "Signup.fxml");

    }
}
