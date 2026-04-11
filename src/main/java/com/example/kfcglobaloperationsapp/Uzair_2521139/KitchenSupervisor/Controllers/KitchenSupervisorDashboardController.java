package com.example.kfcglobaloperationsapp.Uzair_2521139.KitchenSupervisor.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class KitchenSupervisorDashboardController {
    @javafx.fxml.FXML
    private Tab requestConsumablesTab;
    @javafx.fxml.FXML
    private Tab incomingOrdersTab;
    @javafx.fxml.FXML
    private Label welcomeTextLabel;
    @javafx.fxml.FXML
    private Tab ingredientManagementTab;
    @javafx.fxml.FXML
    private Tab equipmentMaintenaceTab;
    @javafx.fxml.FXML
    private Button logOutButton;
    @javafx.fxml.FXML
    private TabPane kitchenTabPane;
    @javafx.fxml.FXML
    private Tab recordWasteTab;
    @javafx.fxml.FXML
    private Label kitchenSupervisorID;

    public void initialize() {
        welcomeTextLabel.setText("Welcome, " + Database.currentKitchenSupervisor.getName());
        kitchenSupervisorID.setText("CashierID: " + String.valueOf(Database.currentKitchenSupervisor.getUserID()));
    }

    public Tab getRequestConsumablesTab() {
        return requestConsumablesTab;
    }

    public void setRequestConsumablesTab(Tab requestConsumablesTab) {
        this.requestConsumablesTab = requestConsumablesTab;
    }

    public Tab getIncomingOrdersTab() {
        return incomingOrdersTab;
    }

    public void setIncomingOrdersTab(Tab incomingOrdersTab) {
        this.incomingOrdersTab = incomingOrdersTab;
    }

    public Label getWelcomeTextLabel() {
        return welcomeTextLabel;
    }

    public void setWelcomeTextLabel(Label welcomeTextLabel) {
        this.welcomeTextLabel = welcomeTextLabel;
    }

    public Tab getIngredientManagementTab() {
        return ingredientManagementTab;
    }

    public void setIngredientManagementTab(Tab ingredientManagementTab) {
        this.ingredientManagementTab = ingredientManagementTab;
    }

    public Tab getEquipmentMaintenaceTab() {
        return equipmentMaintenaceTab;
    }

    public void setEquipmentMaintenaceTab(Tab equipmentMaintenaceTab) {
        this.equipmentMaintenaceTab = equipmentMaintenaceTab;
    }

    public Button getLogOutButton() {
        return logOutButton;
    }

    public void setLogOutButton(Button logOutButton) {
        this.logOutButton = logOutButton;
    }

    public TabPane getKitchenTabPane() {
        return kitchenTabPane;
    }

    public void setKitchenTabPane(TabPane kitchenTabPane) {
        this.kitchenTabPane = kitchenTabPane;
    }

    public Tab getRecordWasteTab() {
        return recordWasteTab;
    }

    public void setRecordWasteTab(Tab recordWasteTab) {
        this.recordWasteTab = recordWasteTab;
    }

    public Label getKitchenSupervisorID() {
        return kitchenSupervisorID;
    }

    public void setKitchenSupervisorID(Label kitchenSupervisorID) {
        this.kitchenSupervisorID = kitchenSupervisorID;
    }

    @javafx.fxml.FXML
    public void onActionLogOut(ActionEvent actionEvent) {
    }
}
