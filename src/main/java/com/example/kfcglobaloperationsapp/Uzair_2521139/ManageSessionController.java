package com.example.kfcglobaloperationsapp.Uzair_2521139;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ManageSessionController {


    @FXML
    private TextField openingCashAmountTextField;

    @FXML
    public void initialize() {

    }


    @FXML
    public void onActionStartSession(ActionEvent actionEvent) {

        double openingCashAmount = Double.parseDouble(openingCashAmountTextField.getText());
        if (openingCashAmount < 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Amount Must Be Non-negative");
            alert.showAndWait();
        }

        Database.currentSession = new CashierSession(
                (int)(Math.random() * (100000)), Database.currentCashier, openingCashAmount, 0, "Active"
        );

        Parent test = ((Node) actionEvent.getSource()).getParent().getParent().getParent().getParent();
        System.out.println(test);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Session Created");
        alert.showAndWait();

    }
}
