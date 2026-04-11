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
FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/FinanceMasterMenu.fxml"));        Scene scene = new Scene(fxmlLoader.load());
=======
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/Cashier_Fxml_Files/cashierDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
>>>>>>> a1f6775d65f74abb96a1623579f6805b4f0eebf3
        stage.setTitle("KFC APP");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

    }
}
