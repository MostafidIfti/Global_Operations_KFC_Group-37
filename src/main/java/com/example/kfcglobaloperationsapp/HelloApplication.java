package com.example.kfcglobaloperationsapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/KitchenSupervisor--fxml_files/kitchenSupervisorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("KFC APP");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

    }
}
