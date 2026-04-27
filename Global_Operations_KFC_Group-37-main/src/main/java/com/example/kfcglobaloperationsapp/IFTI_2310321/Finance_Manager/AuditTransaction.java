package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

public class AuditTransaction {
    private String txnId;
    private String type;
    private double amount;
    private String date;
    private String status;

    public AuditTransaction(String txnId, String type, double amount, String date, String status) {
        this.txnId = txnId;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public String getTxnId() { return txnId; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}