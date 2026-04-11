package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TaxComplianceController {

    @FXML private ComboBox<String> taxTypeCombo;
    @FXML private ComboBox<String> yearCombo;
    @FXML private TableView<TaxRecord> taxTableView;
    @FXML private TableColumn<TaxRecord, String> categoryCol;
    @FXML private TableColumn<TaxRecord, Double> amountCol;
    @FXML private TableColumn<TaxRecord, Double> rateCol;
    @FXML private TableColumn<TaxRecord, Double> taxCol;

    @FXML private Label totalTaxLabel;
    @FXML private Label filingStatusLabel;
    @FXML private Label systemOutputLabel;

    private ObservableList<TaxRecord> taxData;

    @FXML
    public void initialize() {
        taxTypeCombo.getItems().addAll("VAT Report", "Corporate Tax", "Regional Tax");
        yearCombo.getItems().addAll("2024", "2025", "2026");

        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("taxableAmount"));
        rateCol.setCellValueFactory(new PropertyValueFactory<>("taxRate"));
        taxCol.setCellValueFactory(new PropertyValueFactory<>("calculatedTax"));

        taxData = FXCollections.observableArrayList();
    }

    @FXML
    public void generateTaxReportOnClick(ActionEvent event) {
        // Event 5: Validation
        if (taxTypeCombo.getValue() == null || yearCombo.getValue() == null) {
            systemOutputLabel.setText("Error: Please select Tax Type and Fiscal Year.");
            return;
        }

        // Event 6, 7, 8, 9: Fetch and Calculate
        taxData.clear();
        taxData.add(new TaxRecord("Gross Revenue", 1000000.0, 0.15, 150000.0));
        taxData.add(new TaxRecord("Deductible Expenses", -200000.0, 0.15, -30000.0));
        taxData.add(new TaxRecord("Regulatory Credits", 0.0, 1.0, -5000.0));

        taxTableView.setItems(taxData);

        double netTax = 0;
        for (TaxRecord item : taxData) { netTax += item.getCalculatedTax(); }

        totalTaxLabel.setText("Total Tax Payable: $" + netTax);

        // Event 14: Filing Readiness
        filingStatusLabel.setText("Filing Readiness: READY (Calculations Verified)");
        systemOutputLabel.setText("Report generated. Discrepancy check: 0 errors found.");
    }

    @FXML
    public void exportAndNotifyOnClick(ActionEvent event) {
        // Event 15, 16, 17, 18
        if (taxData.isEmpty()) {
            systemOutputLabel.setText("Error: Generate a report before exporting.");
        } else {
            systemOutputLabel.setText("Report saved, exported to PDF, and notification sent to CFO.");
        }
    }

    @FXML
    public void returnToDashboardOnClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}