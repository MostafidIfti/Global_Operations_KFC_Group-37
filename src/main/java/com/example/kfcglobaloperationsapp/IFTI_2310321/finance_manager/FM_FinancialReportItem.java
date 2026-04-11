package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

public class FM_FinancialReportItem {
    private String metricName;
    private double actualAmount;
    private double budgetedAmount;
    private double variancePercent; // Event-12: Variance percentage

    public FM_FinancialReportItem(String metricName, double actualAmount, double budgetedAmount) {
        this.metricName = metricName;
        this.actualAmount = actualAmount;
        this.budgetedAmount = budgetedAmount;

        // Event-12: Calculate variance percentage automatically
        if (budgetedAmount != 0) {
            this.variancePercent = ((actualAmount - budgetedAmount) / budgetedAmount) * 100;
        } else {
            this.variancePercent = 0.0;
        }
    }

    public String getMetricName() { return metricName; }
    public double getActualAmount() { return actualAmount; }
    public double getBudgetedAmount() { return budgetedAmount; }
    public double getVariancePercent() { return variancePercent; }
}