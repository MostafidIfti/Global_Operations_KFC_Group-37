package com.example.kfcglobaloperationsapp.IFTI_2310321;

public class SM_CartItem {
    private String productName;
    private int quantity;
    private int unitPrice;
    private int total;

    public SM_CartItem(String productName, int quantity, int unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = quantity * unitPrice;
    }

    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public int getUnitPrice() { return unitPrice; }
    public int getTotal() { return total; }
}