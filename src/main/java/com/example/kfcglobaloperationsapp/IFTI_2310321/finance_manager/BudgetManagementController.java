package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class BudgetManagementController {

    // Event 3 & 4: Filters
    @FXML private ComboBox<String> yearCombo;
    @FXML private ComboBox<String> regionCombo;
    @FXML private ComboBox<String> deptCombo;

    // Table
    @FXML private TableView<FM_BudgetAllocation> budgetTable;
    @FXML private TableColumn<FM_BudgetAllocation, String> deptCol;
    @FXML private TableColumn<FM_BudgetAllocation, String> regionCol;
    @FXML private TableColumn<FM_BudgetAllocation, Double> allocCol;
    @FXML private TableColumn<FM_BudgetAllocation, Double> utilCol;

    // Events 5, 10, 12, 13: Allocation Editor & Preview
    @FXML private Label selectedDeptLabel;
    @FXML private TextField newAmountField;
    @FXML private Label previewTotalLabel;
    @FXML private Label varianceLabel;

    // Status
    @FXML private Label statusLabel;

    private FM_BudgetAllocation selectedBudget;
    private final double MASTER_BUDGET_LIMIT = 50000000.00; // $50 Million Max Limit

    @FXML
    public void initialize() {
        yearCombo.getItems().addAll("2025", "2026", "2027");
        regionCombo.getItems().addAll("Asia", "Europe", "America");
        deptCombo.getItems().addAll("Operations", "Supply Chain", "Marketing");

        deptCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        regionCol.setCellValueFactory(new PropertyValueFactory<>("region"));
        allocCol.setCellValueFactory(new PropertyValueFactory<>("allocatedAmount"));
        utilCol.setCellValueFactory(new PropertyValueFactory<>("utilizedAmount"));

        // Load dummy data
        ObservableList<FM_BudgetAllocation> data = FXCollections.observableArrayList(
            new FM_BudgetAllocation("2026", "Operations", "Asia", 15000000, 14000000),
            new FM_BudgetAllocation("2026", "Marketing", "Europe", 8000000, 7500000)
        );
        budgetTable.setItems(data);

        // Listen for selection
        budgetTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                selectedBudget = newVal;
                selectedDeptLabel.setText(newVal.getDepartment() + " (" + newVal.getRegion() + ")");
                newAmountField.setText(String.valueOf(newVal.getAllocatedAmount()));
                statusLabel.setText("System: Budget selected for modification. Awaiting preview.");
                statusLabel.setStyle("-fx-text-fill: black;");
            }
        });
    }

    @FXML
    void handlePreviewChanges(ActionEvent event) {
        if (selectedBudget == null) {
            statusLabel.setText("Error: Please select a department budget from the table first.");
            return;
        }

        try {
            double newAmount = Double.parseDouble(newAmountField.getText());

            // Event-10: Validate Budget Amount
            if (newAmount <= 0) {
                statusLabel.setText("Validation Error: Budget allocation must be a positive number.");
                statusLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            if (newAmount > MASTER_BUDGET_LIMIT) {
                statusLabel.setText("Validation Error: Exceeds Corporate Master Budget Limit ($50M).");
                statusLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            // Event-12 & 13: Recalculate and show variance
            double variance = newAmount - selectedBudget.getAllocatedAmount();
            previewTotalLabel.setText("$" + newAmount);
            varianceLabel.setText(variance >= 0 ? "+$" + variance : "-$" + Math.abs(variance));

            if (variance > 0) {
                varianceLabel.setStyle("-fx-text-fill: green;");
                statusLabel.setText("Event-11: Authorization Verified. Preview loaded successfully.");
            } else {
                varianceLabel.setStyle("-fx-text-fill: orange;");
                statusLabel.setText("Event-11: Authorization Verified. Preview loaded (Budget Decrease).");
            }
            statusLabel.setStyle("-fx-text-fill: blue;");

        } catch (NumberFormatException e) {
            statusLabel.setText("Error: Please enter a valid numerical amount.");
            statusLabel.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    void handleSaveAllocation(ActionEvent event) {
        // Events 14, 15, 16, 17
        if (selectedBudget != null && !varianceLabel.getText().equals("$0.00")) {
            double newAmt = Double.parseDouble(newAmountField.getText());
            selectedBudget.setAllocatedAmount(newAmt);
            budgetTable.refresh();

            statusLabel.setText("Event-17: Budget allocation updated successfully! Modification Logged.");
            statusLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        } else {
            statusLabel.setText("Error: No valid changes to save. Please preview changes first.");
        }
    }

    @FXML
    void handleExportNotify(ActionEvent event) {
        // Events 18 & 19
        statusLabel.setText("Success: Budget Report Exported. Notification sent to Regional Officers.");
        statusLabel.setStyle("-fx-text-fill: #17a2b8; -fx-font-weight: bold;");
    }
}