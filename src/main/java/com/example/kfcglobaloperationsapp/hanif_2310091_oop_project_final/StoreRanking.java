package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import java.io.Serializable;

public class StoreRanking implements Serializable {
    private Integer rank;
    private String storeName;
    private Double revenue;

    // Constructor
    public StoreRanking(Integer rank, String storeName, Double revenue) {
        this.rank = rank;
        this.storeName = storeName;
        this.revenue = revenue;
    }

    // Getters
    public Integer getRank() { return rank; }
    public String getStoreName() { return storeName; }
    public Double getRevenue() { return revenue; }

    // Setters
    public void setRank(Integer rank) { this.rank = rank; }
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public void setRevenue(Double revenue) { this.revenue = revenue; }

    // toString
    @Override
    public String toString() {
        return "StoreRanking{" +
                "rank=" + rank +
                ", storeName='" + storeName + '\'' +
                ", revenue=" + revenue +
                '}';
    }
}
