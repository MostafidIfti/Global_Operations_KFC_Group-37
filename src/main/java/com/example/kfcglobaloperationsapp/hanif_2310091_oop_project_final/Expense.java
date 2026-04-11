package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import java.io.Serializable;

public class Expense implements Serializable{
    private String expenseId;
    private String category;
    private Double amount;

    // Constructor
    public Expense(String expenseId, String category, Double amount) {
        this.expenseId = expenseId;
        this.category = category;
        this.amount = amount;
    }

    // Getters
    public String getExpenseId() { return expenseId; }
    public String getCategory() { return category; }
    public Double getAmount() { return amount; }

    // Setters
    public void setExpenseId(String expenseId) { this.expenseId = expenseId; }
    public void setCategory(String category) { this.category = category; }
    public void setAmount(Double amount) { this.amount = amount; }

    // toString
    @Override
    public String toString() {
        return "Expense{" +
                "expenseId='" + expenseId + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}