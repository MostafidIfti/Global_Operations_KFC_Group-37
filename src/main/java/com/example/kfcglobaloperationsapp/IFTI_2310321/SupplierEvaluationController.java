package com.example.kfcglobaloperationsapp.IFTI_2310321;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SupplierEvaluationController {

    @FXML private ComboBox<String> supplierComboBox;
    @FXML private ComboBox<String> ratingComboBox;
    @FXML private TextField feedbackTextField;

    @FXML private TableView<SM_SupplierEvaluation> evalTableView;
    @FXML private TableColumn<SM_SupplierEvaluation, String> idCol;
    @FXML private TableColumn<SM_SupplierEvaluation, String> supplierCol;
    @FXML private TableColumn<SM_SupplierEvaluation, String> ratingCol;
    @FXML private TableColumn<SM_SupplierEvaluation, String> feedbackCol;

    private ObservableList<SM_SupplierEvaluation> evalList = FXCollections.observableArrayList();
    private int evalCounter = 1;

    @FXML
    public void initialize() {
        supplierComboBox.getItems().addAll("Fresh Farms Ltd", "Beverage Supplies Co", "Global Spice Inc", "Premium Poultry Hub");
        ratingComboBox.getItems().addAll("Excellent (5/5)", "Good (4/5)", "Average (3/5)", "Poor (2/5)", "Unacceptable (1/5)");

        idCol.setCellValueFactory(new PropertyValueFactory<>("evalId"));
        supplierCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        feedbackCol.setCellValueFactory(new PropertyValueFactory<>("feedback"));

        evalList.add(new SM_SupplierEvaluation("EVAL-0", "Fresh Farms Ltd", "Excellent (5/5)", "Always on time."));
        evalTableView.setItems(evalList);
    }

    @FXML
    void handleSaveEvaluation(ActionEvent event) {
        String supplier = supplierComboBox.getValue();
        String rating = ratingComboBox.getValue();
        String feedback = feedbackTextField.getText();

        if (supplier == null || rating == null || feedback.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        String evalId = "EVAL-" + evalCounter++;
        evalList.add(new SM_SupplierEvaluation(evalId, supplier, rating, feedback));

        supplierComboBox.setValue(null);
        ratingComboBox.setValue(null);
        feedbackTextField.clear();
    }
}