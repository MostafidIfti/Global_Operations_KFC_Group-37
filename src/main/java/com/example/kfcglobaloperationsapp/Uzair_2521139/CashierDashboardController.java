package com.example.kfcglobaloperationsapp.Uzair_2521139;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;



public class CashierDashboardController {


    @FXML
    private Label welcomeTextLabel;
    @FXML
    private Label cashierIdLabel;
    @FXML
    private Button logOutButton;
    @FXML
    private Label sessionActiveStatusLabel;

    @FXML
    public void initialize() {
        Database.currentCashier = new Cashier(
                (int)(Math.random() * (100000)), "Uzair"
        );

        welcomeTextLabel.setText("Welcome, " + Database.currentCashier.name);
        cashierIdLabel.setText("CashierID: " + String.valueOf(Database.currentCashier.userID));
    }

    @FXML
    public void onActionLogOut(ActionEvent actionEvent) {
    }

    public Label getWelcomeTextLabel() {
        return welcomeTextLabel;
    }

    public void setWelcomeTextLabel(Label welcomeTextLabel) {
        this.welcomeTextLabel = welcomeTextLabel;
    }

    public Label getCashierIdLabel() {
        return cashierIdLabel;
    }

    public void setCashierIdLabel(Label cashierIdLabel) {
        this.cashierIdLabel = cashierIdLabel;
    }

    public Button getLogOutButton() {
        return logOutButton;
    }

    public void setLogOutButton(Button logOutButton) {
        this.logOutButton = logOutButton;
    }

    public Label getSessionActiveStatusLabel() {
        return sessionActiveStatusLabel;
    }

    public void setSessionActiveStatusLabel(Label sessionActiveStatusLabel) {
        this.sessionActiveStatusLabel = sessionActiveStatusLabel;
    }
}
