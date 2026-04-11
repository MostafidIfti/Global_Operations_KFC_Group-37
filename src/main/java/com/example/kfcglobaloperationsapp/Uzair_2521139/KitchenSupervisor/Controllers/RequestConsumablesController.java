package com.example.kfcglobaloperationsapp.Uzair_2521139.KitchenSupervisor.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.ConsumableRequest;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class RequestConsumablesController {


    @javafx.fxml.FXML
    private ComboBox<String> requestKitchenComboBox;
    @javafx.fxml.FXML
    private TextField requestKitchenQuantity;

    public void initialize() {
        requestKitchenComboBox.getItems().addAll("Paper Towel",
                "Napkins", "Disposal Glove Box", "Wipes", "Packaging Box");
    }

    @javafx.fxml.FXML
    public void onActionGenerateTicketSendManager(ActionEvent actionEvent) {
        int qty = Integer.parseInt(requestKitchenQuantity.getText());
        ConsumableRequest request = new ConsumableRequest(
                (int) (Math.random() * 1000),
                qty,
                requestKitchenComboBox.getValue(),
                Database.currentKitchenSupervisor
        );

        Database.consumableRequests.add(request);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("TICKET SUBMITTED");
        alert.showAndWait();
    }
}
