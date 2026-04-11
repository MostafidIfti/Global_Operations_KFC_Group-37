package com.example.kfcglobaloperationsapp.IFTI_2310321;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoryManagerController {

    @FXML private TableView<SM_InventoryItem> inventoryTableView;
    @FXML private TableColumn<SM_InventoryItem, String> itemNameCol;
    @FXML private TableColumn<SM_InventoryItem, Integer> currentStockCol;
    @FXML private TableColumn<SM_InventoryItem, Integer> reorderLevelCol;
    @FXML private TableColumn<SM_InventoryItem, String> statusCol;

    private ObservableList<SM_InventoryItem> inventoryList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Connect columns to the data class
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        currentStockCol.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        reorderLevelCol.setCellValueFactory(new PropertyValueFactory<>("reorderLevel"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadInventoryData();
    }

    private void loadInventoryData() {
        inventoryList.clear();

        inventoryList.add(new SM_InventoryItem("Chicken Breast (Boxes)", 150, 50));
        inventoryList.add(new SM_InventoryItem("Cooking Oil (Liters)", 20, 30));
        inventoryList.add(new SM_InventoryItem("Secret Spice Mix (kg)", 8, 15));
        inventoryList.add(new SM_InventoryItem("French Fries (Bags)", 200, 80));
        inventoryList.add(new SM_InventoryItem("Burger Buns (Packs)", 40, 100));
        inventoryList.add(new SM_InventoryItem("Soft Drink Syrup (Gallons)", 60, 20));

        inventoryTableView.setItems(inventoryList);
    }

    @FXML
    void handleShowLowStock(ActionEvent event) {
        ObservableList<SM_InventoryItem> lowStockList = FXCollections.observableArrayList();
        for (SM_InventoryItem item : inventoryList) {
            if (item.getStatus().equals("Needs Restock")) {
                lowStockList.add(item);
            }
        }
        inventoryTableView.setItems(lowStockList);
    }

    @FXML
    void handleShowAllStock(ActionEvent event) {
        inventoryTableView.setItems(inventoryList);
    }
}