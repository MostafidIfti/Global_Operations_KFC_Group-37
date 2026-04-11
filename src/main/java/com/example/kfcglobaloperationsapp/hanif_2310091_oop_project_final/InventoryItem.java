package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
import java.io.Serializable; // 1. ADD THIS IMPORT

public class InventoryItem implements Serializable{
    private String itemId;
    private String itemName;
    private int quantity; // Matches PropertyValueFactory("quantity")
    private int threshold;
    private String status;

    // Full Constructor
    public InventoryItem(String itemId, String itemName, int quantity, int threshold, String status) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.threshold = threshold;
        this.status = status;
    }

    // Getters
    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
    public int getThreshold() { return threshold; }
    public String getStatus() { return status; }

    // Setters
    public void setItemId(String itemId) { this.itemId = itemId; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setThreshold(int threshold) { this.threshold = threshold; }
    public void setStatus(String status) { this.status = status; }

    // toString Method
    @Override
    public String toString() {
        return "InventoryItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", threshold=" + threshold +
                ", status='" + status + '\'' +
                '}';
    }
}