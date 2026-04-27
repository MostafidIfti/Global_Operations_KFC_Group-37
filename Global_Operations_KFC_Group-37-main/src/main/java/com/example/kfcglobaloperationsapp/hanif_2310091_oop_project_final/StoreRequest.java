package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import java.io.Serializable;

public class StoreRequest implements Serializable {
    private String requestId;
    private String requestType;
    private String storeName;
    private String submissionDate;
    private double budget;
    private String status;


    public StoreRequest(String requestId, String requestType, String storeName, String submissionDate, double budget, String status) {
        this.requestId = requestId;
        this.requestType = requestType;
        this.storeName = storeName;
        this.submissionDate = submissionDate;
        this.budget = budget;
        this.status = status;
    }


    public String getRequestId() { return requestId; }
    public String getRequestType() { return requestType; }
    public String getStoreName() { return storeName; }
    public String getSubmissionDate() { return submissionDate; }
    public double getBudget() { return budget; }
    public String getStatus() { return status; }


    public void setRequestId(String requestId) { this.requestId = requestId; }
    public void setRequestType(String requestType) { this.requestType = requestType; }
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public void setSubmissionDate(String submissionDate) { this.submissionDate = submissionDate; }
    public void setBudget(double budget) { this.budget = budget; }
    public void setStatus(String status) { this.status = status; }


    @Override
    public String toString() {
        return "StoreRequest{" +
                "requestId='" + requestId + '\'' +
                ", requestType='" + requestType + '\'' +
                ", budget=" + budget +
                ", status='" + status + '\'' +
                '}';
    }
}