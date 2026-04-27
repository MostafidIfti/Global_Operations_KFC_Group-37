package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import java.io.Serializable;
public class StoreIssue implements Serializable {
    private String issueId;
    private String type;
    private String description;
    private String status;

    // Constructor
    public StoreIssue(String issueId, String type, String description, String status) {
        this.issueId = issueId;
        this.type = type;
        this.description = description;
        this.status = status;
    }

    // Getters
    public String getIssueId() { return issueId; }
    public String getType() { return type; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }

    // Setters
    public void setIssueId(String issueId) { this.issueId = issueId; }
    public void setType(String type) { this.type = type; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }

    // toString
    @Override
    public String toString() {
        return "StoreIssue{" +
                "issueId='" + issueId + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}