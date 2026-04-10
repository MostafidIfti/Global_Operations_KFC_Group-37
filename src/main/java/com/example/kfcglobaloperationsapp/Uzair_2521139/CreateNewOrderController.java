package com.example.kfcglobaloperationsapp.Uzair_2521139;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class CreateNewOrderController {

    int orderIdUpdate = 1;
    @FXML
    private VBox orderItemSummaryVBOX;
    @FXML
    private ScrollPane orderItemSummarySCROLLPANE;
    @FXML
    private Button paymentButton;
    @FXML
    private Label discountSummaryLabel;
    @FXML
    private Label vatSummaryLabel;
    @FXML
    private TextField couponCodeTextField;
    @FXML
    private Label subTotalSummaryLabel;
    @FXML
    private Label TotalSummaryLabel;
    @FXML
    private Button applyCouponButton;
    @FXML
    private ComboBox<String> orderTypeComboBox;

    @FXML
    public void initialize() {

        orderTypeComboBox.getItems().addAll("Dine-In", "Takeaway");
        Database.currentOrder = new Order(
                Database.orderCount,
                Database.currentCashier,
                Database.currentSession,
                "Pending",
                "Dine-In",
                0d,
                0d,
                0d,
                0d
        );

    }


    @javafx.fxml.FXML
    public void onMouseClickCellOne(Event event) throws IOException {
        for (OrderItem orderItem: Database.currentOrder.getOrderItemsList()) {
            if (orderItem.getOrderItemID() == 1) {
                orderItem.setQuantity(orderItem.getQuantity() + 1);
                orderItem.calculateSubtotal();
                updateUI(orderItem.getMenuItem());
                return;
            }
        }


        OrderItem orderItem = new OrderItem(
                Database.menuItems.get(0).getMenuItemID(),1,
                Database.currentOrder,
                Database.menuItems.get(0)
        );

        this.updateUI(orderItem);
        this.updateOrderSummary();
        Database.currentOrder.getOrderItemsList().add(orderItem);
    }

    public void updateUI(OrderItem orderItem) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/Cashier_Fxml_Files/orderItem.fxml"));
        Node root = fxml.load();

        OrderItemController controller = fxml.getController();
        root.setUserData(controller);

        Label name = (Label) root.lookup("#orderItemName");
        Label price = (Label) root.lookup("#orderItemPrice");
        TextField quantity = (TextField) root.lookup("#orderItemQuantity");

        root.setId(String.valueOf(orderItem.getOrderItemID()));

        name.setText(orderItem.getMenuItem().getName());
        price.setText(String.valueOf(orderItem.getItemSubtotal()));
        quantity.setText(String.valueOf(orderItem.getQuantity()));

        orderItemSummaryVBOX.getChildren().add(root);
    }


    public void updateUI(MenuItem menuItem) {
        ObservableList<Node> orderItemNodes = orderItemSummaryVBOX.getChildren();
        for(Node node: orderItemNodes) {
            if (String.valueOf(menuItem.getMenuItemID()).equals(node.getId())) {
                OrderItemController controller = (OrderItemController) node.getUserData();
                controller.setOrderItemQuantity(String.valueOf(Integer.parseInt(controller.getOrderItemQuantity()) + 1));
            }
        }
        updateOrderSummary();
    }

    public void updateOrderSummary() {
        double total = 0d;
        for(OrderItem orderItem: Database.currentOrder.getOrderItemsList()) {
            total = total + orderItem.getItemSubtotal();
        }
        double vat = total * (15d / 100);
        double grandTotal = total + vat;
        subTotalSummaryLabel.setText("SubTotal: " + String.valueOf(total));
        TotalSummaryLabel.setText("Grand Total: " + String.valueOf(grandTotal));
        vatSummaryLabel.setText("Vat: " + String.valueOf(vat));
    }

    @javafx.fxml.FXML
    public void onMouseClickCellTwo(Event event) throws IOException {
        for (OrderItem orderItem: Database.currentOrder.getOrderItemsList()) {
            if (orderItem.getOrderItemID() == 2) {
                orderItem.setQuantity(orderItem.getQuantity() + 1);
                orderItem.calculateSubtotal();
                updateUI(orderItem.getMenuItem());
                return;
            }
        }

        OrderItem orderItem = new OrderItem(
                Database.menuItems.get(1).getMenuItemID(),1,
                Database.currentOrder,
                Database.menuItems.get(1)
        );

        this.updateUI(orderItem);
        Database.currentOrder.getOrderItemsList().add(orderItem);
    }
    @javafx.fxml.FXML
    public void onMouseClickCellSix(Event event) {
    }

    @javafx.fxml.FXML
    public void onMouseClickCellNine(Event event) {
    }

    @javafx.fxml.FXML
    public void onMouseClickCellFive(Event event) {
    }



    @javafx.fxml.FXML
    public void onMouseClickCellEight(Event event) {
    }

    @javafx.fxml.FXML
    public void onMouseClickCellFour(Event event) {
    }

    @javafx.fxml.FXML
    public void onMouseClickCellThree(Event event) {
    }



    @javafx.fxml.FXML
    public void onMouseClickCellSeven(Event event) {
    }
}
