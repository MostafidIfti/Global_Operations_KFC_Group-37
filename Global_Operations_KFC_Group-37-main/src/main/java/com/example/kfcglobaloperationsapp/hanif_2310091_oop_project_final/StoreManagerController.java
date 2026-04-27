package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StoreManagerController {
    private final ObservableList<InventoryItem> inventoryList = FXCollections.observableArrayList();
    private final ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private final ObservableList<StoreIssue> issueList = FXCollections.observableArrayList();
    private final ObservableList<StoreRequest> requestList = FXCollections.observableArrayList();
    private final ObservableList<Expense> expenseList = FXCollections.observableArrayList();
    @FXML private ComboBox<String> expenseMonthDropdown;
    @FXML private TextField expenseAmountInput;
    @FXML private TextField updateStockInput;
    @FXML private ComboBox<String> issueTypeDropdown;
    @FXML private TextField posSalesInput;
    @FXML private TextArea responseInputTextArea;
    @FXML private Label attendanceMessageLabel;
    @FXML private TextField expenseCategoryInput;
    @FXML private TextField physicalCashInput;
    @FXML private TextField restockQtyInput;
    @FXML private ComboBox<String> employeeDropdown;
    @FXML private ComboBox<Integer> ratingDropdown;
    @FXML private DatePicker attendanceDatePicker;
    @FXML private DatePicker issueDatePicker;
    @FXML private Label issueMessageLabel;
    @FXML private Label expenseRatioLabel;
    @FXML private Label dailysummary;
    @FXML private Label salesMessageLabel;
    @FXML private TextArea issueDescriptionInput;
    @FXML private ComboBox<String> requestTypeDropdown;
    @FXML private TextArea requestDetailsInput;
    @FXML private Label totalExpenseLabel;
    @FXML private Label requestMessageLabel;
    @FXML private DatePicker salesDatePicker;
    @FXML private Label estimatedCostLabel;
    @FXML private TextField budgetamount;
    @FXML private TableView<Employee> staffTable;
    @FXML private TableColumn<Employee, String> colEmpId;
    @FXML private TableColumn<Employee, String> colEmpName;
    @FXML private TableColumn<Employee, String> colEmpRole;
    @FXML private TableColumn<Employee, String> colEmpStatus;
    @FXML private TableView<InventoryItem> inventoryTable;
    @FXML private TableColumn<InventoryItem, String> colItemId;
    @FXML private TableColumn<InventoryItem, String> colItemName;
    @FXML private TableColumn<InventoryItem, Integer> colCurrentStock;
    @FXML private TableView<InventoryItem> lowStockTable;
    @FXML private TableColumn<InventoryItem, String> colLowStockId;
    @FXML private TableColumn<InventoryItem, String> colLowStockName;
    @FXML private TableColumn<InventoryItem, Integer> colLowStockQty;
    @FXML private TableView<StoreIssue> issuesTable;
    @FXML private TableColumn<StoreIssue, String> colIssueId;
    @FXML private TableColumn<StoreIssue, String> colIssueType;
    @FXML private TableColumn<StoreIssue, String> colIssueDesc;
    @FXML private TableColumn<StoreIssue, String> colIssueStatus;
    @FXML private TableView<StoreRequest> pendingRequestsTable;
    @FXML private TableColumn<StoreRequest, String> colReqId;
    @FXML private TableColumn<StoreRequest, String> colReqType;
    @FXML private TableColumn<StoreRequest, Double> colReqAmount;
    @FXML private TableColumn<StoreRequest, String> colReqStatus;
    @FXML private TableView<Expense> expenseTrackingTable;
    @FXML private TableColumn<Expense, String> colExpenseId;
    @FXML private TableColumn<Expense, String> colExpenseCategory;
    @FXML private TableColumn<Expense, Double> colExpenseAmount;


    @FXML
    public void initialize() {
        loadAllData();
        expenseMonthDropdown.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        ratingDropdown.getItems().addAll(1, 2, 3, 4, 5);
        issueTypeDropdown.getItems().addAll("Customer Complaint", "Facility Issue", "Equipment Breakdown", "Staff Dispute", "Other");
        requestTypeDropdown.getItems().addAll("Budget Request", "Maintenance Approval", "Policy Clarification", "Other");
        employeeDropdown.getItems().addAll("EMP01 - John Doe", "EMP02 - Jane Smith", "EMP03 - Alex Johnson");
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colCurrentStock.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmpRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colEmpStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colIssueId.setCellValueFactory(new PropertyValueFactory<>("issueId"));
        colIssueType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colIssueDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colIssueStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colLowStockId.setCellValueFactory(new PropertyValueFactory<>("itemId")); // Changed from itemName
        colLowStockName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colLowStockQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colReqId.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        colReqType.setCellValueFactory(new PropertyValueFactory<>("requestType"));
        colReqAmount.setCellValueFactory(new PropertyValueFactory<>("budget"));
        colReqStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colExpenseId.setCellValueFactory(new PropertyValueFactory<>("expenseId"));
        colExpenseCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colExpenseAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        inventoryTable.setItems(inventoryList);
        lowStockTable.setItems(inventoryList); // Both tables use the same inventory data!
        staffTable.setItems(employeeList);
        issuesTable.setItems(issueList);
        pendingRequestsTable.setItems(requestList);
        expenseTrackingTable.setItems(expenseList);

        if (inventoryList.isEmpty()) {
            inventoryList.addAll(
                    new InventoryItem("INV-01", "Original Recipe Chicken", 150, 50, "In Stock"),
                    new InventoryItem("INV-02", "Zinger Buns", 80, 20, "In Stock"),
                    new InventoryItem("INV-03", "Frying Oil (Liters)", 45, 15, "In Stock")
            );
        }

        if (employeeList.isEmpty()) {
            employeeList.addAll(
                    new Employee("EMP01", "John Doe", "Cashier", "Pending"),
                    new Employee("EMP02", "Jane Smith", "Cook", "Pending"),
                    new Employee("EMP03", "Alex Johnson", "Shift Supervisor", "Pending")
            );
        }


    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void processAttendance(String status) {
        saveAllData();
        String selectedEmpStr = employeeDropdown.getValue();

        if (attendanceDatePicker.getValue() == null) {
            attendanceMessageLabel.setText("Error: Please select a date first.");
            attendanceMessageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        if (selectedEmpStr == null) {
            attendanceMessageLabel.setText("Error: Select an employee first.");
            attendanceMessageLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        String empId = selectedEmpStr.split(" ")[0];

        for (Employee emp : employeeList) {
            if (emp.getEmpId().equals(empId)) {
                emp.setStatus(status);
                break;
            }
        }
        staffTable.refresh();
        updateDailySummary();

        attendanceMessageLabel.setText(selectedEmpStr + " marked " + status + " on " + attendanceDatePicker.getValue());
        attendanceMessageLabel.setStyle("-fx-text-fill: green;");
    }
    private void updateDailySummary() {
        int present = 0;
        int absent = 0;
        for (Employee emp : employeeList) {
            if ("Present".equals(emp.getStatus())) present++;
            if ("Absent".equals(emp.getStatus())) absent++;
        }
        dailysummary.setText("Daily Summary: " + present + " Present | " + absent + " Absent");
    }


    @FXML public void MarkPresentOA(ActionEvent actionEvent) {
        processAttendance("Present");

    }


    @FXML public void handleSaveAttendanceOA(ActionEvent actionEvent) {
        if (attendanceDatePicker.getValue() == null) {
            attendanceMessageLabel.setText("Error: Please select a date.");
            attendanceMessageLabel.setStyle("-fx-text-fill: red;");
            return;
        }
        showAlert("Success", "Attendance for " + attendanceDatePicker.getValue() + " has been saved globally.");
        employeeDropdown.getSelectionModel().clearSelection();
        attendanceDatePicker.setValue(null);
        attendanceMessageLabel.setText("");

    }


    @FXML public void updateStockButtonOA(ActionEvent actionEvent) {
        InventoryItem selected = inventoryTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Selection Error", "Please select an inventory item from the table first.");
            return;
        }

        try {
            int newQty = Integer.parseInt(updateStockInput.getText());

            if (newQty < 0) {
                showAlert("Input Error", "Quantity cannot be negative. Please enter a valid number.");
                return;
            }

            selected.setQuantity(newQty);
            inventoryTable.refresh();
            lowStockTable.refresh();
            updateStockInput.clear();
            showAlert("Information", "Inventory updated! " + selected.getItemName() + " is now at " + newQty + " units.");

        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid whole number for the stock quantity.");
        }
        saveAllData();
    }


    @FXML public void handleSubmitIssueOA(ActionEvent actionEvent) {
        String type = issueTypeDropdown.getValue();
        String description = issueDescriptionInput.getText();
        java.time.LocalDate date = issueDatePicker.getValue();

        if (type == null || description.trim().isEmpty() || date == null) {
            issueMessageLabel.setText("Error: Please fill out all fields.");
            issueMessageLabel.setStyle("-fx-text-fill: red;");
            return;
        }
        String newIssueId = "ISSUE-" + (issueList.size() + 1);
        StoreIssue newIssue = new StoreIssue(newIssueId, type, description, "Open");
        issueList.add(newIssue);
        issueMessageLabel.setText("Issue logged successfully!");
        issueMessageLabel.setStyle("-fx-text-fill: green;");
        issueTypeDropdown.getSelectionModel().clearSelection();
        issueDescriptionInput.clear();
        issueDatePicker.setValue(null);
        saveAllData();

    }


    @FXML public void handleSaveExpenseOA(ActionEvent actionEvent) {
        String category = expenseCategoryInput.getText();
        String amountStr = expenseAmountInput.getText();

        if (category.isEmpty() || amountStr.isEmpty()) {
            showAlert("Validation Error", "Please enter a category and amount.");
            return;
        }
        try {
            double amount = Double.parseDouble(amountStr);
            Expense e = new Expense("EXP-" + (expenseList.size() + 1), category, amount);
            expenseList.add(e);

            double total = expenseList.stream().mapToDouble(Expense::getAmount).sum();
            totalExpenseLabel.setText("Total Expense: $" + total);
            double targetBudget = 5000.0;
            double ratio = (total / targetBudget) * 100.0;
            expenseRatioLabel.setText(String.format("Expense Ratio: %.1f%%", ratio));
            expenseCategoryInput.clear();
            expenseAmountInput.clear();

        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid number for the amount.");
        }
        saveAllData();
    }


    @FXML public void handleViewPerformanceOA(ActionEvent actionEvent) {
        Employee selected = staffTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Selection Error", "Please select an employee from the table first.");
            return;
        }

        String currentStatus = selected.getStatus();
        String message = "";
        switch (currentStatus) {
            case "Present":
                message = "Employee " + selected.getName() + " is on shift and demonstrating satisfactory performance.";
                break;
            case "Absent":
                message = "Employee " + selected.getName() + " is currently marked Absent. Performance tracking is paused.";
                break;
            case "Pending":
                message = "Employee " + selected.getName() + "'s attendance is Pending. Please log their attendance before reviewing performance.";
                break;
            default:
                message = "Employee " + selected.getName() + " currently has a satisfactory performance record.";
                break;
        }

        showAlert("Performance Record", message);
    }
    @FXML public void handleSaveSales(ActionEvent actionEvent) {
        if (salesDatePicker.getValue() == null) {
            salesMessageLabel.setText("Error: Please select a closing date.");
            salesMessageLabel.setStyle("-fx-text-fill: red;");
            return;
        }


        try {
            double posSales = Double.parseDouble(posSalesInput.getText());
            double physicalCash = Double.parseDouble(physicalCashInput.getText());

            double discrepancy = physicalCash - posSales;

            if (discrepancy == 0) {
                salesMessageLabel.setText("Success: " + salesDatePicker.getValue() + " sales match!");
                salesMessageLabel.setStyle("-fx-text-fill: green;");
            } else {
                salesMessageLabel.setText(salesDatePicker.getValue() + " Discrepancy: $" + discrepancy);
                salesMessageLabel.setStyle("-fx-text-fill: red;");
            }
        } catch (NumberFormatException e) {
            salesMessageLabel.setText("Error: Please enter valid numbers.");
            salesMessageLabel.setStyle("-fx-text-fill: red;");
        }
    }


    @FXML public void MarkAbsentOA(ActionEvent actionEvent) {
        processAttendance("Absent");
    }


    @FXML public void handleSendRequestOA(ActionEvent actionEvent) {
        String type = requestTypeDropdown.getValue();
        String budgetStr = budgetamount.getText();
        if (type == null || budgetStr.isEmpty()) {
            requestMessageLabel.setText("Error: Fill all fields!");
            return;
        }
        try {
            double amount = Double.parseDouble(budgetStr);
            StoreRequest newReq = new StoreRequest(
                    "REQ-" + (requestList.size() + 1), // Auto-ID
                    type, "Main Branch", "2026-04-11", amount, "Pending"
            );
            requestList.add(newReq);
            requestMessageLabel.setText("Request sent successfully!");
            budgetamount.clear();
        } catch (NumberFormatException e) {
            requestMessageLabel.setText("Invalid Amount!");
        }
        saveAllData();
    }


    @FXML public void handleSubmitEvaluationOA(ActionEvent actionEvent) {
        Employee selectedEmployee = staffTable.getSelectionModel().getSelectedItem();
        Integer rating = ratingDropdown.getValue();
        if (selectedEmployee == null) {
            showAlert("Selection Error", "Please select an employee from the roster table.");
            return;
        }
        if (rating == null) {
            showAlert("Input Error", "Please select a rating (1-5) from the dropdown.");
            return;
        }
        showAlert("Evaluation Submitted",
                "Successfully submitted a " + rating + "-star review for " + selectedEmployee.getName() + ".");
        ratingDropdown.getSelectionModel().clearSelection();
    }


    @FXML public void handleResolveIssueOA(ActionEvent actionEvent) {
        StoreIssue selectedIssue = issuesTable.getSelectionModel().getSelectedItem();
        String response = responseInputTextArea.getText();

        if (selectedIssue == null) {
            showAlert("Selection Error", "Please select an issue from the table.");
            return;
        }
        if (response == null || response.trim().isEmpty()) {
            showAlert("Input Error", "Please enter a response before resolving the issue.");
            return;
        }
        selectedIssue.setStatus("Resolved");
        issuesTable.refresh(); // Update the UI
        responseInputTextArea.clear();
        showAlert("Success", "Issue " + selectedIssue.getIssueId() + " has been marked as resolved.");
        saveAllData();
    }


    @FXML public void handleSubmitRestockOA(ActionEvent actionEvent) {
        InventoryItem selectedItem = lowStockTable.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            showAlert("Selection Error", "Please select an item to restock.");
            return;
        }
        try {
            int qtyToRestock = Integer.parseInt(restockQtyInput.getText());
            int updatedQty = selectedItem.getQuantity() + qtyToRestock;
            selectedItem.setQuantity(updatedQty);
            lowStockTable.refresh();
            inventoryTable.refresh();
            restockQtyInput.clear();
            estimatedCostLabel.setText("Estimated Cost: $0.00");
            showAlert("Success", "Stock for " + selectedItem.getItemName() + " has been updated!");
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid number.");
        }
        saveAllData();
    }


    @FXML public void handleCalculateCostOA(ActionEvent actionEvent) {
        InventoryItem selectedItem = lowStockTable.getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            showAlert("Selection Error", "Please select an item from the Low Stock table first.");
            return;
        }
        try {
            int qty = Integer.parseInt(restockQtyInput.getText());
            if (qty <= 0) {
                showAlert("Input Error", "Please enter a quantity greater than zero.");
                return;
            }
            double estimatedCost = qty * 2.50;
            estimatedCostLabel.setText("Estimated Cost: $" + String.format("%.2f", estimatedCost));
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid whole number for the quantity.");
            estimatedCostLabel.setText("Estimated Cost: $0.00");
        }
    }


    @FXML public void LogoutOA(ActionEvent actionEvent) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("Login.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load the login screen.");
        }
    }



    private void saveListToFile(String filename, java.util.ArrayList<?> listToSave) {
        try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream(filename))) {
            oos.writeObject(listToSave);
        } catch (java.io.IOException e) {
            System.out.println("Error saving to " + filename + ": " + e.getMessage());
        }
    }

    private void saveAllData() {
        saveListToFile("inventory.bin", new java.util.ArrayList<>(inventoryList));
        saveListToFile("employees.bin", new java.util.ArrayList<>(employeeList));
        saveListToFile("issues.bin", new java.util.ArrayList<>(issueList));
        saveListToFile("requests.bin", new java.util.ArrayList<>(requestList));
        saveListToFile("expenses.bin", new java.util.ArrayList<>(expenseList));
    }

    private void loadAllData() {
        try {
            java.io.File invFile = new java.io.File("inventory.bin");
            if (invFile.exists()) {
                java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(invFile));
                inventoryList.setAll((java.util.ArrayList<InventoryItem>) ois.readObject());
                ois.close();
            }

            java.io.File empFile = new java.io.File("employees.bin");
            if (empFile.exists()) {
                java.io.ObjectInputStream ois2 = new java.io.ObjectInputStream(new java.io.FileInputStream(empFile));
                employeeList.setAll((java.util.ArrayList<Employee>) ois2.readObject());
                ois2.close();
            }

            java.io.File issueFile = new java.io.File("issues.bin");
            if (issueFile.exists()) {
                java.io.ObjectInputStream ois3 = new java.io.ObjectInputStream(new java.io.FileInputStream(issueFile));
                issueList.setAll((java.util.ArrayList<StoreIssue>) ois3.readObject());
                ois3.close();
            }

            java.io.File reqFile = new java.io.File("requests.bin");
            if (reqFile.exists()) {
                java.io.ObjectInputStream ois4 = new java.io.ObjectInputStream(new java.io.FileInputStream(reqFile));
                requestList.setAll((java.util.ArrayList<StoreRequest>) ois4.readObject());
                ois4.close();
            }

            java.io.File expFile = new java.io.File("expenses.bin");
            if (expFile.exists()) {
                java.io.ObjectInputStream ois5 = new java.io.ObjectInputStream(new java.io.FileInputStream(expFile));
                expenseList.setAll((java.util.ArrayList<Expense>) ois5.readObject());
                ois5.close();
            }
        } catch (Exception e) {
            System.out.println("Files not found or corrupted. Using default dummy data.");
        }


    }


}