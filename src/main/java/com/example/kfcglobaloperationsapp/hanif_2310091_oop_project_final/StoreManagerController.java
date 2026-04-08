package com.example.hanif_2310091_oop_project_final;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class StoreManagerController {
    @javafx.fxml.FXML
    private TableView<InventoryItem> inventoryTable;
    @javafx.fxml.FXML
    private DatePicker salesDatePicker;
    @javafx.fxml.FXML
    private TextField physicalCashInput;
    @javafx.fxml.FXML
    private Label salesMessageLabel;
    @javafx.fxml.FXML
    private TextField updateStockInput;
    @javafx.fxml.FXML
    private TextField posSalesInput;
    @javafx.fxml.FXML
    private TextArea requestDetailsInput;
    @javafx.fxml.FXML
    private ComboBox<String> employeeDropdown;
    @javafx.fxml.FXML
    private Label issueMessageLabel;
    @javafx.fxml.FXML
    private TableView<?> issuesTable;
    @javafx.fxml.FXML
    private TableView<?> staffTable;
    @javafx.fxml.FXML
    private TextArea performanceSummaryBox;
    @javafx.fxml.FXML
    private TextField hoursWorkedInput;
    @javafx.fxml.FXML
    private ComboBox<String> issueTypeDropdown;
    @javafx.fxml.FXML
    private Label attendanceMessageLabel;
    @javafx.fxml.FXML
    private DatePicker attendanceDatePicker;
    @javafx.fxml.FXML
    private TextArea issueDescriptionInput;
    @javafx.fxml.FXML
    private ComboBox<String> requestTypeDropdown;
    @javafx.fxml.FXML
    private DatePicker issueDatePicker;
    @javafx.fxml.FXML
    private TableView<?> requestsTable;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem, Integer> colCurrentStock;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem, String> colItemId;
    @javafx.fxml.FXML
    private TableColumn<InventoryItem, String> colItemName;


    @javafx.fxml.FXML
    public void initialize() {
        employeeDropdown.getItems().addAll("Hanif (Cashier)", "Sarah (Cook)", "Mike (Janitor)");
        issueTypeDropdown.getItems().addAll("Customer Complaint", "Positive Feedback", "Equipment Breakdown");
        requestTypeDropdown.getItems().addAll("Extra Budget", "Emergency Restock", "Maintenance Approval");
        performanceSummaryBox.setText("--- WEEKLY STORE SUMMARY ---\n\nTotal Sales: $12,450.00\nActive Staff: 3\nPending Issues: 0\nStatus: Performing above target.");

        colItemId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("id"));
        colItemName.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("name"));
        colCurrentStock.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("stock"));

        javafx.collections.ObservableList<InventoryItem> inventoryData = javafx.collections.FXCollections.observableArrayList(
                new InventoryItem("ITM001", "Espresso Beans (Lbs)", 25),
                new InventoryItem("ITM002", "Whole Milk (Gallons)", 12),
                new InventoryItem("ITM003", "Paper Cups (Sleeves)", 150)
        );

        // 3. Put the data into the table
        inventoryTable.setItems(inventoryData);
    }

    @javafx.fxml.FXML
    public void updateStockButtonOA(ActionEvent actionEvent) {
        try {
            int newQuantity = Integer.parseInt(updateStockInput.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Stock Update");
            alert.setHeaderText(null);
            alert.setContentText("Inventory stock successfully updated to: " + newQuantity);
            alert.showAndWait();

            updateStockInput.clear();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid whole number for the new quantity.");
            alert.showAndWait();
        }
        System.out.println("Update Stock button clicked!");
    }

    @javafx.fxml.FXML
    public void handleSaveSales(ActionEvent actionEvent) {
        try {
            if (salesDatePicker.getValue() == null) {
                salesMessageLabel.setText("Error: Please select a closing date.");
                salesMessageLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            double posSales = Double.parseDouble(posSalesInput.getText());
            double physicalCash = Double.parseDouble(physicalCashInput.getText());

            double difference = physicalCash - posSales;

            if (difference == 0) {
                salesMessageLabel.setText("Success: Registers balance perfectly!");
                salesMessageLabel.setStyle("-fx-text-fill: green;");
            } else if (difference > 0) {

                salesMessageLabel.setText(String.format("Warning: Register is OVER by $%.2f", difference));
                salesMessageLabel.setStyle("-fx-text-fill: orange;");
            } else {
                salesMessageLabel.setText(String.format("Alert: Register is SHORT by $%.2f", Math.abs(difference)));
                salesMessageLabel.setStyle("-fx-text-fill: red;");
            }
        } catch (NumberFormatException e) {
            salesMessageLabel.setText("Error: Please enter valid numbers.");
            salesMessageLabel.setStyle("-fx-text-fill: red;");
        }
        System.out.println("Save Sales button clicked!");
    }

    @javafx.fxml.FXML
    public void LogoutOA(ActionEvent actionEvent) {
        System.out.println("Logout button clicked!");
    }

    @javafx.fxml.FXML
    public void handleSaveAttendanceOA(ActionEvent actionEvent) {
        try {
            if (employeeDropdown.getValue() == null || attendanceDatePicker.getValue() == null) {
                attendanceMessageLabel.setText("Error: Please select an employee and a date.");
                attendanceMessageLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            double hoursWorked = Double.parseDouble(hoursWorkedInput.getText());
            String selectedEmployee = employeeDropdown.getValue();

            attendanceMessageLabel.setText("Success: Logged " + hoursWorked + " hours for " + selectedEmployee + ".");
            attendanceMessageLabel.setStyle("-fx-text-fill: green;");

            hoursWorkedInput.clear();

        } catch (NumberFormatException e) {
            attendanceMessageLabel.setText("Error: Please enter a valid number for hours (e.g., 8.5).");
            attendanceMessageLabel.setStyle("-fx-text-fill: red;");
        }
        System.out.println("Save Attendance button clicked!");

    }

    @javafx.fxml.FXML
    public void handleResolveIssueOA(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Issue Resolved");
        alert.setHeaderText(null);
        alert.setContentText("The selected issue has been officially marked as resolved and removed from the active tracker.");
        alert.showAndWait();

        System.out.println("Resolve Issue button clicked!");
    }

    @javafx.fxml.FXML
    public void handleSubmitIssueOA(ActionEvent actionEvent) {
        if (issueTypeDropdown.getValue() == null || issueDatePicker.getValue() == null || issueDescriptionInput.getText().trim().isEmpty()) {
            issueMessageLabel.setText("Error: Please complete all fields before submitting.");
            issueMessageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        String issueType = issueTypeDropdown.getValue();

        issueMessageLabel.setText("Success: '" + issueType + "' has been logged.");
        issueMessageLabel.setStyle("-fx-text-fill: green;");
        issueDescriptionInput.clear();

        System.out.println("Submit Issue button clicked!");
    }

    @javafx.fxml.FXML
    public void handleViewPerformanceOA(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Staff Performance Report");
        alert.setHeaderText("Performance Data Loaded");
        alert.setContentText("The employee metrics have been successfully retrieved. (This will link to the TableView later!)");
        alert.showAndWait();

        System.out.println("View Performance button clicked!");    }

    @javafx.fxml.FXML
    public void handleSendRequestOA(ActionEvent actionEvent) {
        if (requestTypeDropdown.getValue() == null || requestDetailsInput.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing Information");
            alert.setHeaderText(null);
            alert.setContentText("Please select a request type and provide the justification details.");
            alert.showAndWait();
            return;
        }

        String requestType = requestTypeDropdown.getValue();

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Request Sent");
        successAlert.setHeaderText("Status: Delivered");
        successAlert.setContentText("Your '" + requestType + "' request has been successfully forwarded to the Regional Manager for review.");
        successAlert.showAndWait();

        requestDetailsInput.clear();

        System.out.println("Send Request button clicked!");
    }
}
