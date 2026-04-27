package com.example.kfcglobaloperationsapp.Uzair_2521139.Model;

public class CashierSession {
    private int sessionID;
    private Cashier cashier;
    private double openingCash, closingCash;
    private String status;


    public CashierSession(Cashier cashier) {
        this.cashier = cashier;
    }

    public CashierSession(int sessionID, Cashier cashier, double openingCash, double closingCash, String status) {
        this.sessionID = sessionID;
        this.cashier = cashier;
        this.openingCash = openingCash;
        this.closingCash = closingCash;
        this.status = status;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public double getOpeningCash() {
        return openingCash;
    }

    public void setOpeningCash(double openingCash) {
        this.openingCash = openingCash;
    }

    public double getClosingCash() {
        return closingCash;
    }

    public void setClosingCash(double closingCash) {
        this.closingCash = closingCash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CashierSession{" +
                "sessionID=" + sessionID +
                ", cashier=" + cashier +
                ", openingCash=" + openingCash +
                ", closingCash=" + closingCash +
                ", status='" + status + '\'' +
                '}';
    }
}
