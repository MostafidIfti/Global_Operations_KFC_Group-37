package com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


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
    private AnchorPane cashierAnchorPane;

    @FXML
    public void initialize() {

        welcomeTextLabel.setText("Welcome, " + Database.currentCashier.getName());
        cashierIdLabel.setText("CashierID: " + String.valueOf(Database.currentCashier.getUserID()));
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

    public void setSessionActiveStatusLabel(String sessionActiveStatusText) {
        this.sessionActiveStatusLabel.setText(sessionActiveStatusText);
    }
}
