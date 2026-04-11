package com.example.kfcglobaloperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    public void loginButtonOnClick(ActionEvent event) {
        String inputUsername = usernameField.getText();
        String inputPassword = passwordField.getText();

        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            errorLabel.setText("Please enter both username and password.");
            return;
        }

        ArrayList<User> savedUsers = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("users.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            savedUsers = (ArrayList<User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            errorLabel.setText("Error: Could not find users.bin!");
            return;
        }

        User loggedInUser = null;
        for (User u : savedUsers) {
            if (u.getUsername().equals(inputUsername) && u.getPassword().equals(inputPassword)) {
                loggedInUser = u;
                break;
            }
        }

        if (loggedInUser != null) {
            try {
                String fxmlPath = "";

                switch (loggedInUser.getRole()) {
                    case "Finance Manager":
                        fxmlPath = "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/FinanceMasterMenu.fxml";
                        break;
                    case "Supply Chain Manager":
    fxmlPath = "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Supply_Chain-Fxml_works/SupplyChainMasterMenu.fxml";
    break;
                    default:
                        // For Hanif and Uzair's roles, we will add their file paths later!
                        errorLabel.setText("Dashboard not linked yet for: " + loggedInUser.getRole());
                        return;
                }

                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle(loggedInUser.getRole() + " Dashboard");
                stage.show();

            } catch (Exception e) {
                errorLabel.setText("Error loading screen! Check your FXML file path.");
                e.printStackTrace();
            }
        } else {
            errorLabel.setText("Invalid username or password!");
        }
    }
}