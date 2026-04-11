package com.example.kfcglobaloperationsapp.IFTI_2310321;

public class SM_Shipment {
    private String orderId;
    private String supplierName;
    private String expectedDate;
    private String status;

    public SM_Shipment(String orderId, String supplierName, String expectedDate, String status) {
        this.orderId = orderId;
        this.supplierName = supplierName;
        this.expectedDate = expectedDate;
        this.status = status;
    }

    public String getOrderId() { return orderId; }
    public String getSupplierName() { return supplierName; }
    public String getExpectedDate() { return expectedDate; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}