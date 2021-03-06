package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Helper;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SignupController {

    @FXML
    public TextField txtName;
    @FXML
    public TextField txtEmail;
    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField txtPassword;
    @FXML
    public PasswordField txtConfirmPassword;

    public void signup(ActionEvent actionEvent) throws IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {

        User user = new User();
        Hash hash = new Hash();
        user.setName(txtName.getText());
        user.setUsername(txtUsername.getText());
        user.setEmail(txtEmail.getText());
       // user.setPassword(txtPassword.getText());
       // user.setSalt(null);

        byte[] salt = hash.getSalt();
        String password = hash.getHash(txtPassword.getText(), salt);

        user.setPassword(password);
        String saltString = Base64.getEncoder().encodeToString(salt);
        user.setSalt(saltString);

        Main.users.add(user);

        Encryption enc = new Encryption();

        for (int x = 0; x < Main.users.size(); x++) {

            String encName = enc.encrypt(Main.users.get(x).getName(), "ABC123");
            Main.users.get(x).setName(encName);

            String encEmail = enc.encrypt(Main.users.get(x).getEmail(), "ABC123");
            Main.users.get(x).setEmail(encEmail);

        }

        JSONFile.save(Main.users);

        Helper.loadWindow(actionEvent, "Home.fxml");

    }

    public void cancel(ActionEvent actionEvent) throws IOException {

        Helper.loadWindow(actionEvent, "Login.fxml");

    }
}
