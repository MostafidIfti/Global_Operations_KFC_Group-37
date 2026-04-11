package com.example.kfcglobaloperationsapp.IFTI_2310321;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DemandForecastingController {

    @FXML private TableView<SM_DemandForecast> forecastTableView;
    @FXML private TableColumn<SM_DemandForecast, String> itemCol;
    @FXML private TableColumn<SM_DemandForecast, Integer> pastSalesCol;
    @FXML private TableColumn<SM_DemandForecast, String> trendCol;
    @FXML private TableColumn<SM_DemandForecast, Integer> projectedCol;

    private ObservableList<SM_DemandForecast> forecastList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        itemCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        pastSalesCol.setCellValueFactory(new PropertyValueFactory<>("pastMonthSales"));
        trendCol.setCellValueFactory(new PropertyValueFactory<>("trend"));
        projectedCol.setCellValueFactory(new PropertyValueFactory<>("projectedDemand"));

        loadHistoricalData();
    }

    private void loadHistoricalData() {
        forecastList.add(new SM_DemandForecast("Chicken Breast (Boxes)", 500, "Increasing"));
        forecastList.add(new SM_DemandForecast("Cooking Oil (Liters)", 120, "Stable"));
        forecastList.add(new SM_DemandForecast("French Fries (Bags)", 800, "Increasing"));
        forecastList.add(new SM_DemandForecast("Secret Spice Mix (kg)", 50, "Decreasing"));

        forecastTableView.setItems(forecastList);
    }

    @FXML
    void handleGenerateForecast(ActionEvent event) {
        for (SM_DemandForecast item : forecastList) {
            item.generateForecast();
        }
        forecastTableView.refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Demand forecast generated for all items based on historical trends.");
        alert.showAndWait();
    }
}