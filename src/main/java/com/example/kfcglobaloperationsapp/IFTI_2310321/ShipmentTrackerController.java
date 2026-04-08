package com.example.kfcglobaloperationsapp.IFTI_2310321;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShipmentTrackerController {

    @FXML private TableView<SM_Shipment> shipmentTableView;
    @FXML private TableColumn<SM_Shipment, String> orderIdCol;
    @FXML private TableColumn<SM_Shipment, String> supplierCol;
    @FXML private TableColumn<SM_Shipment, String> dateCol;
    @FXML private TableColumn<SM_Shipment, String> statusCol;

    private ObservableList<SM_Shipment> shipmentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        orderIdCol.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        supplierCol.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("expectedDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadDummyData();
    }

    private void loadDummyData() {
        shipmentList.add(new SM_Shipment("PO-1001", "Fresh Farms Ltd", "2026-04-10", "Pending"));
        shipmentList.add(new SM_Shipment("PO-1002", "Beverage Supplies Co", "2026-04-09", "In Transit"));
        shipmentList.add(new SM_Shipment("PO-1003", "Global Spice Inc", "2026-04-08", "Delivered"));

        shipmentTableView.setItems(shipmentList);
    }

    @FXML
    void handleMarkDelivered(ActionEvent event) {
        SM_Shipment selectedShipment = shipmentTableView.getSelectionModel().getSelectedItem();
        if (selectedShipment != null) {
            selectedShipment.setStatus("Delivered");
            shipmentTableView.refresh();
        }
    }
}