package com.example.kfcglobaloperationsapp.IFTI_2310321;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class StockTransferController {

    @FXML private ComboBox<String> itemComboBox;
    @FXML private ComboBox<String> sourceComboBox;
    @FXML private ComboBox<String> destinationComboBox;
    @FXML private TextField quantityTextField;

    @FXML private TableView<SM_StockTransfer> transferTableView;
    @FXML private TableColumn<SM_StockTransfer, String> idCol;
    @FXML private TableColumn<SM_StockTransfer, String> itemCol;
    @FXML private TableColumn<SM_StockTransfer, String> sourceCol;
    @FXML private TableColumn<SM_StockTransfer, String> destCol;
    @FXML private TableColumn<SM_StockTransfer, Integer> qtyCol;
    @FXML private TableColumn<SM_StockTransfer, String> statusCol;

    private ObservableList<SM_StockTransfer> transferList = FXCollections.observableArrayList();
    private int transferCounter = 100;

    @FXML
    public void initialize() {
        itemComboBox.getItems().addAll("Chicken Breast", "Cooking Oil", "French Fries", "Secret Spice Mix", "Burger Buns");
        sourceComboBox.getItems().addAll("Main Warehouse A", "Warehouse B", "Cold Storage C");
        destinationComboBox.getItems().addAll("Gulshan Outlet", "Banani Outlet", "Dhanmondi Outlet");

        idCol.setCellValueFactory(new PropertyValueFactory<>("transferId"));
        itemCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        sourceCol.setCellValueFactory(new PropertyValueFactory<>("sourceWarehouse"));
        destCol.setCellValueFactory(new PropertyValueFactory<>("destinationOutlet"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        transferList.add(new SM_StockTransfer("TR-099", "Chicken Breast", "Main Warehouse A", "Gulshan Outlet", 50, "Completed"));

        transferTableView.setItems(transferList);
    }

    @FXML
    void handleTransferStock(ActionEvent event) {
        String item = itemComboBox.getValue();
        String source = sourceComboBox.getValue();
        String destination = destinationComboBox.getValue();
        String qtyText = quantityTextField.getText();

        if (item == null || source == null || destination == null || qtyText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        try {
            int qty = Integer.parseInt(qtyText);
            String id = "TR-" + transferCounter++;
            transferList.add(new SM_StockTransfer(id, item, source, destination, qty, "Processing"));

            itemComboBox.setValue(null);
            sourceComboBox.setValue(null);
            destinationComboBox.setValue(null);
            quantityTextField.clear();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Quantity must be a number.");
            alert.showAndWait();
        }
    }
}