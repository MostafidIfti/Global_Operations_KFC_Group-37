package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

public class FM_BudgetAllocation {
    private String fiscalYear;
    private String department;
    private String region;
    private double allocatedAmount;
    private double utilizedAmount;

    public FM_BudgetAllocation(String fiscalYear, String department, String region, double allocatedAmount, double utilizedAmount) {
        this.fiscalYear = fiscalYear;
        this.department = department;
        this.region = region;
        this.allocatedAmount = allocatedAmount;
        this.utilizedAmount = utilizedAmount;
    }

    public String getFiscalYear() { return fiscalYear; }
    public String getDepartment() { return department; }
    public String getRegion() { return region; }
    public double getAllocatedAmount() { return allocatedAmount; }
    public double getUtilizedAmount() { return utilizedAmount; }

    public void setAllocatedAmount(double allocatedAmount) { this.allocatedAmount = allocatedAmount; }
}