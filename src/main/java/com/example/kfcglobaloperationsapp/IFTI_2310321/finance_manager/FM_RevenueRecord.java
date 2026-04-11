package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

public class FM_RevenueRecord {
    private String storeName;
    private String region;
    private double totalRevenue;
    private double growthPercent; // Event-8: Month-over-month growth
    private String performanceStatus; // Event-11 & 12: High performer, Abnormal drop, etc.

    public FM_RevenueRecord(String storeName, String region, double totalRevenue, double growthPercent) {
        this.storeName = storeName;
        this.region = region;
        this.totalRevenue = totalRevenue;
        this.growthPercent = growthPercent;

        if (growthPercent >= 15.0) {
            this.performanceStatus = "High Performer";
        } else if (growthPercent <= -10.0) {
            this.performanceStatus = "Abnormal Drop (Flagged)";
        } else {
            this.performanceStatus = "Stable";
        }
    }

    public String getStoreName() { return storeName; }
    public String getRegion() { return region; }
    public double getTotalRevenue() { return totalRevenue; }
    public double getGrowthPercent() { return growthPercent; }
    public String getPerformanceStatus() { return performanceStatus; }
}