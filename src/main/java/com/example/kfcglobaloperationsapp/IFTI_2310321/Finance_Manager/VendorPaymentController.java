package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VendorPaymentController {

    @FXML private ComboBox<String> vendorFilterComboBox;
    @FXML private TableView<Invoice> invoiceTableView;
    @FXML private TableColumn<Invoice, String> invoiceNumCol;
    @FXML private TableColumn<Invoice, String> vendorCol;
    @FXML private TableColumn<Invoice, Double> amountCol;
    @FXML private TableColumn<Invoice, String> statusCol;

    @FXML private Label selectedInvoiceLabel;
    @FXML private ComboBox<String> actionComboBox;
    @FXML private TextField adjustedAmountTextField;
    @FXML private ComboBox<String> paymentMethodComboBox;
    @FXML private Label systemOutputLabel;

    private ObservableList<Invoice> invoiceList;
    private Invoice currentSelectedInvoice;

    @FXML
    public void initialize() {
        // Setup Combo Boxes
        vendorFilterComboBox.getItems().addAll("All", "Fresh Farms Ltd", "Global Packaging Inc", "City Beverages");
        actionComboBox.getItems().addAll("Approve", "Approve with Adjustment", "Reject", "Request Clarification");
        paymentMethodComboBox.getItems().addAll("Bank Transfer", "Check", "Online Payment");

        // Setup Table Columns
        invoiceNumCol.setCellValueFactory(new PropertyValueFactory<>("invoiceNumber"));
        vendorCol.setCellValueFactory(new PropertyValueFactory<>("vendorName"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("originalAmount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        invoiceList = FXCollections.observableArrayList();
    }

    @FXML
    public void loadInvoicesButtonOnClick(ActionEvent event) {
        // Simulating Event 6: Fetching pending invoices
        invoiceList.clear();
        invoiceList.add(new Invoice("INV-1001", "Fresh Farms Ltd", 5000.0, "Pending"));
        invoiceList.add(new Invoice("INV-1002", "Global Packaging Inc", 12000.0, "Pending"));
        invoiceList.add(new Invoice("INV-1003", "City Beverages", 3500.0, "Discrepancy"));

        invoiceTableView.setItems(invoiceList);
        systemOutputLabel.setText("Invoices loaded from database.");
    }

    @FXML
    public void selectInvoiceButtonOnClick(ActionEvent event) {
        // Simulating Event 8: Select invoice to review
        currentSelectedInvoice = invoiceTableView.getSelectionModel().getSelectedItem();

        if (currentSelectedInvoice == null) {
            systemOutputLabel.setText("Error: Please select an invoice from the table first.");
        } else {
            selectedInvoiceLabel.setText("Selected: " + currentSelectedInvoice.getInvoiceNumber() +
                                         " | Vendor: " + currentSelectedInvoice.getVendorName());
            systemOutputLabel.setText("Invoice details loaded for verification.");
        }
    }

    @FXML
    public void processInvoiceButtonOnClick(ActionEvent event) {
        if (currentSelectedInvoice == null) {
            systemOutputLabel.setText("Error: No invoice selected.");
            return;
        }

        String action = actionComboBox.getValue();
        if (action == null) {
            systemOutputLabel.setText("Error: Please select an action.");
            return;
        }

        // Event 16: Validate adjusted amount
        if (action.equals("Approve with Adjustment")) {
            try {
                double adjustedAmount = Double.parseDouble(adjustedAmountTextField.getText());
                double originalAmount = currentSelectedInvoice.getOriginalAmount();

                // Rule: Must be positive and not exceed 5% of original (Original * 1.05)
                if (adjustedAmount <= 0) {
                    systemOutputLabel.setText("Error: Adjusted amount must be positive.");
                    return;
                }
                if (adjustedAmount > (originalAmount * 1.05)) {
                    systemOutputLabel.setText("Error: Adjusted amount exceeds the 5% limit! CFO Approval needed.");
                    return;
                }
            } catch (NumberFormatException e) {
                systemOutputLabel.setText("Error: Please enter a valid number for adjustment.");
                return;
            }
        }

        // Simulating Events 21, 24, 25: Generating voucher, sending email, updating status
        if (action.equals("Approve") || action.equals("Approve with Adjustment")) {
            if (paymentMethodComboBox.getValue() == null) {
                systemOutputLabel.setText("Error: Select a payment method to approve.");
                return;
            }
            currentSelectedInvoice.setStatus("Paid");
            systemOutputLabel.setText("Success! Voucher Generated. Payment sent via " +
                                      paymentMethodComboBox.getValue() + ". Vendor emailed.");
        } else {
            currentSelectedInvoice.setStatus(action);
            systemOutputLabel.setText("Invoice marked as: " + action + ". Vendor notified.");
        }

        // Refresh table to show new status
        invoiceTableView.refresh();
    }
}