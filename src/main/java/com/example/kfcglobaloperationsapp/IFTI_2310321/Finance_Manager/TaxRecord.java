package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

public class TaxRecord {
    private String category;
    private double taxableAmount;
    private double taxRate;
    private double calculatedTax;

    public TaxRecord(String category, double taxableAmount, double taxRate, double calculatedTax) {
        this.category = category;
        this.taxableAmount = taxableAmount;
        this.taxRate = taxRate;
        this.calculatedTax = calculatedTax;
    }

    public String getCategory() { return category; }
    public double getTaxableAmount() { return taxableAmount; }
    public double getTaxRate() { return taxRate; }
    public double getCalculatedTax() { return calculatedTax; }
}