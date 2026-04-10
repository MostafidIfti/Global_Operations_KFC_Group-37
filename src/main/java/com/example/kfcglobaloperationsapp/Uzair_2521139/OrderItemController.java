package com.example.kfcglobaloperationsapp.Uzair_2521139;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OrderItemController {
    @javafx.fxml.FXML
    private Button incrementQuantityField;
    @javafx.fxml.FXML
    private Label orderItemName;
    @javafx.fxml.FXML
    private Label orderItemPrice;
    @javafx.fxml.FXML
    private Button decrementQuantityTextField;
    @javafx.fxml.FXML
    private TextField orderItemQuantity;


    public Button getIncrementQuantityField() {
        return incrementQuantityField;
    }

    public void setIncrementQuantityField(Button incrementQuantityField) {
        this.incrementQuantityField = incrementQuantityField;
    }

    public Label getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(Label orderItemName) {
        this.orderItemName = orderItemName;
    }

    public Label getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(Label orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public Button getDecrementQuantityTextField() {
        return decrementQuantityTextField;
    }

    public void setDecrementQuantityTextField(Button decrementQuantityTextField) {
        this.decrementQuantityTextField = decrementQuantityTextField;
    }

    public String getOrderItemQuantity() {
        return orderItemQuantity.getText();
    }

    public void setOrderItemQuantity(String orderItemQuantity) {
        this.orderItemQuantity.setText(orderItemQuantity);
    }

    @javafx.fxml.FXML
    public void onActionDecrementQuantity(ActionEvent actionEvent) {
        Parent root = ((Node)actionEvent.getSource()).getParent();
        OrderItem orderItem = Database.currentOrder.getOrderItemsList().get(Integer.parseInt(root.getId()));
        if (Integer.parseInt(decrementQuantityTextField.getText()) > 1) {
            decrementQuantityTextField.setText(String.valueOf(orderItem.getQuantity() - 1));
        } else {
            System.out.println("remove item yes or no");
        }

    }

    @javafx.fxml.FXML
    public void onActionIncrementQuantity(ActionEvent actionEvent) {
    }
}
