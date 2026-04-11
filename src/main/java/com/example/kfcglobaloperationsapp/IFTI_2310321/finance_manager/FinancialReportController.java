package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FinancialReportController {


    @FXML private ComboBox<String> reportTypeCombo;
    @FXML private ComboBox<String> timePeriodCombo;
    @FXML private ComboBox<String> regionCombo;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;


    @FXML private TableView<FM_FinancialReportItem> reportTable;
    @FXML private TableColumn<FM_FinancialReportItem, String> metricCol;
    @FXML private TableColumn<FM_FinancialReportItem, Double> actualCol;
    @FXML private TableColumn<FM_FinancialReportItem, Double> budgetCol;
    @FXML private TableColumn<FM_FinancialReportItem, Double> varianceCol;


    @FXML private PieChart visualChart;
    @FXML private ComboBox<String> exportFormatCombo;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {

        reportTypeCombo.getItems().addAll("Profit & Loss Statement", "Balance Sheet", "Cash Flow Statement", "Revenue Report", "Expense Report", "Store-wise Performance");
        // Event-5: Time period and Region
        timePeriodCombo.getItems().addAll("Daily", "Weekly", "Monthly", "Quarterly", "Yearly");
        regionCombo.getItems().addAll("North America", "Europe", "Asia-Pacific", "Middle East");
        // Event-16: Export formats
        exportFormatCombo.getItems().addAll("PDF", "Excel", "PowerPoint");

        metricCol.setCellValueFactory(new PropertyValueFactory<>("metricName"));
        actualCol.setCellValueFactory(new PropertyValueFactory<>("actualAmount"));
        budgetCol.setCellValueFactory(new PropertyValueFactory<>("budgetedAmount"));
        varianceCol.setCellValueFactory(new PropertyValueFactory<>("variancePercent"));
    }

    @FXML
    void handleGenerateReport(ActionEvent event) {
        LocalDate start = startDatePicker.getValue();
        LocalDate end = endDatePicker.getValue();


        if (start == null || end == null || reportTypeCombo.getValue() == null) {
            statusLabel.setText("Validation Error: Please select Report Type and Dates.");
            statusLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }
        if (end.isBefore(start)) {
            statusLabel.setText("Validation Error: End date must be AFTER Start date.");
            statusLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }
        long yearsBetween = ChronoUnit.YEARS.between(start, end);
        if (yearsBetween > 5) {
            statusLabel.setText("Validation Error: Date range cannot exceed 5 years.");
            statusLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }


        ObservableList<FM_FinancialReportItem> data = FXCollections.observableArrayList(
            new FM_FinancialReportItem("Gross Revenue", 1250000, 1200000),
            new FM_FinancialReportItem("Operating Expenses", 850000, 800000),
            new FM_FinancialReportItem("Net Profit", 400000, 400000)
        );
        reportTable.setItems(data);


        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
            new PieChart.Data("Marketing", 250000),
            new PieChart.Data("Payroll", 450000),
            new PieChart.Data("Logistics", 150000)
        );
        visualChart.setData(pieData);
        visualChart.setTitle("Expense Breakdown");

        statusLabel.setText("System: Report Generated Successfully.");
        statusLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
    }


    @FXML
    void handleExportReport(ActionEvent event) {
        String format = exportFormatCombo.getValue();
        if (format == null) {
            statusLabel.setText("Export Error: Please select an export format first.");
            statusLabel.setStyle("-fx-text-fill: orange; -fx-font-weight: bold;");
            return;
        }
        statusLabel.setText("Report successfully exported as " + format + " with corporate branding.");
        statusLabel.setStyle("-fx-text-fill: blue; -fx-font-weight: bold;");
    }


    @FXML
    void handleSaveAndNotify(ActionEvent event) {
        statusLabel.setText("Success: Report saved to repository. Email notification sent to CFO & CEO.");
        statusLabel.setStyle("-fx-text-fill: #007bff; -fx-font-weight: bold;");
    }
}