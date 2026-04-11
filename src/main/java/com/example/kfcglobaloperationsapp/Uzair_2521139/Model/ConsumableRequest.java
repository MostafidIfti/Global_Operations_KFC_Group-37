package com.example.kfcglobaloperationsapp.Uzair_2521139.Model;

public class ConsumableRequest {

    private int requestId, quantity;
    private KitchenSupervisor supervisor;
    private String itemName;

    public ConsumableRequest() {
    }

    public ConsumableRequest(int requestId, int quantity, String itemName, KitchenSupervisor supervisor) {
        this.requestId = requestId;
        this.quantity = quantity;
        this.supervisor = supervisor;
        this.itemName = itemName;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public KitchenSupervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(KitchenSupervisor supervisor) {
        this.supervisor = supervisor;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
