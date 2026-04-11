package com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.CashierSession;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;

public class StartSessionController {


    @FXML
    private TextField openingCashAmountTextField;

    @FXML
    public void initialize() {

    }


    @FXML
    public void onActionStartSession(ActionEvent actionEvent) throws IOException {
        String cashAmountText = openingCashAmountTextField.getText();

        if (cashAmountText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter the opening cash amount before creating new session");
            alert.showAndWait();
            return;
        }

        double openingCashAmount = Double.parseDouble(openingCashAmountTextField.getText());

        if (openingCashAmount < 10000) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Amount Must Be More Than 10k BDT");
            alert.showAndWait();
            return;
        }

        Database.currentSession = new CashierSession(
                (int)(2521139 * (10)), Database.currentCashier, openingCashAmount, 0, "Active"
        );

        Scene cashierScene = ((Node) actionEvent.getSource()).getScene();
        Label anchor = (Label) cashierScene.lookup("#sessionActiveStatusLabel");
        anchor.setText("Session: " + "Active");


        ObservableList<Tab> tabList = ((TabPane) cashierScene.lookup("#cashierTab")).getTabs();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Session Created");
        alert.showAndWait();

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/Cashier_Fxml_Files/endSession.fxml"));
        for (Tab elem : tabList) {
            if ("createNewSessionTab".equals(elem.getId())) {
                elem.setContent(fxml.load());
            } else {
                elem.setDisable(false);
            }
        }
    }
}
