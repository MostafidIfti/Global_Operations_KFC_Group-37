package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FinancialReportController {

    @FXML private ComboBox<String> reportTypeComboBox;
    @FXML private ComboBox<String> regionComboBox;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;
    @FXML private TableView<ReportLineItem> reportTableView;
    @FXML private TableColumn<ReportLineItem, String> itemCol;
    @FXML private TableColumn<ReportLineItem, Double> actualCol;
    @FXML private TableColumn<ReportLineItem, Double> budgetCol;
    @FXML private TableColumn<ReportLineItem, Double> varianceCol;
    @FXML private ComboBox<String> exportFormatComboBox;
    @FXML private Label systemStatusLabel;

    private ObservableList<ReportLineItem> reportDataList;

    @FXML
    public void initialize() {
        reportTypeComboBox.getItems().addAll("Profit & Loss", "Balance Sheet", "Cash Flow Statement");
        regionComboBox.getItems().addAll("North America", "Europe", "Asia-Pacific", "Middle East");
        exportFormatComboBox.getItems().addAll("PDF", "Excel", "PowerPoint");

        itemCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        actualCol.setCellValueFactory(new PropertyValueFactory<>("actualAmount"));
        budgetCol.setCellValueFactory(new PropertyValueFactory<>("budgetedAmount"));
        varianceCol.setCellValueFactory(new PropertyValueFactory<>("variancePercentage"));

        reportDataList = FXCollections.observableArrayList();
    }

    private boolean isValid() {
        if (reportTypeComboBox.getValue() == null || regionComboBox.getValue() == null) {
            systemStatusLabel.setText("Please select Report Type and Region.");
            return false;
        }
        if (startDatePicker.getValue() == null || endDatePicker.getValue() == null) {
            systemStatusLabel.setText("Please select Start and End dates.");
            return false;
        }
        if (!endDatePicker.getValue().isAfter(startDatePicker.getValue())) {
            systemStatusLabel.setText("End date must be after Start date.");
            return false;
        }

        int startYear = startDatePicker.getValue().getYear();
        int endYear = endDatePicker.getValue().getYear();
        if ((endYear - startYear) > 5) {
            systemStatusLabel.setText("Date range cannot exceed 5 years.");
            return false;
        }

        return true;
    }

    @FXML
    public void generateReportButtonOnAction(ActionEvent event) {
        if (isValid()) {
            reportDataList.clear();
            reportDataList.add(new ReportLineItem("Q1 Revenue", 450000.0, 400000.0));
            reportDataList.add(new ReportLineItem("Q2 Revenue", 380000.0, 420000.0));
            reportDataList.add(new ReportLineItem("Operational Costs", 150000.0, 160000.0));
            reportTableView.setItems(reportDataList);

            systemStatusLabel.setText("Report generated for " + regionComboBox.getValue());
        }
    }

    @FXML
    public void exportReportButtonOnAction(ActionEvent event) {
        if (exportFormatComboBox.getValue() == null) {
            systemStatusLabel.setText("Select an export format.");
        } else if (reportDataList.isEmpty()) {
            systemStatusLabel.setText("Generate a report first.");
        } else {
            systemStatusLabel.setText("Report exported as " + exportFormatComboBox.getValue());
        }
    }

    @FXML
    public void notifyStakeholdersButtonOnAction(ActionEvent event) {
        if (reportDataList.isEmpty()) {
            systemStatusLabel.setText("No report to send.");
        } else {
            systemStatusLabel.setText("Notification sent to stakeholders.");
        }
    }
}