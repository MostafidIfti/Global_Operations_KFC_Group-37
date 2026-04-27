package com.example.kfcglobaloperationsapp.IFTI_2310321;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class WasteTrackingController {

    @FXML private ComboBox<String> itemComboBox;
    @FXML private TextField quantityTextField;
    @FXML private ComboBox<String> reasonComboBox;

    @FXML private TableView<SM_WasteLog> wasteTableView;
    @FXML private TableColumn<SM_WasteLog, String> logIdCol;
    @FXML private TableColumn<SM_WasteLog, String> itemCol;
    @FXML private TableColumn<SM_WasteLog, Integer> qtyCol;
    @FXML private TableColumn<SM_WasteLog, String> reasonCol;

    private ObservableList<SM_WasteLog> wasteList = FXCollections.observableArrayList();
    private int logCounter = 1000;

    @FXML
    public void initialize() {
        itemComboBox.getItems().addAll("Chicken Breast", "Vegetables", "Burger Buns", "Cooking Oil");
        reasonComboBox.getItems().addAll("Expired", "Damaged in Transit", "Storage Failure", "Quality Control Failed");

        logIdCol.setCellValueFactory(new PropertyValueFactory<>("logId"));
        itemCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<>("reason"));

        wasteList.add(new SM_WasteLog("W-0999", "Vegetables", 15, "Expired"));
        wasteTableView.setItems(wasteList);
    }

    @FXML
    void handleLogWaste(ActionEvent event) {
        String item = itemComboBox.getValue();
        String qtyText = quantityTextField.getText();
        String reason = reasonComboBox.getValue();

        if (item == null || qtyText.isEmpty() || reason == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        try {
            int qty = Integer.parseInt(qtyText);
            String logId = "W-" + logCounter++;
            wasteList.add(new SM_WasteLog(logId, item, qty, reason));

            itemComboBox.setValue(null);
            quantityTextField.clear();
            reasonComboBox.setValue(null);

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Quantity must be a number.");
            alert.showAndWait();
        }
    }
}