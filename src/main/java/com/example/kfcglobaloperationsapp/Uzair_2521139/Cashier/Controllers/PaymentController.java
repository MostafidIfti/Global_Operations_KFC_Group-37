package com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Order;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.OrderItem;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Payment;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.concurrent.atomic.DoubleAccumulator;

public class PaymentController {
    @javafx.fxml.FXML
    private Label grandTotalLabel;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, Double> paymentTableSubtotalTC;
    @javafx.fxml.FXML
    private TextField amountGivenTextField;
    @javafx.fxml.FXML
    private TableView<OrderItem> paymentTable;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, String> paymentTableItemTC;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, Double> paymentTablePriceTC;
    @javafx.fxml.FXML
    private Label subtotalLabel;
    @javafx.fxml.FXML
    private ToggleGroup paymentMethod;
    @javafx.fxml.FXML
    private RadioButton cardRb;
    @javafx.fxml.FXML
    private Label vatLabel;
    @javafx.fxml.FXML
    private TableColumn<OrderItem, Integer> paymentTableQtyTC;
    @javafx.fxml.FXML
    private RadioButton cashRb;
    @javafx.fxml.FXML
    private Label changeAmountLabel;
    @javafx.fxml.FXML
    private Button backBtn;

    public void initialize() {
        Payment payment = new Payment(
                (int) (Math.random() * 1000),
                Database.currentOrder
        );

        Database.currentOrder.setPayement(payment);

        paymentTableItemTC.setCellValueFactory(new PropertyValueFactory<>("menuItemName"));
        paymentTableQtyTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        paymentTablePriceTC.setCellValueFactory(new PropertyValueFactory<>("menuItemPrice"));
        paymentTableSubtotalTC.setCellValueFactory(new PropertyValueFactory<>("itemSubtotal"));

        for (OrderItem orderItem : Database.currentOrder.getOrderItemsList()) {
            paymentTable.getItems().add(orderItem);
        }

        subtotalLabel.setText("Subtotal: " + Database.currentOrder.getSubtotal());
        vatLabel.setText("Vat (15%): " + Database.currentOrder.getTax());
        grandTotalLabel.setText("Amount Due: " + Database.currentOrder.getGrandTotal());


    }

    @javafx.fxml.FXML
    public void onActionConfirmPayment(ActionEvent actionEvent) throws IOException {

        if ((Database.currentOrder.getPayement().getChangeAmount() == null)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Calculate Change Amount Before Confirming");
            alert.showAndWait();
            return;
        }

        Database.currentOrder.setStatus("In-Queue");
        Database.paidOrders.add(Database.currentOrder);
        Database.orderCount = Database.orderCount + 1;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("ORDER PLACED");
        alert.showAndWait();

        Scene cashierScene = ((Node) actionEvent.getSource()).getScene();

        ObservableList<Tab> tabList = ((TabPane) cashierScene.lookup("#cashierTab")).getTabs();

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/Cashier_Fxml_Files/createNewOrder.fxml"));
        for (Tab elem : tabList) {
            if ("createNewOrder".equals(elem.getId())) {
                elem.setContent(fxml.load());
            } else {
                elem.setDisable(false);
            }
        }




    }

    @javafx.fxml.FXML
    public void onActionBack(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onActionCalculateChangeAmount(ActionEvent actionEvent) {
        double amount = Double.parseDouble(amountGivenTextField.getText());
        double change = amount - Database.currentOrder.getGrandTotal();
        if (change < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Amount Paid is Lower than Amount Due");
            alert.showAndWait();
        }
        changeAmountLabel.setText("Change Amount: " + String.valueOf(change));
        backBtn.setDisable(true);
        Database.currentOrder.getPayement().setAmountPaid(amount);
        Database.currentOrder.getPayement().setChangeAmount(change);
    }

    @javafx.fxml.FXML
    public void onActionCard(ActionEvent actionEvent) {
        if (cardRb.isSelected()) {
            Database.currentOrder.getPayement().setPaymentMethod("Card");
        }
        amountGivenTextField.setDisable(true);
    }

    @javafx.fxml.FXML
    public void onActionCash(ActionEvent actionEvent) {
        if (cashRb.isSelected()){
            Database.currentOrder.getPayement().setPaymentMethod("Cash");
            amountGivenTextField.setDisable(false);
        }
    }
}
