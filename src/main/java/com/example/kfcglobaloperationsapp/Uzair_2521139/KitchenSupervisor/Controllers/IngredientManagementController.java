package com.example.kfcglobaloperationsapp.Uzair_2521139.KitchenSupervisor.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Ingredient;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class IngredientManagementController {
    @javafx.fxml.FXML
    private TextField overrideQtyTextField;
    @javafx.fxml.FXML
    private TableColumn<Ingredient, String> nameTC;
    @javafx.fxml.FXML
    private TableColumn<Ingredient, String> unitTC;
    @javafx.fxml.FXML
    private TableColumn<Ingredient, Integer> itemIdTC;
    @javafx.fxml.FXML
    private TableView<Ingredient> ingredientManagementTableView;
    @javafx.fxml.FXML
    private TableColumn<Ingredient, Integer> currentStockTC;
    @javafx.fxml.FXML
    private TextField itemIdTextField;

    public void initialize() {
        itemIdTC.setCellValueFactory(new PropertyValueFactory<>("ingredientId"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        currentStockTC.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        unitTC.setCellValueFactory(new PropertyValueFactory<>("unit"));
    }

    @javafx.fxml.FXML
    public void onActionOverride(ActionEvent actionEvent) {
        int inputId = Integer.parseInt(itemIdTextField.getText());
        for (Ingredient ingredient: Database.ingredients) {
            if (ingredient.getIngredientId() == inputId) {
                ingredient.setCurrentStock(Integer.parseInt(overrideQtyTextField.getText()));
            }
        }
        ingredientManagementTableView.getItems().clear();
        this.onActionLoadIngredientTable(actionEvent);
    }

    @javafx.fxml.FXML
    public void onActionLoadIngredientTable(ActionEvent actionEvent) {
        for (Ingredient ingredient: Database.ingredients) {
            ingredientManagementTableView.getItems().add(ingredient);
        }
    }
}


