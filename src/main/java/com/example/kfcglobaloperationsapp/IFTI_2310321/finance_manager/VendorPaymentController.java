package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class VendorPaymentController {

    // Event 4: Filters
    @FXML private ComboBox<String> vendorFilter;
    @FXML private ComboBox<String> statusFilter;

    // Event 7: Invoice Table
    @FXML private TableView<FM_Invoice> invoiceTable;
    @FXML private TableColumn<FM_Invoice, String> invNumCol;
    @FXML private TableColumn<FM_Invoice, String> vendorCol;
    @FXML private TableColumn<FM_Invoice, Double> amountCol;
    @FXML private TableColumn<FM_Invoice, Integer> agingCol;
    @FXML private TableColumn<FM_Invoice, String> statusCol;

    // Events 8-15: Review & Action Panel
    @FXML private Label verificationDetailsLabel;
    @FXML private TextField adjustAmountField;
    @FXML private TextArea notesArea;
    @FXML private Label systemStatusLabel;

    private FM_Invoice selectedInvoice;

    @FXML
    public void initialize() {
        vendorFilter.getItems().addAll("All Vendors", "Coca-Cola", "Tyson Foods", "McCormick");
        statusFilter.getItems().addAll("All", "Pending", "Flagged");

        invNumCol.setCellValueFactory(new PropertyValueFactory<>("invoiceNumber"));
        vendorCol.setCellValueFactory(new PropertyValueFactory<>("vendorName"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("originalAmount"));
        agingCol.setCellValueFactory(new PropertyValueFactory<>("agingDays"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Event-6 & 7: Fetch and Sort Pending Invoices (Overdue first)
        ObservableList<FM_Invoice> pendingInvoices = FXCollections.observableArrayList(
            new FM_Invoice("INV-8821", "Tyson Foods", 15000.00, "Flagged", "2023-10-01", 14),
            new FM_Invoice("INV-8845", "Coca-Cola", 8500.50, "Pending", "2023-10-10", 5),
            new FM_Invoice("INV-8890", "McCormick", 3200.00, "Pending", "2023-10-20", 0)
        );
        invoiceTable.setItems(pendingInvoices);

        // Event-8: Listen for selection
        invoiceTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedInvoice = newSelection;
                loadInvoiceDetails();
            }
        });
    }

    private void loadInvoiceDetails() {
        // Events 9, 10, 11, 12: Run verifications
        adjustAmountField.setText(String.valueOf(selectedInvoice.getOriginalAmount()));

        if (selectedInvoice.getStatus().equals("Flagged")) {
            verificationDetailsLabel.setText("Mismatch: Quantity received (PO-102) does not match invoice.");
            verificationDetailsLabel.setStyle("-fx-text-fill: red;");
        } else {
            verificationDetailsLabel.setText("Match: PO, Goods Receipt, and Prices Verified.");
            verificationDetailsLabel.setStyle("-fx-text-fill: green;");
        }
    }

    @FXML
    void handleAction(ActionEvent event) {
        if (selectedInvoice == null) {
            systemStatusLabel.setText("Error: Please select an invoice first.");
            return;
        }

        Button btn = (Button) event.getSource();
        String action = btn.getText();

        if (action.contains("Reject")) {
            selectedInvoice.setStatus("Rejected");
            systemStatusLabel.setText("Invoice " + selectedInvoice.getInvoiceNumber() + " Rejected. Vendor notified.");
        }
        else if (action.contains("Approve")) {
            // Event-16: Validate Adjusted Amount
            try {
                double newAmt = Double.parseDouble(adjustAmountField.getText());
                if (newAmt <= 0 || newAmt > selectedInvoice.getOriginalAmount()) {
                    systemStatusLabel.setText("Validation Error: Adjustment must be > 0 and cannot exceed original amount.");
                    systemStatusLabel.setStyle("-fx-text-fill: red;");
                    return;
                }
                selectedInvoice.setAdjustedAmount(newAmt);
                selectedInvoice.setStatus("Approval for payment"); // Event 25
                systemStatusLabel.setText("Approved for $" + newAmt + ". Ledger Updated.");
                systemStatusLabel.setStyle("-fx-text-fill: green;");
            } catch (NumberFormatException e) {
                systemStatusLabel.setText("Error: Invalid number format.");
            }
        }
        invoiceTable.refresh();
    }

    @FXML
    void handleProcessPayments(ActionEvent event) {
        // Events 22, 23, 24, 25: Batch processing
        systemStatusLabel.setText("Success: Batch file created. AP Ledger updated. Emails sent to vendors.");
        systemStatusLabel.setStyle("-fx-text-fill: #007bff; -fx-font-weight: bold;");
    }
}