package com.example.kfcglobaloperationsapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("KFC Global - Employee Login");

=======
<<<<<<< HEAD
        // Change the path to point to Login.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/hanif_2310091_oop_project_final/Login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("KFC Global Operations - Login"); // Updated Title
>>>>>>> 7b041216a7457281b90131ef5d7811e387aaf063
        stage.setScene(scene);
=======

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Finance Manager Dashboard");
        stage.setScene(scene);
        stage.setMaximized(true);
>>>>>>> c54d0637a6ee3a0137bdd275f0788035279766dd
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}