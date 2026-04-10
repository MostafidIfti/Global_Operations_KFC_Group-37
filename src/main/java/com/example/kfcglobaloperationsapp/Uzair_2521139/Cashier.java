package com.example.kfcglobaloperationsapp.Uzair_2521139;

public class Cashier extends User {

    public Cashier(int id, String name) {
        super(id, name);
    }

    //    public CashierSession startSession() {
//        return new CashierSession();
//    }

    public void endSession() {

    }

//    public Order createCustomerOrder(){
//
//    }

    public RefillRequest requestCashRefill(){
        return new RefillRequest();
    }

    public void viewOrderQueue() {

    }
}
