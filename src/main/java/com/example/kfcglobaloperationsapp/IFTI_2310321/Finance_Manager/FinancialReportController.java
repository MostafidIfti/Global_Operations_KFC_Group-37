package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
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
    @FXML private LineChart<String, Number> trendChart;
    @FXML private PieChart expensePieChart;
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
        return true;
    }

    @FXML
    public void generateReportButtonOnAction(ActionEvent event) {
        if (isValid()) {
            reportDataList.clear();
            reportDataList.add(new ReportLineItem("Q1 Revenue", 450000.0, 400000.0));
            reportDataList.add(new ReportLineItem("Q2 Revenue", 380000.0, 420000.0));
            reportTableView.setItems(reportDataList);

            trendChart.getData().clear();
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.getData().add(new XYChart.Data<>("Jan", 120000));
            series.getData().add(new XYChart.Data<>("Feb", 145000));
            trendChart.getData().add(series);

            systemStatusLabel.setText("Report generated for " + regionComboBox.getValue());
        }
    }

    @FXML
    public void exportReportButtonOnAction(ActionEvent event) {
        if (exportFormatComboBox.getValue() != null) {
            systemStatusLabel.setText("Report exported as " + exportFormatComboBox.getValue());
        }
    }

    @FXML
    public void notifyStakeholdersButtonOnAction(ActionEvent event) {
        systemStatusLabel.setText("Notification sent to stakeholders.");
    }
}