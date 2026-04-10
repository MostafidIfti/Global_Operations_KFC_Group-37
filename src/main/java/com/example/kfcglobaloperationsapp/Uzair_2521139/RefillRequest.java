package com.example.kfcglobaloperationsapp.Uzair_2521139;

public class RefillRequest {
    private int refillId;
    private Cashier cashier;
    private CashierSession cashierSession;
    private double totalValue, quantity, denomination;

    public RefillRequest() {
    }

    public RefillRequest(int refillId, double quantity, double denomination, Cashier cashier, CashierSession cashierSession, double totalValue) {
        this.refillId = refillId;
        this.quantity = quantity;
        this.denomination = denomination;
        this.cashier = cashier;
        this.cashierSession = cashierSession;
        this.totalValue = totalValue;
    }

    public int getRefillId() {
        return refillId;
    }

    public void setRefillId(int refillId) {
        this.refillId = refillId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public CashierSession getCashierSession() {
        return cashierSession;
    }

    public void setCashierSession(CashierSession cashierSession) {
        this.cashierSession = cashierSession;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
