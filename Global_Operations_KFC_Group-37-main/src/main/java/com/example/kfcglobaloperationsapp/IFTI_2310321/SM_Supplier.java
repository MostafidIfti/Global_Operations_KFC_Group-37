package com.example.kfcglobaloperationsapp.IFTI_2310321;

public class SM_Supplier {
    private String supplierId;
    private String supplierName;
    private String contactInfo;
    private String supplyCategory;
    private String status;

    public SM_Supplier(String supplierId, String supplierName, String contactInfo, String supplyCategory, String status) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactInfo = contactInfo;
        this.supplyCategory = supplyCategory;
        this.status = status;
    }

    public String getSupplierId() { return supplierId; }
    public String getSupplierName() { return supplierName; }
    public String getContactInfo() { return contactInfo; }
    public String getSupplyCategory() { return supplyCategory; }
    public String getStatus() { return status; }
}