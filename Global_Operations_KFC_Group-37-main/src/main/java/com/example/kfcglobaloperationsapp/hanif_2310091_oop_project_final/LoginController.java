package com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    // These variables link directly to your Scene Builder elements!
    @FXML
    private TextField userIdInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private ComboBox<String> roleDropdown;

    @FXML
    private Label messageLabel;

    @FXML public void initialize() {
        roleDropdown.getItems().addAll("Regional Manager", "Store Manager");
    }

    @FXML
    void handleLoginButtonOnClick(ActionEvent event) {
        String id = userIdInput.getText();
        String password = passwordInput.getText();
        String role = roleDropdown.getValue();

        // 1. First, check if any fields are empty
        if (id.isEmpty() || password.isEmpty() || role == null) {
            messageLabel.setText("Error: Please fill in all fields.");
            return; // Stop the code here if there's an error
        }

        // 2. If everything is filled out, show success message
        messageLabel.setStyle("-fx-text-fill: green;");
        messageLabel.setText("Login Successful as " + role);

        // 3. THIS IS WHERE YOUR NEW CODE GOES: The Try-Catch block to switch scenes
        try {
            // Decide which file to load based on the dropdown
            String fxmlFile = "";
            if (role.equals("Store Manager")) {
                fxmlFile = "StoreManagerDashboard.fxml";
            } else if (role.equals("Regional Manager")) {
                fxmlFile = "RegionalManagerDashboard.fxml";
            }

            // Load the new scene using the file we just picked
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(fxmlFile));
            javafx.scene.Parent root = loader.load();
            javafx.scene.Scene newScene = new javafx.scene.Scene(root);

            // Get the current window and set the new scene
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
            stage.show();

        } catch (java.io.IOException e) {
            e.printStackTrace();
            messageLabel.setStyle("-fx-text-fill: red;");
            messageLabel.setText("Error: Could not load dashboard file.");
        }
    }
}