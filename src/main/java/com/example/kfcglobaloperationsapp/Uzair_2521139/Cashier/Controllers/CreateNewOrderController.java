package com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Coupon;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.MenuItem;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Order;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.OrderItem;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.concurrent.atomic.DoubleAccumulator;

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
        orderTypeComboBox.setValue("Dine-In");
        Database.currentOrder = new Order(
                Database.orderCount,
                Database.currentSession,
                "Pending",
                "Dine-In",
                0d,
                0d,
                0d,
                0d
        );

    }

    public void onMouseClickCell(int id) throws IOException {

        for (OrderItem orderItem: Database.currentOrder.getOrderItemsList()) {
            if (orderItem.getOrderItemID() == id) {
                orderItem.setQuantity(orderItem.getQuantity() + 1);
                orderItem.calculateSubtotal();
                updateUI(orderItem);
                return;
            }
        }


        OrderItem orderItem = new OrderItem(
                Database.menuItems.get(id-1).getMenuItemID(),1,
                Database.currentOrder,
                Database.menuItems.get(id-1)
        );

        Database.currentOrder.getOrderItemsList().add(orderItem);
        this.loadUI(orderItem);
        this.updateOrderSummary();
    }

    @javafx.fxml.FXML
    public void onMouseClickCellOne(Event event) throws IOException {
        onMouseClickCell(1);
    }



    @javafx.fxml.FXML
    public void onMouseClickCellTwo(Event event) throws IOException {
        onMouseClickCell(2);
    }
    @javafx.fxml.FXML
    public void onMouseClickCellSix(Event event) throws IOException {
        onMouseClickCell(6);
    }
    @javafx.fxml.FXML
    public void onMouseClickCellNine(Event event) throws IOException {
        onMouseClickCell(9);
    }
    @javafx.fxml.FXML
    public void onMouseClickCellFive(Event event) throws IOException {
        onMouseClickCell(5);
    }
    @javafx.fxml.FXML
    public void onMouseClickCellEight(Event event) throws IOException {
        onMouseClickCell(8);
    }
    @javafx.fxml.FXML
    public void onMouseClickCellFour(Event event) throws IOException {
        onMouseClickCell(4);
    }
    @javafx.fxml.FXML
    public void onMouseClickCellThree(Event event) throws IOException {
        onMouseClickCell(3);
    }
    @javafx.fxml.FXML
    public void onMouseClickCellSeven(Event event) throws IOException {
        onMouseClickCell(7);

    }


    public void loadUI(OrderItem orderItem) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/Cashier_Fxml_Files/orderItem.fxml"));
        Node root = fxml.load();

        OrderItemController controller = fxml.getController();
        root.setUserData(controller);
        controller.setOrderItem(orderItem);
        controller.setMainController(this);

        Label name = (Label) root.lookup("#orderItemName");
        Label price = (Label) root.lookup("#orderItemPrice");
        TextField quantity = (TextField) root.lookup("#orderItemQuantity");

        root.setId(String.valueOf(orderItem.getOrderItemID()));

        name.setText(orderItem.getMenuItem().getName());
        price.setText(String.valueOf(orderItem.getItemSubtotal()));
        quantity.setText(String.valueOf(orderItem.getQuantity()));

        orderItemSummaryVBOX.getChildren().add(root);
    }


    public void updateUI(OrderItem orderItem) {
        ObservableList<Node> orderItemNodes = orderItemSummaryVBOX.getChildren();
        for(Node node: orderItemNodes) {
            if (String.valueOf(orderItem.getOrderItemID()).equals(node.getId())) {
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

        Database.currentOrder.setSubtotal(total);
        Database.currentOrder.setGrandTotal(grandTotal);
        Database.currentOrder.setTax(vat);

        subTotalSummaryLabel.setText("Sub Total: " + String.valueOf(total));
        TotalSummaryLabel.setText("Grand Total: " + String.valueOf(grandTotal));
        vatSummaryLabel.setText("Vat: " + String.valueOf(vat));
        System.out.println(Database.currentOrder.getSubtotal());
        System.out.println(Database.currentOrder.getGrandTotal());
    }


    @FXML
    public void onActionCheck(ActionEvent actionEvent) {
        Database.currentOrder.setOrderType(orderTypeComboBox.getValue());
    }

    @FXML
    public void onActionOrderPayment(ActionEvent actionEvent) throws IOException {

        if (Database.currentOrder.getOrderItemsList().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Select An Item Before Proceeding");
            alert.showAndWait();
            return;
        }

        Scene cashierScene = ((Node) actionEvent.getSource()).getScene();

        ObservableList<Tab> tabList = ((TabPane) cashierScene.lookup("#cashierTab")).getTabs();


        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/Cashier_Fxml_Files/payment.fxml"));
        for (Tab elem : tabList) {
            if ("createNewOrder".equals(elem.getId())) {
                elem.setContent(fxml.load());
            }

        }
    }

    public void removeOrderItem(OrderItem orderItem) {

    }


    @FXML
    public void onActionApplyCoupon(ActionEvent actionEvent) {
        String code = couponCodeTextField.getText();

        if (Database.currentOrder.getDiscountAmount() > 0d) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Coupon Already applied!");
            alert.showAndWait();
            return;
        }
        for (Coupon coupon: Database.coupons) {
            if (code.equals(coupon.getCouponCode())) {
                double discount = Database.currentOrder.getSubtotal() * (coupon.getDiscountPercent() / 100d);
                Database.currentOrder.setDiscountAmount(discount);

                double newGrandTotal = Database.currentOrder.getSubtotal()
                        + Database.currentOrder.getTax()
                        - discount;
                Database.currentOrder.setGrandTotal(newGrandTotal);

                discountSummaryLabel.setText("Discount: -" + discount);
                TotalSummaryLabel.setText("Grand Total: " + newGrandTotal);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Coupon applied! " + coupon.getDiscountPercent() + "% off");
                alert.showAndWait();

            }
        }

    }


    @Deprecated
    public void onMouseClickUpdateUI(Event event) {
    }
}
