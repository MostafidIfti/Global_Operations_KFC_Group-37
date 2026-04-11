package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

public class FM_Expense {
    private String expenseId;
    private String department;
    private String category;
    private double amount;
    private String status;
    private boolean receiptAttached;
    private boolean withinBudget; // Event-8: Compliance check

    public FM_Expense(String expenseId, String department, String category, double amount, String status, boolean receiptAttached, boolean withinBudget) {
        this.expenseId = expenseId;
        this.department = department;
        this.category = category;
        this.amount = amount;
        this.status = status;
        this.receiptAttached = receiptAttached;
        this.withinBudget = withinBudget;
    }

    public String getExpenseId() { return expenseId; }
    public String getDepartment() { return department; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public boolean isReceiptAttached() { return receiptAttached; }
    public boolean isWithinBudget() { return withinBudget; }

    public void setStatus(String status) { this.status = status; }
}