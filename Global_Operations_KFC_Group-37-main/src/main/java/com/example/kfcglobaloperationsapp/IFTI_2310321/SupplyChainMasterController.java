package com.example.kfcglobaloperationsapp.IFTI_2310321;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SupplyChainMasterController {


    private void loadScreen(ActionEvent event, String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(com.example.kfcglobaloperationsapp.HelloApplication.class.getResource("Ifti_2310321_FXML_FIles/Supply_Chain-Fxml_works/" + fxmlFileName));
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
        loadScreen(event, "SupplyChainDashboard.fxml");
    }

    @FXML
    void openGoal2(ActionEvent event) {
        loadScreen(event, "InventoryDashboard.fxml");
    }

    @FXML
    void openGoal3(ActionEvent event) {
        loadScreen(event, "SupplierManagementDashboard.fxml");
    }
    @FXML
    void openGoal4(ActionEvent event) {
        loadScreen(event, "ShipmentTrackerDashboard.fxml");
    }
    @FXML
    void openGoal5(ActionEvent event) {
        loadScreen(event, "StockTransferDashboard.fxml");
    }
    @FXML
    void openGoal6(ActionEvent event) {
        loadScreen(event, "DemandForecastingDashboard.fxml");
    }
    @FXML
    void openGoal7(ActionEvent event) {
        loadScreen(event, "WasteTrackingDashboard.fxml");
    }
    @FXML
    void openGoal8(ActionEvent event) {
        loadScreen(event, "SupplierEvaluationDashboard.fxml");
    }

}