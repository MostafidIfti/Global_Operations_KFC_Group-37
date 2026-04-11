package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import java.io.Serializable;

public class Incident implements Serializable {
    private String storeName;
    private String severity;
    private String status;


    public Incident(String storeName, String severity, String status) {
        this.storeName = storeName;
        this.severity = severity;
        this.status = status;
    }


    public String getStoreName() { return storeName; }
    public String getSeverity() { return severity; }
    public String getStatus() { return status; }


    public void setStoreName(String storeName) { this.storeName = storeName; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setStatus(String status) { this.status = status; }


    @Override
    public String toString() {
        return "Incident{" +
                "storeName='" + storeName + '\'' +
                ", severity='" + severity + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
