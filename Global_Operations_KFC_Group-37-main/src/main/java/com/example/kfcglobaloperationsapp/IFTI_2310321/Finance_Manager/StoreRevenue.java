package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

public class StoreRevenue {
    private String storeName;
    private String region;
    private double totalRevenue;
    private double growthPercentage;
    private String status;

    public StoreRevenue(String storeName, String region, double totalRevenue, double growthPercentage, String status) {
        this.storeName = storeName;
        this.region = region;
        this.totalRevenue = totalRevenue;
        this.growthPercentage = growthPercentage;
        this.status = status;
    }

    public String getStoreName() { return storeName; }
    public String getRegion() { return region; }
    public double getTotalRevenue() { return totalRevenue; }
    public double getGrowthPercentage() { return growthPercentage; }
    public String getStatus() { return status; }
}