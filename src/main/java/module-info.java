module com.example.kfcglobaloperationsapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.kfcglobaloperationsapp to javafx.fxml;
    exports com.example.kfcglobaloperationsapp;

    // Add these two lines for your custom folder:
    opens com.example.kfcglobaloperationsapp.IFTI_2310321 to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.IFTI_2310321;
}