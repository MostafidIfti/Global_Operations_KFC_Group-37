package com.example.kfcglobaloperationsapp.Uzair_2521139;

import com.example.kfcglobaloperationsapp.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LaunchApp extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(com.example.kfcglobaloperationsapp.HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/loginView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.show();
        }
    }

