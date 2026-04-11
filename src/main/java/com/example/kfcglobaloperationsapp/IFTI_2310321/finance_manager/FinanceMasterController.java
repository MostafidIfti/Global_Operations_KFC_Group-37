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

    // Helper method to switch screens
    private void loadScreen(ActionEvent event, String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/" + fxmlFileName));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not load: " + fxmlFileName);
        }
    }

    @FXML
    void openGoal1(ActionEvent event) {
        loadScreen(event, "FinancialReportDashboard.fxml");
    }

    @FXML
    void openGoal2(ActionEvent event) {
        loadScreen(event, "VendorPaymentDashboard.fxml");
    }
    @FXML
    void openGoal3(ActionEvent event) {
        loadScreen(event, "BudgetManagementDashboard.fxml");
    }
    @FXML
    void openGoal4(ActionEvent event) {
        loadScreen(event, "RevenueMonitoringDashboard.fxml");
    }
    @FXML
    void openGoal5(ActionEvent event) {
        loadScreen(event, "ExpenseManagementDashboard.fxml");
    }
}