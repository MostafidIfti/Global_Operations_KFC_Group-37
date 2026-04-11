package com.example.kfcglobaloperationsapp.Uzair_2521139.KitchenSupervisor.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Order;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.OrderItem;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class IncomingOrderController {
    @javafx.fxml.FXML
    private TextField orderIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> statusComboBox;
    @javafx.fxml.FXML
    private TableView<Order> incomingOrdersTableView;
    @javafx.fxml.FXML
    private TableColumn<Order, String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<Order, Integer> orderIdTC;
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderTypeTC;
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderInfoTC;


    public void initialize(){
        orderIdTC.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        orderTypeTC.setCellValueFactory(new PropertyValueFactory<>("orderType"));
        orderInfoTC.setCellValueFactory(new PropertyValueFactory<>("orderItemsList"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        statusComboBox.getItems().addAll("Preparing", "Ready", "Delayed");

    }



    @javafx.fxml.FXML
    public void onActionRefresh(ActionEvent actionEvent) {
        for (Order order : Database.paidOrders) {
            incomingOrdersTableView.getItems().add(order);
        }
    }

    @javafx.fxml.FXML
    public void onActionUpdateStatus(ActionEvent actionEvent) {
        for (Order order : Database.paidOrders) {
            if (order.getOrderID() == Integer.parseInt(orderIdTextField.getText())) {
                order.setStatus(statusComboBox.getValue());
            }
        }
    }
}
