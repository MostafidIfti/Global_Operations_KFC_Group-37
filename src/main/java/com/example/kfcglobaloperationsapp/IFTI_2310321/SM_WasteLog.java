package com.example.kfcglobaloperationsapp.IFTI_2310321;

public class SM_WasteLog {
    private String logId;
    private String itemName;
    private int quantity;
    private String reason;

    public SM_WasteLog(String logId, String itemName, int quantity, String reason) {
        this.logId = logId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.reason = reason;
    }

    public String getLogId() { return logId; }
    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
    public String getReason() { return reason; }
}