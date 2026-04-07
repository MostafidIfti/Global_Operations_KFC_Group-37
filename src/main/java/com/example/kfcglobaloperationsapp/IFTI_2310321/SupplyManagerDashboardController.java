package com.example.kfcglobaloperationsapp.IFTI_2310321;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SupplyManagerDashboardController {

    @FXML private ComboBox<String> SupplierSelectCombobox;
    @FXML private ComboBox<String> ProductSelectCombobox;
    @FXML private TextField QuantityTextField;

    @FXML private TableView<SM_CartItem> orderTableView;
    @FXML private TableColumn<SM_CartItem, String> ProdcutNameTableColumn;
    @FXML private TableColumn<SM_CartItem, Integer> QuantityTableColumn;
    @FXML private TableColumn<SM_CartItem, Integer> UPTableColumn;
    @FXML private TableColumn<SM_CartItem, Integer> TotalTableColumn;

    private ObservableList<SM_CartItem> cartItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        SupplierSelectCombobox.getItems().addAll("Fresh Farms Ltd", "KFC Global Chicken", "Beverage Supplies Co.");
        ProductSelectCombobox.getItems().addAll("Chicken Breast (Box)", "Secret Spice Mix (kg)", "Cooking Oil (Liters)");

        ProdcutNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        QuantityTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        UPTableColumn.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        TotalTableColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        orderTableView.setItems(cartItems);
    }

    @FXML
    void handleAddToCart(ActionEvent event) {
        String selectedProduct = ProductSelectCombobox.getValue();
        String qtyText = QuantityTextField.getText();

        if (selectedProduct == null || qtyText.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Info", "Please select a product and enter a quantity.");
            return;
        }

        try {
            int quantity = Integer.parseInt(qtyText);
            if (quantity <= 0) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Quantity must be 1 or more.");
                return;
            }

            int price = selectedProduct.contains("Chicken") ? 50 : 15;

            cartItems.add(new SM_CartItem(selectedProduct, quantity, price));
            QuantityTextField.clear();

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please type a real whole number for quantity.");
        }
    }

    @FXML
    void handlepurchaseorder(ActionEvent event) {
        if (SupplierSelectCombobox.getValue() == null) {
            showAlert(Alert.AlertType.WARNING, "Missing Info", "Please select a supplier first.");
            return;
        }
        if (cartItems.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Empty Cart", "You must add products to the cart before ordering.");
            return;
        }

        showAlert(Alert.AlertType.INFORMATION, "Success!", "Purchase Order successfully sent to " + SupplierSelectCombobox.getValue() + "!");

        cartItems.clear();
        SupplierSelectCombobox.setValue(null);
        ProductSelectCombobox.setValue(null);
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}