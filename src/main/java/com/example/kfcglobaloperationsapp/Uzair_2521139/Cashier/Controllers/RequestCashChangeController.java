package com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.RefillRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RequestCashChangeController {

    @javafx.fxml.FXML
    private TextField requestQuantityTextField;
    @javafx.fxml.FXML
    private ComboBox<Double> denominationComboBox;
    @javafx.fxml.FXML
    private Label totalAmountRequestLabel;

    public RequestCashChangeController() {

    }

    public RequestCashChangeController(TextField requestQuantityTextField, ComboBox<Double> denominationComboBox, Label totalAmountRequestLabel) {
        this.requestQuantityTextField = requestQuantityTextField;
        this.denominationComboBox = denominationComboBox;
        this.totalAmountRequestLabel = totalAmountRequestLabel;
    }

    @FXML
    public void initialize() {
        denominationComboBox.getItems().addAll(1000d, 500d, 200d, 100d, 50d, 20d, 10d, 5d);
    }

    public TextField getRequestQuantityTextField() {
        return requestQuantityTextField;
    }

    public void setRequestQuantityTextField(TextField requestQuantityTextField) {
        this.requestQuantityTextField = requestQuantityTextField;
    }

    public ComboBox<Double> getDenominationComboBox() {
        return denominationComboBox;
    }

    public void setDenominationComboBox(ComboBox<Double> denominationComboBox) {
        this.denominationComboBox = denominationComboBox;
    }

    public Label getTotalAmountRequestLabel() {
        return totalAmountRequestLabel;
    }

    public void setTotalAmountRequestLabel(Label totalAmountRequestLabel) {
        this.totalAmountRequestLabel = totalAmountRequestLabel;
    }

    @FXML
    public void onActionSubmitRefillRequest(ActionEvent actionEvent) {
        double quantity = Integer.parseInt(requestQuantityTextField.getText());
        double denomination = denominationComboBox.getValue();
        double totalValue = quantity * denomination;
        totalAmountRequestLabel.setText("Total: " + String.valueOf(totalValue));
        if (quantity > 0) {
            RefillRequest refill = new RefillRequest(
                    (int)(Math.random() * 100),
                    quantity,
                    denomination,
                    Database.currentCashier,
                    Database.currentSession,
                    totalValue
            );
            //System.out.println(refill);
            Database.refillRequestsList.add(refill);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("TICKET SUBMITTED");
        alert.showAndWait();

        totalAmountRequestLabel.setText("Total: " + String.valueOf(totalValue));
    }
}
