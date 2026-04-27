package com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Order;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.OrderItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrderQueueController {
    @javafx.fxml.FXML
    private TableView<Order> orderQueueTableView;
    @javafx.fxml.FXML
    private TextField orderIdTextField;
    @javafx.fxml.FXML
    private TableColumn<Order, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<Order, Integer> orderIdTC;
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderTypeTC;
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderInfoTC;


    @FXML
    public void initialize() {
        orderIdTC.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        orderTypeTC.setCellValueFactory(new PropertyValueFactory<>("orderType"));
        orderInfoTC.setCellValueFactory(new PropertyValueFactory<>("orderItemsList"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void onActionSearchOrderID(ActionEvent actionEvent) {
        int orderId = Integer.parseInt(orderIdTextField.getText());
        for (Order order: orderQueueTableView.getItems()) {
            if (order.getOrderID() == orderId) {
                orderQueueTableView.getItems().clear();
                orderQueueTableView.getItems().add(order);
            }
        }
    }

    @FXML
    public void onActionRefresh(ActionEvent actionEvent) {
        orderQueueTableView.getItems().clear();
        for (Order order : Database.paidOrders) {
            orderQueueTableView.getItems().add(order);
        }
    }

    @FXML
    public void onActionMarkAsServed(ActionEvent actionEvent) {
        String input = orderIdTextField.getText();
        
        if (input.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Enter an Order ID first");
            alert.showAndWait();
            return;
        }

        int orderIdInput = Integer.parseInt(input);


        for (Order order : Database.paidOrders) {
            if (order.getOrderID() == orderIdInput) {
                if (!"Ready".equals(order.getStatus())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Order Not Ready Yet");
                    alert.showAndWait();
                    return;
                }
                order.setStatus("Completed");
                onActionRefresh(actionEvent);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Order #" + orderIdInput + " marked as Served");
                alert.showAndWait();
                return;
            }
        }

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("No Order Found");
        alert.showAndWait();
    }
}
