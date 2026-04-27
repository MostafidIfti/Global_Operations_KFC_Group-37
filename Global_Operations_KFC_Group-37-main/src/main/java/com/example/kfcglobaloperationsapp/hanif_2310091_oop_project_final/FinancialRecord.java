package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import java.io.Serializable;

public class FinancialRecord implements Serializable {

    private String storeId;
    private Double totalSales;
    private Double expenses;
    private Double profit;
    private Double margin;

    public FinancialRecord(String storeId, Double totalSales, Double expenses, Double profit, Double margin) {
        this.storeId = storeId;
        this.totalSales = totalSales;
        this.expenses = expenses;
        this.profit = profit;
        this.margin = margin;
    }


    public String getStoreId() { return storeId; }
    public Double getTotalSales() { return totalSales; }
    public Double getExpenses() { return expenses; }
    public Double getProfit() { return profit; }
    public Double getMargin() { return margin; }


    public void setStoreId(String storeId) { this.storeId = storeId; }
    public void setTotalSales(Double totalSales) { this.totalSales = totalSales; }
    public void setExpenses(Double expenses) { this.expenses = expenses; }
    public void setProfit(Double profit) { this.profit = profit; }
    public void setMargin(Double margin) { this.margin = margin; }


    @Override
    public String toString() {
        return "FinancialRecord{" +
                "storeId='" + storeId + '\'' +
                ", totalSales=" + totalSales +
                ", expenses=" + expenses +
                ", profit=" + profit +
                ", margin=" + margin +
                '}';
    }
}