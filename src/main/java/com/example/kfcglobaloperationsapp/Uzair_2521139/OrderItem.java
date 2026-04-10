package com.example.kfcglobaloperationsapp.Uzair_2521139;

public class OrderItem {

    private int orderItemID, quantity;
    private Order order;
    private MenuItem menuItem;
    private double unitPrice, itemSubtotal;

    public OrderItem(int orderItemID, int quantity, Order order, MenuItem menuItem) {
        this.orderItemID = orderItemID;
        this.quantity = quantity;
        this.order = order;
        this.menuItem = menuItem;
        this.itemSubtotal = quantity * menuItem.getPrice();
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
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

    public void calculateSubtotal(){
        this.itemSubtotal = this.quantity * this.menuItem.getPrice();
    }
}
