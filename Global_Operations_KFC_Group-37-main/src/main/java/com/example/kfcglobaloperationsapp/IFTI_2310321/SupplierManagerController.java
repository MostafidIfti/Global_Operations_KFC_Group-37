package com.example.kfcglobaloperationsapp.IFTI_2310321;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SupplierManagerController {

    @FXML private TextField idTextField;
    @FXML private TextField nameTextField;
    @FXML private TextField contactTextField;
    @FXML private ComboBox<String> categoryComboBox;
    @FXML private ComboBox<String> statusComboBox;

    @FXML private TableView<SM_Supplier> supplierTableView;
    @FXML private TableColumn<SM_Supplier, String> idCol;
    @FXML private TableColumn<SM_Supplier, String> nameCol;
    @FXML private TableColumn<SM_Supplier, String> contactCol;
    @FXML private TableColumn<SM_Supplier, String> categoryCol;
    @FXML private TableColumn<SM_Supplier, String> statusCol;

    private ObservableList<SM_Supplier> supplierList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        categoryComboBox.getItems().addAll("Chicken", "Beverages", "Vegetables", "Packaging");
        statusComboBox.getItems().addAll("Active", "Inactive");

        idCol.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("supplyCategory"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Load basic dummy data
        supplierList.add(new SM_Supplier("S001", "Fresh Farms Ltd", "01711000000", "Chicken", "Active"));
        supplierList.add(new SM_Supplier("S002", "Beverage Supplies Co", "01811000000", "Beverages", "Active"));

        supplierTableView.setItems(supplierList);
    }

    @FXML
    void handleAddSupplier(ActionEvent event) {
        String id = idTextField.getText();
        String name = nameTextField.getText();
        String contact = contactTextField.getText();
        String category = categoryComboBox.getValue();
        String status = statusComboBox.getValue();

        if (id.isEmpty() || name.isEmpty() || contact.isEmpty() || category == null || status == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        supplierList.add(new SM_Supplier(id, name, contact, category, status));

        idTextField.clear();
        nameTextField.clear();
        contactTextField.clear();
        categoryComboBox.setValue(null);
        statusComboBox.setValue(null);
    }

    @FXML
    void handleRemoveSupplier(ActionEvent event) {
        SM_Supplier selectedSupplier = supplierTableView.getSelectionModel().getSelectedItem();
        if (selectedSupplier != null) {
            supplierList.remove(selectedSupplier);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a supplier from the table first.");
            alert.showAndWait();
        }
    }
}