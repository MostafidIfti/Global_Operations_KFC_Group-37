package com.example.kfcglobaloperationsapp.IFTI_2310321;

public class SM_StockTransfer {
    private String transferId;
    private String itemName;
    private String sourceWarehouse;
    private String destinationOutlet;
    private int quantity;
    private String status;

    public SM_StockTransfer(String transferId, String itemName, String sourceWarehouse, String destinationOutlet, int quantity, String status) {
        this.transferId = transferId;
        this.itemName = itemName;
        this.sourceWarehouse = sourceWarehouse;
        this.destinationOutlet = destinationOutlet;
        this.quantity = quantity;
        this.status = status;
    }

    public String getTransferId() { return transferId; }
    public String getItemName() { return itemName; }
    public String getSourceWarehouse() { return sourceWarehouse; }
    public String getDestinationOutlet() { return destinationOutlet; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }
}