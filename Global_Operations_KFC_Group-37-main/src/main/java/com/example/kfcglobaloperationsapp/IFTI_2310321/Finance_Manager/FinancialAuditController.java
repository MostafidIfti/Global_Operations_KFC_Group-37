package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FinancialAuditController {

    @FXML private TableView<AuditTransaction> auditTableView;
    @FXML private TableColumn<AuditTransaction, String> idCol;
    @FXML private TableColumn<AuditTransaction, String> typeCol;
    @FXML private TableColumn<AuditTransaction, Double> amountCol;
    @FXML private TableColumn<AuditTransaction, String> dateCol;
    @FXML private TableColumn<AuditTransaction, String> statusCol;

    @FXML private Label detailsLabel;
    @FXML private TextArea auditNotesTextArea;
    @FXML private Label systemOutputLabel;

    private ObservableList<AuditTransaction> auditList;
    private AuditTransaction selectedTxn;

    @FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("txnId"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        auditList = FXCollections.observableArrayList();
        // Event 3: Fetching transaction logs
        auditList.add(new AuditTransaction("TXN-9901", "In-Store Sale", 450.00, "2026-04-10", "Verified"));
        auditList.add(new AuditTransaction("TXN-9902", "Bulk Supplier Pay", 12500.00, "2026-04-11", "Pending Review"));
        auditList.add(new AuditTransaction("TXN-9903", "Refund", 800.00, "2026-04-11", "Suspicious"));

        auditTableView.setItems(auditList);
    }

    @FXML
    public void viewTxnDetailsOnClick(ActionEvent event) {
        // Event 5 & 6
        selectedTxn = auditTableView.getSelectionModel().getSelectedItem();
        if (selectedTxn != null) {
            detailsLabel.setText("ID: " + selectedTxn.getTxnId() + " | Date: " + selectedTxn.getDate() +
                                 "\nCategory: " + selectedTxn.getType() + " | Amt: $" + selectedTxn.getAmount());
            systemOutputLabel.setText("Transaction details loaded for verification.");
        }
    }

    @FXML
    public void flagSuspiciousOnClick(ActionEvent event) {
        // Event 8
        if (selectedTxn != null) {
            selectedTxn.setStatus("Suspicious");
            auditTableView.refresh();
            systemOutputLabel.setText("ALERT: Transaction " + selectedTxn.getTxnId() + " flagged for review.");
        }
    }

    @FXML
    public void saveAuditReportOnClick(ActionEvent event) {
        // Event 9, 10, 11
        if (auditNotesTextArea.getText().isEmpty()) {
            systemOutputLabel.setText("Error: Audit notes are required before saving.");
        } else {
            systemOutputLabel.setText("Audit Summary: Report saved. " + auditList.size() + " items audited.");
            auditNotesTextArea.clear();
        }
    }

    @FXML
    public void returnToDashboardOnClick(ActionEvent event) {
        // Event 12
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}