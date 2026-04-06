package com.example.kfcglobaloperationsapp.IFTI_2310321;

public class SM_Cart_Item {
    private String productName;
    private int quantity;
    private double unitPrice;
    private double total;
    public SM_Cart_Item(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = quantity * unitPrice;
    }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
    public double getTotal() { return total; }

}
