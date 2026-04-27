package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

public class Budget {
    private String department;
    private String region;
    private double allocatedAmount;
    private String status;

    public Budget(String department, String region, double allocatedAmount, String status) {
        this.department = department;
        this.region = region;
        this.allocatedAmount = allocatedAmount;
        this.status = status;
    }

    public String getDepartment() { return department; }
    public String getRegion() { return region; }
    public double getAllocatedAmount() { return allocatedAmount; }
    public String getStatus() { return status; }

    public void setAllocatedAmount(double allocatedAmount) { this.allocatedAmount = allocatedAmount; }
    public void setStatus(String status) { this.status = status; }
}