package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class FinanceMasterController {

    private void loadScreen(ActionEvent event, String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(com.example.kfcglobaloperationsapp.HelloApplication.class.getResource("/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/" + fxmlFileName));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void openGoal1(ActionEvent event) {
        loadScreen(event, "FinancialReportDashboard.fxml");
    }
}