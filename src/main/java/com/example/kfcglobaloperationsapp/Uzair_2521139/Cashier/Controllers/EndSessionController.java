package com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class EndSessionController {
    @javafx.fxml.FXML
    private TextField closingTextField;


    public void initialize() {

    }

    @javafx.fxml.FXML
    public void onActionEndSession(ActionEvent actionEvent) {
        Scene cashierScene = ((Node)actionEvent.getSource()).getScene();
        TabPane cashierTab = (TabPane)cashierScene.lookup("#cashierTab");
        ObservableList<Tab> tabList = cashierTab.getTabs();
        int count = 0;
        for (Tab tab: tabList) {
            if (!"generateShiftSummary".equals(tab.getId())) {
                tab.setDisable(true);

            }
            count = count + 1;
        }
        cashierTab.getSelectionModel().select(count);
    }


}
