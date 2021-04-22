package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<User> users = new ArrayList<>();
    public Encryption enc = new Encryption();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.show();

        Main.users = JSONFile.load();
        for (int x = 0; x < Main.users.size(); x++) {
            String name = Main.users.get(x).getName();

            String decName = enc.decrypt(name, "ABC123");
            Main.users.get(x).setName(decName);

            String email = Main.users.get(x).getEmail();

            String decEmail = enc.decrypt(email, "ABC123");
            Main.users.get(x).setEmail(decEmail);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
