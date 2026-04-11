package com.example.kfcglobaloperationsapp.IFTI_2310321;

public class SM_SupplierEvaluation {
    private String evalId;
    private String supplierName;
    private String rating;
    private String feedback;

    public SM_SupplierEvaluation(String evalId, String supplierName, String rating, String feedback) {
        this.evalId = evalId;
        this.supplierName = supplierName;
        this.rating = rating;
        this.feedback = feedback;
    }

    public String getEvalId() { return evalId; }
    public String getSupplierName() { return supplierName; }
    public String getRating() { return rating; }
    public String getFeedback() { return feedback; }
}