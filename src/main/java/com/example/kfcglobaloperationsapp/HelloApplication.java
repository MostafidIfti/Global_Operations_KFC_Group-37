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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/KitchenSupervisor--fxml_files/kitchenSupervisorDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Finance Manager Dashboard");
=======
FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/FinanceMasterMenu.fxml"));        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Finance Master Menu");
>>>>>>> e82536310c30816a7d72b1e8599863d959c538a4
        stage.setScene(scene);
        stage.show();
    }
}