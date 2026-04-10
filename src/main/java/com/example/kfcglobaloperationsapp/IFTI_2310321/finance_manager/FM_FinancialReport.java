package com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;

public class FM_FinancialReport {
    private String reportId;
    private String reportType;
    private String region;
    private String period;
    private double totalAmount;

    public FM_FinancialReport(String reportId, String reportType, String region, String period, double totalAmount) {
        this.reportId = reportId;
        this.reportType = reportType;
        this.region = region;
        this.period = period;
        this.totalAmount = totalAmount;
    }

    public String getReportId() { return reportId; }
    public String getReportType() { return reportType; }
    public String getRegion() { return region; }
    public String getPeriod() { return period; }
    public double getTotalAmount() { return totalAmount; }
}