package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import java.io.Serializable;

public class ComplianceRecord implements Serializable {
    private String storeName;
    private Double score;
    private String status;

    // Constructor
    public ComplianceRecord(String storeName, Double score, String status) {
        this.storeName = storeName;
        this.score = score;
        this.status = status;
    }

    // Getters
    public String getStoreName() { return storeName; }
    public Double getScore() { return score; }
    public String getStatus() { return status; }

    // Setters
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public void setScore(Double score) { this.score = score; }
    public void setStatus(String status) { this.status = status; }

    // toString
    @Override
    public String toString() {
        return "ComplianceRecord{" +
                "storeName='" + storeName + '\'' +
                ", score=" + score +
                ", status='" + status + '\'' +
                '}';
    }
}