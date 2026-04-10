package com.example.kfcglobaloperationsapp.Uzair_2521139;

import java.util.ArrayList;

public class Order {

    private int orderID;
    private Cashier cashier;
    private CashierSession cashierSession;
    private String status, orderType;
    private double subtotal, discountAmount, tax, grandTotal;
    private ArrayList<OrderItem> orderItemsList = new ArrayList<OrderItem>();


    public Order(int orderID, Cashier cashier, CashierSession cashierSession, String status) {
        this.orderID = orderID;
        this.cashier = cashier;
        this.cashierSession = cashierSession;
        this.status = status;
    }

    public Order(int orderID, Cashier cashier, CashierSession cashierSession, String status, String orderType, double subtotal, double discountAmount, double tax, double grandTotal) {
        this.orderID = orderID;
        this.cashier = cashier;
        this.cashierSession = cashierSession;
        this.status = status;
        this.orderType = orderType;
        this.subtotal = subtotal;
        this.discountAmount = discountAmount;
        this.tax = tax;
        this.grandTotal = grandTotal;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public CashierSession getCashierSession() {
        return cashierSession;
    }

    public void setCashierSession(CashierSession cashierSession) {
        this.cashierSession = cashierSession;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public ArrayList<OrderItem> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(ArrayList<OrderItem> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

    public void addItem(){}
    public void removeItem(){}
    public void applyDiscount(){}
    public void calculateTotal(){}
    public void updateStatus(){}
}
