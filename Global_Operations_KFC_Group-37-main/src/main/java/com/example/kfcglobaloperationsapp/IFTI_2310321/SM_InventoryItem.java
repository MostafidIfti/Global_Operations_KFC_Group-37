package com.example.kfcglobaloperationsapp.IFTI_2310321;

public class SM_InventoryItem {
    private String itemName;
    private int currentStock;
    private int reorderLevel;
    private String status;

    public SM_InventoryItem(String itemName, int currentStock, int reorderLevel) {
        this.itemName = itemName;
        this.currentStock = currentStock;
        this.reorderLevel = reorderLevel;


        if (currentStock <= reorderLevel) {
            this.status = "Needs Restock";
        } else {
            this.status = "In Stock";
        }
    }

    public String getItemName() { return itemName; }
    public int getCurrentStock() { return currentStock; }
    public int getReorderLevel() { return reorderLevel; }
    public String getStatus() { return status; }
}