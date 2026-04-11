package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ExpenseManagementController {

    @FXML private TableView<Expense> expenseTableView;
    @FXML private TableColumn<Expense, String> idCol;
    @FXML private TableColumn<Expense, String> deptCol;
    @FXML private TableColumn<Expense, String> categoryCol;
    @FXML private TableColumn<Expense, Double> amountCol;
    @FXML private TableColumn<Expense, String> statusCol;

    @FXML private Label detailsLabel;
    @FXML private Label warningLabel;
    @FXML private Label systemOutputLabel;
    @FXML private TextField remarksTextField;

    private ObservableList<Expense> expenseList;
    private Expense selectedExpense;

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("expenseId"));
        deptCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        expenseList = FXCollections.observableArrayList();

        // Event 3: Fetch expense records
        expenseList.add(new Expense("EXP-001", "Supply Chain", "Logistics", 4500.0, "Pending Review"));
        expenseList.add(new Expense("EXP-002", "Marketing", "Advertising", 15000.0, "Pending Review")); // High amount to trigger warning
        expenseList.add(new Expense("EXP-003", "Operations", "Maintenance", 1200.0, "Pending Review"));

        expenseTableView.setItems(expenseList);
    }

    @FXML
    public void viewDetailsButtonOnClick(ActionEvent event) {
        selectedExpense = expenseTableView.getSelectionModel().getSelectedItem();

        if (selectedExpense == null) {
            systemOutputLabel.setText("Error: Please select an expense from the table first.");
            return;
        }

        // Event 6: Load details and simulate receipt
        detailsLabel.setText("Receipt attached: Scanned_Invoice_" + selectedExpense.getExpenseId() + ".pdf");

        // Event 8 & 9: Budget discrepancy warning simulation
        if (selectedExpense.getAmount() > 10000) {
            warningLabel.setText("WARNING: This expense exceeds the standard departmental limit!");
        } else {
            warningLabel.setText("Budget Check: Within acceptable limits.");
        }

        systemOutputLabel.setText("Viewing details for " + selectedExpense.getExpenseId());
    }

    @FXML
    public void approveButtonOnClick(ActionEvent event) {
        if (selectedExpense == null) return;

        // Event 13, 14, 15, 16
        selectedExpense.setStatus("Approved");
        expenseTableView.refresh();
        systemOutputLabel.setText("Success: Expense Approved. Department Notified. Log generated.");
        clearSelection();
    }

    @FXML
    public void rejectButtonOnClick(ActionEvent event) {
        if (selectedExpense == null) return;

        // Event 12: Validate remarks for rejection
        if (remarksTextField.getText().isEmpty()) {
            systemOutputLabel.setText("Error: You MUST enter a remark to justify a Rejection.");
            return;
        }

        selectedExpense.setStatus("Rejected");
        expenseTableView.refresh();
        systemOutputLabel.setText("Expense Rejected. Reason logged: " + remarksTextField.getText());
        clearSelection();
    }

    @FXML
    public void requestClarificationButtonOnClick(ActionEvent event) {
        if (selectedExpense == null) return;

        selectedExpense.setStatus("Needs Clarification");
        expenseTableView.refresh();
        systemOutputLabel.setText("Status updated. Notification sent to department asking for clarification.");
        clearSelection();
    }

    private void clearSelection() {
        remarksTextField.clear();
        warningLabel.setText("");
        detailsLabel.setText("No expense selected...");
        selectedExpense = null;
    }

    @FXML
    public void returnToDashboardButtonOnClick(ActionEvent event) {
        // Event 17
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}