package com.example.kfcglobaloperationsapp.Uzair_2521139;

public class OrderItem {

    private int orderItemID, orderID, menuItemID, quantity;
    private double unitPrice, itemSubtotal;


    public OrderItem(int orderItemID, int orderID, int menuItemID, int quantity, double unitPrice, double itemSubtotal) {
        this.orderItemID = orderItemID;
        this.orderID = orderID;
        this.menuItemID = menuItemID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.itemSubtotal = itemSubtotal;
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getItemSubtotal() {
        return itemSubtotal;
    }

    public void setItemSubtotal(double itemSubtotal) {
        this.itemSubtotal = itemSubtotal;
    }

    public void calculateSubtotal(){}
}
