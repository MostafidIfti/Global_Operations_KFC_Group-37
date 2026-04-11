package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

public class CashTransaction {
    private String transactionId;
    private String category;
    private String date;
    private double amount;
    private String type; // "Inflow" or "Outflow"

    public CashTransaction(String transactionId, String category, String date, double amount, String type) {
        this.transactionId = transactionId;
        this.category = category;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public String getTransactionId() { return transactionId; }
    public String getCategory() { return category; }
    public String getDate() { return date; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
}