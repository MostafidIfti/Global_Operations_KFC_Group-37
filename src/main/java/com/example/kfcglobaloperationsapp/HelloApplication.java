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
=======
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/FinancialReportDashboard.fxml"));
>>>>>>> adc28288832468c30915e4834f9fca45d520aedf
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Finance Manager Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}