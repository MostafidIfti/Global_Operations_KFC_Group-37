package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegionalManagerController {
    // --- 1. Data Lists (Defined ONLY once) ---
    private final ObservableList<InventoryItem> inventoryList = FXCollections.observableArrayList();
    private final ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private final ObservableList<StoreIssue> issueList = FXCollections.observableArrayList();
    private final ObservableList<Expense> expenseList = FXCollections.observableArrayList();

    // --- 2. Table Views (Matching your FXML IDs) ---
    @FXML private TableView<InventoryItem> inventoryTable;
    @FXML private TableView<StoreRequest> requestsTable;
    @FXML private TableView<Incident> incidentTable;
    @FXML private TableView<FinancialRecord> financialTable;
    @FXML private TableView<StoreRanking> rankingTable;
    @FXML private TableView<ComplianceRecord> complianceTable;


    // --- 3. UI Components ---
    @FXML private ComboBox<String> inventoryStoreCombo;
    @FXML private ComboBox<String> incidentStatusCombo;
    @FXML private ComboBox<String> rankingPeriodCombo;
    @FXML private Label lblLowStock;
    @FXML private Label lblTotalItems;
    @FXML private Label lblNetProfitAndMargin;
    @FXML private Label lblTotalExpenses;
    @FXML private Label lblAvgRevenue;
    @FXML private Label lblTotalRevenue;
    @FXML private Label reachRateLabel;
    @FXML private Label requestMessageLabel;
    @FXML private TextField announcementTitleInput;
    @FXML private TextArea announcementMessageInput;
    @FXML private TextArea requestDetailArea;
    @FXML private DatePicker reportStartDate;
    @FXML private DatePicker reportEndDate;
    @FXML private DatePicker startdatepicker;
    @FXML private DatePicker enddatepicker;

    // --- 4. Table Columns ---
    @FXML private TableColumn<InventoryItem, String> colInvItem;
    @FXML private TableColumn<InventoryItem, Integer> colInvQuantity;
    @FXML private TableColumn<InventoryItem, Integer> colInvThreshold;
    @FXML private TableColumn<InventoryItem, String> colInvStatus;
    @FXML private TableColumn<FinancialRecord, String> colStoreId;
    @FXML private TableColumn<FinancialRecord, Double> colTotalSales;
    @FXML private TableColumn<FinancialRecord, Double> colExpenses;
    @FXML private TableColumn<FinancialRecord, Double> colProfit;
    @FXML private TableColumn<FinancialRecord, Double> colMargin;
    @FXML private TableColumn<StoreRanking, Integer> colstorerank;
    @FXML private TableColumn<StoreRanking, String> colStoreNameRanking;
    @FXML private TableColumn<StoreRanking, Double> colRevenue;
    @FXML private TableColumn<StoreRequest, String> colReqStoreName;
    @FXML private TableColumn<StoreRequest, String> colReqSubmissionDate;
    @FXML private TableColumn<StoreRequest, Double> colReqBudget;
    @FXML private TableColumn<StoreRequest, String> colReqStatus;
    @FXML private TableColumn<Incident, String> colIncStore;
    @FXML private TableColumn<Incident, String> colIncSeverity;
    @FXML private TableColumn<Incident, String> colIncStatus;
    @FXML private TableColumn<ComplianceRecord, String> colCompStoreName;
    @FXML private TableColumn<ComplianceRecord, Double> colCompScore;
    @FXML private TableColumn<ComplianceRecord, String> colCompStatus;

    public Label getLblLowStock() {
        return lblLowStock;
    }

    public ComboBox<String> getInventoryStoreCombo() {
        return inventoryStoreCombo;
    }

    public Label getLblNetProfitAndMargin() {
        return lblNetProfitAndMargin;
    }

    public TableView<FinancialRecord> getFinancialTable() {
        return financialTable;
    }

    public Label getReachRateLabel() {
        return reachRateLabel;
    }

    public Label getLblAvgRevenue() {
        return lblAvgRevenue;
    }

    public Label getLblTotalExpenses() {
        return lblTotalExpenses;
    }

    public ComboBox<String> getIncidentStatusCombo() {
        return incidentStatusCombo;
    }

    public TableView<StoreRequest> getRequestsTable() {
        return requestsTable;
    }

    public DatePicker getStartdatepicker() {
        return startdatepicker;
    }

    public ComboBox<String> getRankingPeriodCombo() {
        return rankingPeriodCombo;
    }

    public TextArea getRequestDetailArea() {
        return requestDetailArea;
    }

    public Label getLblTotalItems() {
        return lblTotalItems;
    }

    public Label getLblTotalRevenue() {
        return lblTotalRevenue;
    }

    public DatePicker getReportEndDate() {
        return reportEndDate;
    }

    public TableView<InventoryItem> getInventoryTable() {
        return inventoryTable;
    }

    public DatePicker getReportStartDate() {
        return reportStartDate;
    }

    public TableView<ComplianceRecord> getComplianceTable() {
        return complianceTable;
    }

    public DatePicker getEnddatepicker() {
        return enddatepicker;
    }

    public TableView<StoreRanking> getRankingTable() {
        return rankingTable;
    }

    public TableView<Incident> getIncidentTable() {
        return incidentTable;
    }

    public void setInventoryStoreCombo(ComboBox<String> inventoryStoreCombo) {
        this.inventoryStoreCombo = inventoryStoreCombo;
    }

    public void setLblLowStock(Label lblLowStock) {
        this.lblLowStock = lblLowStock;
    }

    public void setLblNetProfitAndMargin(Label lblNetProfitAndMargin) {
        this.lblNetProfitAndMargin = lblNetProfitAndMargin;
    }

    public void setFinancialTable(TableView<FinancialRecord> financialTable) {
        this.financialTable = financialTable;
    }

    public void setReachRateLabel(Label reachRateLabel) {
        this.reachRateLabel = reachRateLabel;
    }

    public void setLblAvgRevenue(Label lblAvgRevenue) {
        this.lblAvgRevenue = lblAvgRevenue;
    }

    public void setLblTotalExpenses(Label lblTotalExpenses) {
        this.lblTotalExpenses = lblTotalExpenses;
    }

    public void setIncidentStatusCombo(ComboBox<String> incidentStatusCombo) {
        this.incidentStatusCombo = incidentStatusCombo;
    }

    public void setRequestsTable(TableView<StoreRequest> requestsTable) {
        this.requestsTable = requestsTable;
    }

    public void setStartdatepicker(DatePicker startdatepicker) {
        this.startdatepicker = startdatepicker;
    }

    public void setRankingPeriodCombo(ComboBox<String> rankingPeriodCombo) {
        this.rankingPeriodCombo = rankingPeriodCombo;
    }

    public void setRequestDetailArea(TextArea requestDetailArea) {
        this.requestDetailArea = requestDetailArea;
    }

    public void setLblTotalItems(Label lblTotalItems) {
        this.lblTotalItems = lblTotalItems;
    }

    public void setLblTotalRevenue(Label lblTotalRevenue) {
        this.lblTotalRevenue = lblTotalRevenue;
    }

    public void setReportEndDate(DatePicker reportEndDate) {
        this.reportEndDate = reportEndDate;
    }

    public void setInventoryTable(TableView<InventoryItem> inventoryTable) {
        this.inventoryTable = inventoryTable;
    }

    public void setReportStartDate(DatePicker reportStartDate) {
        this.reportStartDate = reportStartDate;
    }

    public void setComplianceTable(TableView<ComplianceRecord> complianceTable) {
        this.complianceTable = complianceTable;
    }

    public void setEnddatepicker(DatePicker enddatepicker) {
        this.enddatepicker = enddatepicker;
    }

    public void setRankingTable(TableView<StoreRanking> rankingTable) {
        this.rankingTable = rankingTable;
    }

    public void setIncidentTable(TableView<Incident> incidentTable) {
        this.incidentTable = incidentTable;
    }

    @Override
    public String toString() {
        return "RegionalManagerController{" +
                "inventoryStoreCombo=" + inventoryStoreCombo +
                ", lblLowStock=" + lblLowStock +
                ", lblNetProfitAndMargin=" + lblNetProfitAndMargin +
                ", financialTable=" + financialTable +
                ", reachRateLabel=" + reachRateLabel +
                ", lblAvgRevenue=" + lblAvgRevenue +
                ", lblTotalExpenses=" + lblTotalExpenses +
                ", incidentStatusCombo=" + incidentStatusCombo +
                ", requestsTable=" + requestsTable +
                ", startdatepicker=" + startdatepicker +
                ", rankingPeriodCombo=" + rankingPeriodCombo +
                ", requestDetailArea=" + requestDetailArea +
                ", lblTotalItems=" + lblTotalItems +
                ", lblTotalRevenue=" + lblTotalRevenue +
                ", reportEndDate=" + reportEndDate +
                ", inventoryTable=" + inventoryTable +
                ", reportStartDate=" + reportStartDate +
                ", complianceTable=" + complianceTable +
                ", enddatepicker=" + enddatepicker +
                ", rankingTable=" + rankingTable +
                ", incidentTable=" + incidentTable +
                '}';
    }


    @javafx.fxml.FXML
    public void initialize() {
        colStoreId.setCellValueFactory(new PropertyValueFactory<>("storeId"));
        colTotalSales.setCellValueFactory(new PropertyValueFactory<>("totalSales"));
        colExpenses.setCellValueFactory(new PropertyValueFactory<>("expenses"));
        colProfit.setCellValueFactory(new PropertyValueFactory<>("profit"));
        colMargin.setCellValueFactory(new PropertyValueFactory<>("margin"));
        colstorerank.setCellValueFactory(new PropertyValueFactory<>("rank"));        colStoreNameRanking.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        colRevenue.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        colReqStoreName.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        colReqSubmissionDate.setCellValueFactory(new PropertyValueFactory<>("submissionDate"));
        colReqBudget.setCellValueFactory(new PropertyValueFactory<>("budget"));
        colReqStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colIncStore.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        colIncSeverity.setCellValueFactory(new PropertyValueFactory<>("severity"));
        colIncStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colInvItem.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colInvQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colInvStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colInvThreshold.setCellValueFactory(new PropertyValueFactory<>("threshold"));
        colCompStoreName.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        colCompScore.setCellValueFactory(new PropertyValueFactory<>("score"));
        colCompStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        rankingPeriodCombo.getItems().addAll("This Month", "Last Quarter", "This Year");
        incidentStatusCombo.getItems().addAll("Under Investigation", "Resolved", "Escalated");
        inventoryStoreCombo.getItems().addAll("Store 101 - Downtown", "Store 102 - Uptown", "Store 103 - Suburbs");



        requestsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                requestDetailArea.setText("Store: " + newSelection.getStoreName() + "\n" +
                        "Budget Requested: $" + newSelection.getBudget() + "\n" +
                        "Status: " + newSelection.getStatus());
            } else {
                requestDetailArea.clear();
            }
        });


        // 1. Financial Data
        ObservableList<FinancialRecord> financialData = FXCollections.observableArrayList(
                new FinancialRecord("101-Downtown", 125000.0, 85000.0, 40000.0, 32.0),
                new FinancialRecord("102-Uptown", 98000.0, 75000.0, 23000.0, 23.4),
                new FinancialRecord("103-Suburbs", 145000.0, 90000.0, 55000.0, 37.9)
        );
        financialTable.setItems(financialData);

        // 2. Store Ranking Data
        ObservableList<StoreRanking> rankingData = FXCollections.observableArrayList(
                new StoreRanking(0, "102-Uptown", 98000.0), // Lowest revenue
                new StoreRanking(0, "101-Downtown", 125000.0),
                new StoreRanking(0, "103-Suburbs", 145000.0) // Highest revenue
        );
        rankingTable.setItems(rankingData);

        // 3. Store Requests Data
        ObservableList<StoreRequest> requestData = FXCollections.observableArrayList(
                new StoreRequest("R-001", "Equipment Repair", "101-Downtown", "2023-11-01", 1500.00, "Pending"),
                new StoreRequest("R-002", "Local Marketing", "102-Uptown", "2023-11-03", 500.00, "Pending"),
                new StoreRequest("R-003", "Staff Training", "103-Suburbs", "2023-11-05", 1200.00, "Pending")
        );
        requestsTable.setItems(requestData);

        // 4. Incident Monitoring Data
        ObservableList<Incident> incidentData = FXCollections.observableArrayList(
                new Incident("101-Downtown", "Medium", "Under Investigation"),
                new Incident("102-Uptown", "Low", "Resolved"),
                new Incident("103-Suburbs", "High", "Escalated")
        );
        incidentTable.setItems(incidentData);

        // 5. Inventory Data
        ObservableList<InventoryItem> inventoryData = FXCollections.observableArrayList(
                new InventoryItem("ITM-01", "Frozen Chicken", 150, 200, "Low Stock"),
                new InventoryItem("ITM-02", "Frying Oil", 50, 30, "Adequate"),
                new InventoryItem("ITM-03", "Packaging Boxes", 500, 400, "Adequate"),
                new InventoryItem("ITM-04", "Beverage Cups", 100, 300, "Critical Shortage")
        );
        inventoryTable.setItems(inventoryData);

        // 6. Compliance Status Data
        ObservableList<ComplianceRecord> complianceData = FXCollections.observableArrayList(
                new ComplianceRecord("101-Downtown", 94.5, "Compliant"),
                new ComplianceRecord("102-Uptown", 68.0, "Non-Compliant"),
                new ComplianceRecord("103-Suburbs", 98.2, "Compliant")
        );
        complianceTable.setItems(complianceData);



    }

    private void saveRegionalDecisions() {
        try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream("requests.bin"))) {
            // Save the updated list back to the file
            oos.writeObject(new java.util.ArrayList<>(requestsTable.getItems()));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
        public void handlePublishAnnouncementOA(ActionEvent actionEvent){
            String title = announcementTitleInput.getText();
            String message = announcementMessageInput.getText();
            if (title == null || title.trim().isEmpty() || message == null || message.trim().isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Missing Information", "Please enter both a title and a message before publishing.");
                return;
            }
            showAlert(Alert.AlertType.INFORMATION, "Announcement Published", "Your message '" + title + "' has been sent to all Store Managers.");
            announcementTitleInput.clear();
            announcementMessageInput.clear();
            reachRateLabel.setText("Current Reach Rate: 100%");
    }

    @javafx.fxml.FXML
    public void onGenerateReportClickOA(ActionEvent actionEvent) {
        handleGenerateFinancialReportOA(actionEvent);
    }

    @javafx.fxml.FXML
    public void handleSendWarningOA(ActionEvent actionEvent) {
        // 1. Check if the user actually clicked a row in the table
        Object selectedStore = complianceTable.getSelectionModel().getSelectedItem();

        if (selectedStore == null) {
            showAlert(Alert.AlertType.WARNING, "No Store Selected", "Please select a store from the table first.");
            return;
        }

        // 2. Generate the Warning (Success!)
        showAlert(Alert.AlertType.INFORMATION, "Warning Notification Sent",
                "An official compliance warning has been successfully generated and sent to the selected store's management team.");
    }

    @javafx.fxml.FXML
    public void onUpdateIncidentClick(ActionEvent actionEvent) {
        Incident selectedIncident = incidentTable.getSelectionModel().getSelectedItem();
        String newStatus = incidentStatusCombo.getValue(); // Get status from combo box

        if (selectedIncident == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select an incident from the table.");
            return;
        }

        if (newStatus == null || newStatus.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Status", "Please select a new status from the dropdown menu.");
            return;
        }

        selectedIncident.setStatus(newStatus);
        incidentTable.refresh();
        showAlert(Alert.AlertType.INFORMATION, "Incident Updated", "Incident status successfully updated to: " + newStatus);
    }

    @javafx.fxml.FXML
    public void onRankStoresClick(ActionEvent actionEvent) {
        ObservableList<StoreRanking> items = rankingTable.getItems();

        if (items == null || items.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "No Data", "There are no stores available to rank.");
            return; // This stops the method so the crash never happens
        }

        String period = rankingPeriodCombo.getValue();
        if (period == null) {
            showAlert(Alert.AlertType.WARNING, "Missing Period", "Please select a Ranking Period.");
            return;
        }

        // Now it is safe to sort!
        items.sort((store1, store2) -> Double.compare(store2.getRevenue(), store1.getRevenue()));

        int currentRank = 1;
        for (StoreRanking store : items) {
            store.setRank(currentRank);
            currentRank++;
        }

        rankingTable.refresh();
        showAlert(Alert.AlertType.INFORMATION, "Rankings Refreshed", "Store rankings updated for: " + period);
    }


    public void handleGenerateFinancialReportOA(ActionEvent actionEvent) {
        if (reportStartDate.getValue() == null || reportEndDate.getValue() == null) {
            showAlert(Alert.AlertType.WARNING, "Missing Dates", "Please select both a Start Date and End Date.");
            return;
        }
        if (reportStartDate.getValue().isAfter(reportEndDate.getValue())) {
            showAlert(Alert.AlertType.ERROR, "Invalid Date Range", "The Start Date cannot be after the End Date.");
            return;
        }

        double totalRevenue = 0.0;
        double totalExpenses = 0.0;
        int storeCount = financialTable.getItems().size(); // Get total number of stores

        for (FinancialRecord record : financialTable.getItems()) {
            totalRevenue += record.getTotalSales();
            totalExpenses += record.getExpenses();
        }

        double netProfit = totalRevenue - totalExpenses;
        double margin = (totalRevenue == 0) ? 0 : (netProfit / totalRevenue) * 100;
        double averageRevenue = (storeCount == 0) ? 0 : totalRevenue / storeCount;

        // FIXED: Using the exact label names declared at the top of your class
        lblTotalRevenue.setText("Total Regional Revenue: $" + String.format("%.2f", totalRevenue));
        lblTotalExpenses.setText("Total Regional Expenses: $" + String.format("%.2f", totalExpenses));
        lblNetProfitAndMargin.setText("Regional Net Profit: $" + String.format("%.2f", netProfit) + " | Overall Margin: " + String.format("%.1f", margin) + "%");
        lblAvgRevenue.setText("Average Revenue per Store: $" + String.format("%.2f", averageRevenue));

        showAlert(Alert.AlertType.INFORMATION, "Report Generated", "Financial calculations updated successfully.");
    }

    @javafx.fxml.FXML
    public void handleRejectRequestOA(ActionEvent actionEvent) {
        StoreRequest selectedRequest = requestsTable.getSelectionModel().getSelectedItem();
        if (selectedRequest == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a request to reject.");
            return;
        }
        selectedRequest.setStatus("Rejected");
        requestsTable.refresh();

        saveRegionalDecisions(); // <--- Add this line here too!

        showAlert(Alert.AlertType.INFORMATION, "Success", "Request has been REJECTED.");
    }

    @javafx.fxml.FXML
    public void handleApproveRequestOA(ActionEvent actionEvent) {
        StoreRequest selectedRequest = requestsTable.getSelectionModel().getSelectedItem();
        if (selectedRequest != null) {
            selectedRequest.setStatus("Approved");
            requestsTable.refresh();
            saveRegionalDecisions(); // <--- Add this line!
            showAlert(Alert.AlertType.INFORMATION, "Success", "Request Approved!");
        }
    }

    @javafx.fxml.FXML
    public void onFilterIncidentsClick(ActionEvent actionEvent) {
        // 1. Validate that both dates are selected
        if (startdatepicker.getValue() == null || enddatepicker.getValue() == null) {
            showAlert(Alert.AlertType.WARNING, "Missing Dates", "Please select both a Start Date and an End Date to filter.");
            return;
        }

        // 2. Validate that Start Date is not after End Date
        if (startdatepicker.getValue().isAfter(enddatepicker.getValue())) {
            showAlert(Alert.AlertType.ERROR, "Invalid Date Range", "The Start Date cannot be after the End Date.");
            return;
        }

        // 3. Simulate the filtering action
        showAlert(Alert.AlertType.INFORMATION, "Incidents Filtered",
                "Now displaying incidents from " + startdatepicker.getValue() + " to " + enddatepicker.getValue() + ".");

    }

    @javafx.fxml.FXML
    public void onCheckInventoryClick(ActionEvent actionEvent) {
        String selectedStore = inventoryStoreCombo.getValue();

        // 1. Validation Test
        if (selectedStore == null) {
            showAlert(Alert.AlertType.WARNING, "Missing Store", "Please select a store from the dropdown menu to view its inventory.");
            return;
        }

        // 2. Calculate the stock warnings
        int totalItemsTracked = inventoryTable.getItems().size();
        int lowStockCount = 0;

        for (InventoryItem item : inventoryTable.getItems()) {
            // Count items that are low or critical
            if (item.getStatus().equals("Low Stock") || item.getStatus().equals("Critical Shortage")) {
                lowStockCount++;
            }
        }

        // 3. Update the labels on the screen
        lblTotalItems.setText("Total Item Types: " + totalItemsTracked);
        lblLowStock.setText("Items Needing Restock: " + lowStockCount);

        showAlert(Alert.AlertType.INFORMATION, "Inventory Refreshed", "Now displaying stock levels for " + selectedStore + ".");
    }

    @javafx.fxml.FXML
    public void logoutOA(ActionEvent actionEvent) {
        try {
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource("Login.fxml"));
            javafx.scene.Scene loginScene = new javafx.scene.Scene(fxmlLoader.load());

            javafx.stage.Stage currentStage = (javafx.stage.Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setTitle("KFC Global Operations - Login");
            currentStage.setScene(loginScene);
            currentStage.show();

        } catch (java.io.IOException e) {
            e.printStackTrace();
            showAlert(javafx.scene.control.Alert.AlertType.ERROR, "Logout Error", "Could not load the login screen.");
        }
    }

    @SuppressWarnings("unchecked")
    private void loadGlobalData() {
        try {
            // Load Inventory (Saved by Store Manager)
            java.io.File invFile = new java.io.File("inventory.bin");
            if (invFile.exists()) {
                try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(invFile))) {
                    inventoryList.setAll((java.util.ArrayList<InventoryItem>) ois.readObject());
                }
            }

            // Load Expenses (Saved by Store Manager)
            java.io.File expFile = new java.io.File("expenses.bin");
            if (expFile.exists()) {
                try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(expFile))) {
                    expenseList.setAll((java.util.ArrayList<Expense>) ois.readObject());
                }
            }

            // Load Issues (Saved by Store Manager)
            java.io.File issueFile = new java.io.File("issues.bin");
            if (issueFile.exists()) {
                try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(issueFile))) {
                    issueList.setAll((java.util.ArrayList<StoreIssue>) ois.readObject());
                }
            }

            // Load Requests (Saved by Store Manager)
            java.io.File reqFile = new java.io.File("requests.bin");
            if (reqFile.exists()) {
                try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(reqFile))) {
                    java.util.ArrayList<StoreRequest> loadedRequests = (java.util.ArrayList<StoreRequest>) ois.readObject();
                    // Set these items to your Regional Manager's request table
                    requestsTable.getItems().setAll(loadedRequests);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading files in RM: " + e.getMessage());
        }

    }


}