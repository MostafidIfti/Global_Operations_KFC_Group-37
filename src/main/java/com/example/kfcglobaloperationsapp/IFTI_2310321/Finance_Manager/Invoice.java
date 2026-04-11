package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

public class Invoice {
    private String invoiceNumber;
    private String vendorName;
    private double originalAmount;
    private String status;

    public Invoice(String invoiceNumber, String vendorName, double originalAmount, String status) {
        this.invoiceNumber = invoiceNumber;
        this.vendorName = vendorName;
        this.originalAmount = originalAmount;
        this.status = status;
    }

    public String getInvoiceNumber() { return invoiceNumber; }
    public String getVendorName() { return vendorName; }
    public double getOriginalAmount() { return originalAmount; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}