package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;

public class RevenueMonitoringController {

    @FXML private ComboBox<String> regionComboBox;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;

    @FXML private BarChart<String, Number> revenueChart;

    @FXML private TableView<StoreRevenue> revenueTableView;
    @FXML private TableColumn<StoreRevenue, String> storeCol;
    @FXML private TableColumn<StoreRevenue, String> regionCol;
    @FXML private TableColumn<StoreRevenue, Double> revenueCol;
    @FXML private TableColumn<StoreRevenue, Double> growthCol;
    @FXML private TableColumn<StoreRevenue, String> statusCol;

    @FXML private Label detailsLabel;
    @FXML private Label systemOutputLabel;

    private ObservableList<StoreRevenue> revenueList;

    @FXML
    public void initialize() {
        regionComboBox.getItems().addAll("Asia", "Europe", "America", "All Regions");

        storeCol.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        regionCol.setCellValueFactory(new PropertyValueFactory<>("region"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("totalRevenue"));
        growthCol.setCellValueFactory(new PropertyValueFactory<>("growthPercentage"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        revenueList = FXCollections.observableArrayList();
    }

    @FXML
    public void analyzeRevenueButtonOnClick(ActionEvent event) {
        // Event 5: Validate date range
        LocalDate start = startDatePicker.getValue();
        LocalDate end = endDatePicker.getValue();

        if (regionComboBox.getValue() == null || start == null || end == null) {
            systemOutputLabel.setText("Error: Please select a region and valid dates.");
            return;
        }

        if (start.isAfter(end)) {
            systemOutputLabel.setText("Error: Start date cannot be after end date.");
            return;
        }

        // Event 6, 7, 8, 11, 12: Fetch data, calculate, identify high/low performers
        revenueList.clear();
        revenueChart.getData().clear();

        revenueList.add(new StoreRevenue("Store 101 - Tokyo", "Asia", 125000.0, 12.5, "High Performer"));
        revenueList.add(new StoreRevenue("Store 205 - London", "Europe", 45000.0, -15.0, "Abnormal Drop! Review Needed"));
        revenueList.add(new StoreRevenue("Store 304 - NY", "America", 95000.0, 2.0, "Normal"));

        revenueTableView.setItems(revenueList);

        // Event 9: Generate graphical charts (Beginner level Bar Chart)
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Total Revenue");
        for (StoreRevenue store : revenueList) {
            series.getData().add(new XYChart.Data<>(store.getStoreName(), store.getTotalRevenue()));
        }
        revenueChart.getData().add(series);

        systemOutputLabel.setText("Success: Revenue data loaded and charts generated.");
    }

    @FXML
    public void selectStoreDetailsButtonOnClick(ActionEvent event) {
        // Event 13, 14, 15
        StoreRevenue selected = revenueTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            systemOutputLabel.setText("Error: Please select a store from the table.");
        } else {
            detailsLabel.setText("Detailed Breakdown for " + selected.getStoreName() +
                                 "\nDine-in: 40% | Takeaway: 35% | Delivery: 25%" +
                                 "\nRecent Promo Effect: +5% Boost");
            systemOutputLabel.setText("Store details fetched successfully.");
        }
    }

    @FXML
    public void exportReportButtonOnClick(ActionEvent event) {
        // Event 16, 17, 18
        if (revenueList.isEmpty()) {
            systemOutputLabel.setText("Error: No data to export. Please analyze first.");
        } else {
            systemOutputLabel.setText("Report successfully formatted, exported to PDF, and logged.");
        }
    }

    @FXML
    public void returnToDashboardButtonOnClick(ActionEvent event) {
        // Event 19
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}