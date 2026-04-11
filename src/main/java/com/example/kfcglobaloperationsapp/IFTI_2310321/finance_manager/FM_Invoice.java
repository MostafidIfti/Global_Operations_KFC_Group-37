package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

public class FM_Invoice {
    private String invoiceNumber;
    private String vendorName;
    private double originalAmount;
    private double adjustedAmount;
    private String status;
    private String dueDate;
    private int agingDays; // Event-6: Aging (days overdue)

    public FM_Invoice(String invoiceNumber, String vendorName, double originalAmount, String status, String dueDate, int agingDays) {
        this.invoiceNumber = invoiceNumber;
        this.vendorName = vendorName;
        this.originalAmount = originalAmount;
        this.adjustedAmount = originalAmount; // Defaults to original
        this.status = status;
        this.dueDate = dueDate;
        this.agingDays = agingDays;
    }

    public String getInvoiceNumber() { return invoiceNumber; }
    public String getVendorName() { return vendorName; }
    public double getOriginalAmount() { return originalAmount; }
    public double getAdjustedAmount() { return adjustedAmount; }
    public String getStatus() { return status; }
    public String getDueDate() { return dueDate; }
    public int getAgingDays() { return agingDays; }

    public void setStatus(String status) { this.status = status; }
    public void setAdjustedAmount(double adjustedAmount) { this.adjustedAmount = adjustedAmount; }
}