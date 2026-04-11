package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import java.io.Serializable;

public class Employee implements Serializable {
    private String empId;
    private String name;
    private String role;
    private String status;

    // Constructor
    public Employee(String empId, String name, String role, String status) {
        this.empId = empId;
        this.name = name;
        this.role = role;
        this.status = status;
    }

    // Getters
    public String getEmpId() { return empId; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getStatus() { return status; }

    // Setters
    public void setEmpId(String empId) { this.empId = empId; }
    public void setName(String name) { this.name = name; }
    public void setRole(String role) { this.role = role; }
    public void setStatus(String status) { this.status = status; }

    // toString
    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}