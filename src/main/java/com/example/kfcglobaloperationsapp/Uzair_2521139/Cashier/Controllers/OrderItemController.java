package com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Order;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.OrderItem;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class OrderItemController {
    @javafx.fxml.FXML
    private Label orderItemName;
    @javafx.fxml.FXML
    private Label orderItemPrice;
    @javafx.fxml.FXML
    private TextField orderItemQuantity;
    @javafx.fxml.FXML
    private Button incrementQuantityBTN;
    @javafx.fxml.FXML
    private Button decrementQuantityBTN;


    private OrderItem orderItem;
    private CreateNewOrderController mainController;


    public void initialize() {

    }

    public void setOrderItemQuantity(TextField orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
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

    public OrderItem getOrderItem() {
        return orderItem;
    }


    public String getOrderItemQuantity() {
        return orderItemQuantity.getText();
    }

    public void setOrderItemQuantity(String orderItemQuantity) {
        this.orderItemQuantity.setText(orderItemQuantity);
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public CreateNewOrderController getMainController() {
        return mainController;
    }

    public void setMainController(CreateNewOrderController mainController) {
        this.mainController = mainController;
    }

    public void initData(OrderItem orderItem, CreateNewOrderController mainController) {
        this.orderItem = orderItem;
        this.mainController = mainController;

        orderItemName.setText(orderItem.getMenuItem().getName());
        orderItemPrice.setText(String.valueOf(orderItem.getItemSubtotal()));
        orderItemQuantity.setText(String.valueOf(orderItem.getQuantity()));
    }

    @javafx.fxml.FXML
    public void onActionIncrementQuantity(ActionEvent actionEvent) {
        orderItem.setQuantity(orderItem.getQuantity() + 1);
        orderItem.calculateSubtotal();
        orderItemQuantity.setText(String.valueOf(orderItem.getQuantity()));
        orderItemPrice.setText(String.valueOf(orderItem.getItemSubtotal()));

        mainController.updateOrderSummary();
    }

    @javafx.fxml.FXML
    public void onActionDecrementQuantity(ActionEvent actionEvent) {
        if (orderItem.getQuantity() <= 1) {
            return;
        }

        orderItem.setQuantity(orderItem.getQuantity() - 1);
        orderItem.calculateSubtotal();
        orderItemQuantity.setText(String.valueOf(orderItem.getQuantity()));
        orderItemPrice.setText(String.valueOf(orderItem.getItemSubtotal()));

        mainController.updateOrderSummary();
    }
}
