package com.example.kfcglobaloperationsapp;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Cashier;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.KitchenSupervisor;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {
    @javafx.fxml.FXML
    private TextField userNameTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPwdField;

    @javafx.fxml.FXML
    public void onActionLogin(ActionEvent actionEvent) throws IOException {
        String username = userNameTextField.getText();
        String pwd = passwordPwdField.getText();

        if (username.isEmpty() || pwd.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please enter a username & password");
            alert.showAndWait();
            return;
        }

        for (User user : Database.usersLoginInfo) {
            if (user.getUserName().equals(username) && user.getPasswd().equals(pwd)) {
                if (user.getRole() == "Cashier") {
                    Parent root = FXMLLoader.load(getClass().getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/Cashier_Fxml_Files/cashierDashboard.fxml"));
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    Database.currentCashier = (Cashier) user;
                }else if (user.getRole() == "KitchenSupervisor") {
                    Parent root = FXMLLoader.load(getClass().getResource("/com/example/kfcglobaloperationsapp/Uzair_2521139_Fxml_Files/KitchenSupervisor--fxml_files/kitchenSupervisorDashboard.fxml"));
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    Database.currentKitchenSupervisor = (KitchenSupervisor) user;
                }
            }
        }

    }
}
