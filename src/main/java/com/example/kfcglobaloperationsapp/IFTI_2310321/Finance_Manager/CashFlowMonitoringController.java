package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CashFlowMonitoringController {

    @FXML private ComboBox<String> yearComboBox;
    @FXML private ComboBox<String> periodComboBox;
    @FXML private ComboBox<String> regionComboBox;

    @FXML private Label totalInflowLabel;
    @FXML private Label totalOutflowLabel;
    @FXML private Label netCashFlowLabel;
    @FXML private Label liquidityAlertLabel;
    @FXML private Label systemOutputLabel;
    @FXML private TextField notesTextField;

    @FXML private BarChart<String, Number> cashFlowChart;

    @FXML private TableView<CashTransaction> transactionTableView;
    @FXML private TableColumn<CashTransaction, String> idCol;
    @FXML private TableColumn<CashTransaction, String> categoryCol;
    @FXML private TableColumn<CashTransaction, String> dateCol;
    @FXML private TableColumn<CashTransaction, Double> amountCol;
    @FXML private TableColumn<CashTransaction, String> typeCol;

    private ObservableList<CashTransaction> transactionList;

    @FXML
    public void initialize() {
        yearComboBox.getItems().addAll("2023", "2024", "2025");
        periodComboBox.getItems().addAll("Q1", "Q2", "Q3", "Q4");
        regionComboBox.getItems().addAll("Global", "North America", "Asia", "Europe");

        idCol.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        transactionList = FXCollections.observableArrayList();
    }

    @FXML
    public void analyzeCashFlowButtonOnClick(ActionEvent event) {
        // Event 4 & 5: Validate Input Parameters
        if (yearComboBox.getValue() == null || periodComboBox.getValue() == null || regionComboBox.getValue() == null) {
            systemOutputLabel.setText("Error: Please select Fiscal Year, Period, and Region to analyze.");
            return;
        }

        // Event 6 & 7: Retrieve Data
        transactionList.clear();
        transactionList.add(new CashTransaction("TRX-101", "Sales Revenue", "2024-03-01", 500000.0, "Inflow"));
        transactionList.add(new CashTransaction("TRX-102", "Franchise Fees", "2024-03-05", 150000.0, "Inflow"));
        transactionList.add(new CashTransaction("TRX-201", "Supplier Payments", "2024-03-10", 300000.0, "Outflow"));
        transactionList.add(new CashTransaction("TRX-202", "Payroll", "2024-03-15", 250000.0, "Outflow"));
        transactionList.add(new CashTransaction("TRX-203", "Marketing", "2024-03-20", 120000.0, "Outflow")); // Abnormal spike!

        transactionTableView.setItems(transactionList);

        // Event 8, 9, 10, 11: Process and Calculate Inflows/Outflows
        double totalInflow = 0.0;
        double totalOutflow = 0.0;

        for (CashTransaction t : transactionList) {
            if (t.getType().equals("Inflow")) {
                totalInflow += t.getAmount();
            } else {
                totalOutflow += t.getAmount();
            }
        }

        double netCashFlow = totalInflow - totalOutflow;

        totalInflowLabel.setText("Total Inflow: $" + totalInflow);
        totalOutflowLabel.setText("Total Outflow: $" + totalOutflow);
        netCashFlowLabel.setText("Net Cash Flow: $" + netCashFlow);

        // Event 12, 13, 14: Liquidity Alert Threshold Check
        double safetyThreshold = 0.0; // If Net Cash drops below 0, it's a risk!
        if (netCashFlow < safetyThreshold) {
            liquidityAlertLabel.setText("RISK ALERT: Net Cash Flow is negative! Immediate review required.");
            liquidityAlertLabel.setStyle("-fx-text-fill: red;");
        } else {
            liquidityAlertLabel.setText("Liquidity Status: Stable.");
            liquidityAlertLabel.setStyle("-fx-text-fill: green;");
        }

        // Event 15: Generate Charts
        cashFlowChart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Cash Movement");
        series.getData().add(new XYChart.Data<>("Inflows", totalInflow));
        series.getData().add(new XYChart.Data<>("Outflows", totalOutflow));
        cashFlowChart.getData().add(series);

        systemOutputLabel.setText("Analysis complete. Check abnormal spike in Marketing expenses.");
    }

    @FXML
    public void saveNotesButtonOnClick(ActionEvent event) {
        // Event 20, 21, 22
        if (notesTextField.getText().isEmpty()) {
            systemOutputLabel.setText("Validation Error: Notes cannot be empty.");
        } else {
            systemOutputLabel.setText("Success: Notes saved to cash flow report.");
            notesTextField.clear();
        }
    }

    @FXML
    public void exportReportButtonOnClick(ActionEvent event) {
        // Event 23, 24
        if (transactionList.isEmpty()) {
            systemOutputLabel.setText("Error: Run analysis before exporting.");
        } else {
            systemOutputLabel.setText("Report downloaded successfully in PDF and Excel formats.");
        }
    }

    @FXML
    public void returnToDashboardButtonOnClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}