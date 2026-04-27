package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

public class ReportLineItem {
    private String itemName;
    private double actualAmount;
    private double budgetedAmount;
    private double variancePercentage;

    public ReportLineItem(String itemName, double actualAmount, double budgetedAmount) {
        this.itemName = itemName;
        this.actualAmount = actualAmount;
        this.budgetedAmount = budgetedAmount;

        if (budgetedAmount != 0) {
            this.variancePercentage = ((actualAmount - budgetedAmount) / budgetedAmount) * 100;
        } else {
            this.variancePercentage = 0;
        }
    }

    public String getItemName() { return itemName; }
    public double getActualAmount() { return actualAmount; }
    public double getBudgetedAmount() { return budgetedAmount; }
    public double getVariancePercentage() { return variancePercentage; }
}