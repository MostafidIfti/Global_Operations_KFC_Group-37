package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

public class Expense {
    private String expenseId;
    private String department;
    private String category;
    private double amount;
    private String status;

    public Expense(String expenseId, String department, String category, double amount, String status) {
        this.expenseId = expenseId;
        this.department = department;
        this.category = category;
        this.amount = amount;
        this.status = status;
    }

    public String getExpenseId() { return expenseId; }
    public String getDepartment() { return department; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}