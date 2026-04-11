package com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Order;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Payment;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class GenerateShiftSummaryController {
    @javafx.fxml.FXML
    private Label totalDiscountsLabel;
    @javafx.fxml.FXML
    private Label cardCollectedLabel;
    @javafx.fxml.FXML
    private Label sessionIdLabel;
    @javafx.fxml.FXML
    private Label totalRevenueLabel;
    @javafx.fxml.FXML
    private Label closingCashLabel;
    @javafx.fxml.FXML
    private Label totalOrdersLabel;
    @javafx.fxml.FXML
    private Label cashCollectedLabel;
    @javafx.fxml.FXML
    private Label netCashLabel;
    @javafx.fxml.FXML
    private Label cashierNameLabel;
    @javafx.fxml.FXML
    private Label openingCashLabel;


    public void initialize() {

    }


    @javafx.fxml.FXML
    public void onActionGenerateReport(ActionEvent actionEvent) {

        int    totalOrders    = 0;
        double totalRevenue   = 0;
        double cash  = 0;
        double card  = 0;
        double totalDiscounts = 0;

        for (Order order : Database.paidOrders) {
            totalOrders = totalOrders + 1;
            totalRevenue = totalRevenue + order.getGrandTotal();
            totalDiscounts = totalDiscounts + order.getDiscountAmount();

            Payment payment = order.getPayement();
            if ("Cash".equals(payment.getPaymentMethod())) {
                cash = cash + order.getGrandTotal();
            } else if ("Card".equals(payment.getPaymentMethod())) {
                card = card + order.getGrandTotal();
            }
        }

        double openingFloat = Database.currentSession.getOpeningCash();
        double closingCash  = Database.currentSession.getClosingCash();
        double netCash      = closingCash - openingFloat;

        // Populate labels (null-safe: labels are optional in FXML)
        sessionIdLabel.setText("Session ID: " + Database.currentSession.getSessionID());
        cashierNameLabel.setText("Cashier: " + Database.currentCashier.getName());
        openingCashLabel.setText("Opening Cash: " + openingFloat);
        closingCashLabel.setText("Closing Cash: " + closingCash);
        totalOrdersLabel.setText("Total Orders: " + totalOrders);
        totalRevenueLabel.setText("Total Revenue: "  + totalRevenue);
        cashCollectedLabel.setText("Cash Sales: " + cash);
        cardCollectedLabel.setText("Card Sales: "+ card);
        totalDiscountsLabel.setText("Discounts: -" + totalDiscounts);
        netCashLabel.setText("Net Cash: "       + netCash);
    }
}
