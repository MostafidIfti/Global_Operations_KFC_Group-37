package com.example.kfcglobaloperationsapp.IFTI_2310321;

public class SM_DemandForecast {
    private String itemName;
    private int pastMonthSales;
    private int projectedDemand;
    private String trend;

    public SM_DemandForecast(String itemName, int pastMonthSales, String trend) {
        this.itemName = itemName;
        this.pastMonthSales = pastMonthSales;
        this.trend = trend;
        this.projectedDemand = 0; // Starts at 0 until forecast is generated
    }

    public String getItemName() { return itemName; }
    public int getPastMonthSales() { return pastMonthSales; }
    public int getProjectedDemand() { return projectedDemand; }
    public String getTrend() { return trend; }

    public void generateForecast() {
        if (trend.equals("Increasing")) {
            this.projectedDemand = (int) (pastMonthSales * 1.15); // 15% increase
        } else if (trend.equals("Decreasing")) {
            this.projectedDemand = (int) (pastMonthSales * 0.90); // 10% decrease
        } else {
            this.projectedDemand = pastMonthSales; // No change
        }
    }
}