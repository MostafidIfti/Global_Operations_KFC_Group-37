package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExpenseManagementController {

    // Event 4: Expense Table
    @FXML private TableView<FM_Expense> expenseTable;
    @FXML private TableColumn<FM_Expense, String> idCol;
    @FXML private TableColumn<FM_Expense, String> deptCol;
    @FXML private TableColumn<FM_Expense, String> catCol;
    @FXML private TableColumn<FM_Expense, Double> amountCol;
    @FXML private TableColumn<FM_Expense, String> statusCol;

    // Events 6, 7, 8, 9: Review Panel
    @FXML private Label detailsLabel;
    @FXML private Label documentLabel;
    @FXML private Label warningLabel;

    // Events 10, 11: Action Panel
    @FXML private TextArea remarksArea;
    @FXML private Label systemStatusLabel;

    private FM_Expense selectedExpense;

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("expenseId"));
        deptCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        catCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Event-3: Fetch Records
        ObservableList<FM_Expense> data = FXCollections.observableArrayList(
            new FM_Expense("EXP-101", "Marketing", "Travel", 1200.50, "Pending review", true, true),
            new FM_Expense("EXP-102", "Operations", "Equipment", 4500.00, "Pending review", true, false), // Over budget
            new FM_Expense("EXP-103", "Supply Chain", "Logistics", 300.00, "Pending review", false, true)  // Missing receipt
        );
        expenseTable.setItems(data);

        // Event-5 & 6: Listen for selection
        expenseTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                selectedExpense = newVal;
                loadExpenseDetails();
            }
        });
    }

    private void loadExpenseDetails() {
        detailsLabel.setText(String.format("Reviewing %s: $%,.2f for %s",
                selectedExpense.getExpenseId(), selectedExpense.getAmount(), selectedExpense.getCategory()));

        // Event-7: Check Documents
        documentLabel.setText(selectedExpense.isReceiptAttached() ? "Documents: Valid Receipts Attached" : "Documents: MISSING RECEIPTS");
        documentLabel.setStyle(selectedExpense.isReceiptAttached() ? "-fx-text-fill: green;" : "-fx-text-fill: red; -fx-font-weight: bold;");

        // Event-8 & 9: Check Budget Compliance
        if (!selectedExpense.isWithinBudget()) {
            warningLabel.setText("WARNING: Expense exceeds allocated departmental budget!");
            warningLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold; -fx-background-color: #ffe6e6; -fx-padding: 5;");
        } else {
            warningLabel.setText("Compliance: Within allocated budget constraints.");
            warningLabel.setStyle("-fx-text-fill: green; -fx-background-color: transparent; -fx-padding: 0;");
        }
    }

    @FXML
    void handleAction(ActionEvent event) {
        if (selectedExpense == null) {
            systemStatusLabel.setText("Error: Please select an expense record first.");
            return;
        }

        Button btn = (Button) event.getSource();
        String action = btn.getText();
        String remarks = remarksArea.getText().trim();

        // Event-12: Validate remarks for Rejection
        if (action.contains("Reject") && remarks.isEmpty()) {
            systemStatusLabel.setText("Validation Error: Remarks are MANDATORY when rejecting an expense.");
            systemStatusLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        // Events 13, 14, 15, 16: Update & Log
        if (action.contains("Approve")) {
            selectedExpense.setStatus("Approved");
            systemStatusLabel.setText("Success: Approved. Department ledgers updated & manager notified.");
            systemStatusLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        } else if (action.contains("Reject")) {
            selectedExpense.setStatus("Rejected");
            systemStatusLabel.setText("Success: Rejected. Remarks sent to manager. Logged for audit.");
            systemStatusLabel.setStyle("-fx-text-fill: #dc3545; -fx-font-weight: bold;");
        } else {
            selectedExpense.setStatus("Clarification Req");
            systemStatusLabel.setText("Success: Sent back to department for clarification.");
            systemStatusLabel.setStyle("-fx-text-fill: #ffc107; -fx-font-weight: bold;");
        }

        expenseTable.refresh();
        remarksArea.clear();
    }
}