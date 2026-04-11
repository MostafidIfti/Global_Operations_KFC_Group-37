package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BudgetManagementController {

    @FXML private ComboBox<String> fiscalYearComboBox;
    @FXML private ComboBox<String> regionComboBox;
    @FXML private ComboBox<String> departmentComboBox;
    @FXML private TextField amountTextField;

    @FXML private TableView<Budget> budgetTableView;
    @FXML private TableColumn<Budget, String> deptCol;
    @FXML private TableColumn<Budget, String> regionCol;
    @FXML private TableColumn<Budget, Double> amountCol;
    @FXML private TableColumn<Budget, String> statusCol;

    @FXML private Label systemOutputLabel;
    @FXML private Label corporateTotalLabel;

    private ObservableList<Budget> budgetList;
    private double corporateMasterBudget = 5000000.0; // 5 Million limit

    @FXML
    public void initialize() {
        // Setup Combo Boxes
        fiscalYearComboBox.getItems().addAll("2025", "2026", "2027");
        regionComboBox.getItems().addAll("Asia", "Europe", "America");
        departmentComboBox.getItems().addAll("Operations", "Supply Chain", "Marketing");

        // Setup Table Columns
        deptCol.setCellValueFactory(new PropertyValueFactory<>("department"));
        regionCol.setCellValueFactory(new PropertyValueFactory<>("region"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("allocatedAmount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        budgetList = FXCollections.observableArrayList();

        // Load initial dummy data (Event 3)
        budgetList.add(new Budget("Marketing", "Asia", 150000.0, "Approved"));
        budgetList.add(new Budget("Operations", "America", 800000.0, "Approved"));
        budgetTableView.setItems(budgetList);

        updateCorporateTotal();
    }

    private void updateCorporateTotal() {
        double totalUsed = 0;
        for (int i = 0; i < budgetList.size(); i++) {
            totalUsed += budgetList.get(i).getAllocatedAmount();
        }
        corporateTotalLabel.setText("Total Allocated: $" + totalUsed + " / $" + corporateMasterBudget);
    }

    @FXML
    public void saveBudgetButtonOnClick(ActionEvent event) {
        // Validation (Event 5, 10, 11)
        if (fiscalYearComboBox.getValue() == null || regionComboBox.getValue() == null || departmentComboBox.getValue() == null) {
            systemOutputLabel.setText("Error: Please select Year, Region, and Department.");
            return;
        }

        try {
            double newAmount = Double.parseDouble(amountTextField.getText());

            if (newAmount <= 0) {
                systemOutputLabel.setText("Error: Budget amount must be a positive number.");
                return;
            }

            // Calculate total if we add this new amount
            double currentTotal = 0;
            for (int i = 0; i < budgetList.size(); i++) {
                currentTotal += budgetList.get(i).getAllocatedAmount();
            }

            if ((currentTotal + newAmount) > corporateMasterBudget) {
                systemOutputLabel.setText("Error: Exceeds Corporate Master Budget Limit!");
                return;
            }

            // Event 15, 16, 17: Save, update table, success message
            budgetList.add(new Budget(departmentComboBox.getValue(), regionComboBox.getValue(), newAmount, "Newly Allocated"));
            budgetTableView.refresh();
            updateCorporateTotal();

            systemOutputLabel.setText("Success: Budget allocation updated successfully. Log generated.");
            amountTextField.clear();

        } catch (NumberFormatException e) {
            systemOutputLabel.setText("Error: Please enter a valid number for amount.");
        }
    }

    @FXML
    public void exportReportButtonOnClick(ActionEvent event) {
        // Event 18
        if (budgetList.isEmpty()) {
            systemOutputLabel.setText("No data to export.");
        } else {
            systemOutputLabel.setText("Budget report exported as PDF.");
        }
    }

    @FXML
    public void notifyDepartmentButtonOnClick(ActionEvent event) {
        // Event 19
        if (departmentComboBox.getValue() == null) {
            systemOutputLabel.setText("Please select a department to notify.");
        } else {
            systemOutputLabel.setText("Notification sent to " + departmentComboBox.getValue() + " department.");
        }
    }

    @FXML
    public void returnToDashboardButtonOnClick(ActionEvent event) {
        // Event 20: Just close this screen since Master Menu is the main hub
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}