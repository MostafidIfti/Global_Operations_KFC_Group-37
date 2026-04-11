package com.example.kfcglobaloperationsapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Change the path to point to Login.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/hanif_2310091_oop_project_final/Login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("KFC Global Operations - Login"); // Updated Title
        stage.setScene(scene);
        stage.show();
    }
}
