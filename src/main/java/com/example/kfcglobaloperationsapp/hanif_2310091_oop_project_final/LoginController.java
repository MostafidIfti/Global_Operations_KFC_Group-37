package com.example.hanif_2310091_oop_project_final;
import javafx.event.ActionEvent;
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

    @FXML
    public void initialize() {
        roleDropdown.getItems().addAll("Regional Manager", "Store Manager");
    }
    @FXML
    void handleLoginButtonOnClick(ActionEvent event) {
        String id = userIdInput.getText();
        String password = passwordInput.getText();
        String role = roleDropdown.getValue();

        if (id.isEmpty() || password.isEmpty() || role == null) {
            messageLabel.setText("Error: Please fill in all fields.");
        } else {
            messageLabel.setStyle("-fx-text-fill: green;");
            messageLabel.setText("Login Successful as " + role);
        }
    }
}