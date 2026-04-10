package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class FinancialReportController {

    @FXML private ComboBox<String> reportTypeComboBox;
    @FXML private ComboBox<String> periodComboBox;
    @FXML private ComboBox<String> regionComboBox;
    @FXML private TableView<FM_FinancialReport> reportTableView;
    @FXML private TableColumn<FM_FinancialReport, String> idCol;
    @FXML private TableColumn<FM_FinancialReport, String> typeCol;
    @FXML private TableColumn<FM_FinancialReport, String> regionCol;
    @FXML private TableColumn<FM_FinancialReport, String> periodCol;
    @FXML private TableColumn<FM_FinancialReport, Double> amountCol;

    private ObservableList<FM_FinancialReport> reportList = FXCollections.observableArrayList();
    private int reportCounter = 100;

    @FXML
    public void initialize() {
        reportTypeComboBox.getItems().addAll("Profit & Loss", "Balance Sheet", "Revenue Report", "Expense Report");
        periodComboBox.getItems().addAll("Weekly", "Monthly", "Quarterly", "Yearly");
        regionComboBox.getItems().addAll("Asia", "Europe", "America", "Middle East");

        idCol.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        regionCol.setCellValueFactory(new PropertyValueFactory<>("region"));
        periodCol.setCellValueFactory(new PropertyValueFactory<>("period"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
    }

    @FXML
    void handleGenerateReport(ActionEvent event) {
        String type = reportTypeComboBox.getValue();
        String period = periodComboBox.getValue();
        String region = regionComboBox.getValue();

        if (type == null || period == null || region == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select all parameters.");
            alert.showAndWait();
            return;
        }

        // Simulate fetching data based on selection
        double simulatedAmount = Math.random() * 500000 + 100000;
        String reportId = "REP-" + reportCounter++;
        reportList.add(new FM_FinancialReport(reportId, type, region, period, Math.round(simulatedAmount * 100.0) / 100.0));
        reportTableView.setItems(reportList);
    }
}