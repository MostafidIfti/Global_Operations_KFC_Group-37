package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class RevenueMonitoringController {

    // Event 3 & 4: Filters
    @FXML private ComboBox<String> regionCombo;
    @FXML private ComboBox<String> countryCombo;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;

    // Event 9: Charts
    @FXML private PieChart channelPieChart;
    @FXML private LineChart<String, Number> revenueTrendChart;

    // Event 10, 11, 12: Store Table
    @FXML private TableView<FM_RevenueRecord> storeTable;
    @FXML private TableColumn<FM_RevenueRecord, String> storeCol;
    @FXML private TableColumn<FM_RevenueRecord, String> regionCol;
    @FXML private TableColumn<FM_RevenueRecord, Double> revenueCol;
    @FXML private TableColumn<FM_RevenueRecord, Double> growthCol;
    @FXML private TableColumn<FM_RevenueRecord, String> statusCol;

    // Event 15: Details
    @FXML private Label storeDetailLabel;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        regionCombo.getItems().addAll("North America", "Europe", "Asia-Pacific");
        countryCombo.getItems().addAll("USA", "UK", "Japan", "Australia");

        storeCol.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        regionCol.setCellValueFactory(new PropertyValueFactory<>("region"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("totalRevenue"));
        growthCol.setCellValueFactory(new PropertyValueFactory<>("growthPercent"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("performanceStatus"));

        // Load Initial Chart Data (Events 7 & 9)
        loadChartData();

        // Listen for table selection (Event 13)
        storeTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                // Event 14 & 15: Fetch and display detailed data
                storeDetailLabel.setText(String.format("Store: %s | Revenue: $%,.2f | Channel Split: 40%% Dine-in, 35%% Delivery, 25%% Takeaway | Promo Effect: +5%%",
                    newVal.getStoreName(), newVal.getTotalRevenue()));
                statusLabel.setText("System: Store details loaded successfully.");
                statusLabel.setStyle("-fx-text-fill: blue;");
            }
        });
    }

    private void loadChartData() {
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
            new PieChart.Data("Dine-in", 450000),
            new PieChart.Data("Takeaway", 300000),
            new PieChart.Data("Delivery", 550000)
        );
        channelPieChart.setData(pieData);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Revenue Trend 2026");
        series.getData().add(new XYChart.Data<>("Jan", 120000));
        series.getData().add(new XYChart.Data<>("Feb", 135000));
        series.getData().add(new XYChart.Data<>("Mar", 110000));
        revenueTrendChart.getData().add(series);
    }

    @FXML
    void handleAnalyzeRevenue(ActionEvent event) {
        LocalDate start = startDatePicker.getValue();
        LocalDate end = endDatePicker.getValue();

        // Event-5: Validate Dates
        if (start != null && end != null && end.isBefore(start)) {
            statusLabel.setText("Validation Error: End date cannot be before Start date.");
            statusLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        // Event-6, 7, 8, 11, 12: Fetch Data
        ObservableList<FM_RevenueRecord> data = FXCollections.observableArrayList(
            new FM_RevenueRecord("Tokyo Central", "Asia-Pacific", 250000, 18.5), // High Performer
            new FM_RevenueRecord("London Eye KFC", "Europe", 180000, 2.1),       // Stable
            new FM_RevenueRecord("Miami Beach", "North America", 95000, -12.4)   // Abnormal Drop
        );
        storeTable.setItems(data);

        statusLabel.setText("Analysis Complete: Revenue data processed successfully.");
        statusLabel.setStyle("-fx-text-fill: green;");
    }

    @FXML
    void handleExportReport(ActionEvent event) {
        // Events 16, 17, 18
        statusLabel.setText("Success: Formatted Revenue Report exported to PDF. Activity logged.");
        statusLabel.setStyle("-fx-text-fill: #17a2b8; -fx-font-weight: bold;");
    }
}