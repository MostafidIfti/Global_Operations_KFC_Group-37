module com.example.kfcglobaloperationsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.crypto;

    opens com.example.kfcglobaloperationsapp to javafx.fxml;
    exports com.example.kfcglobaloperationsapp;

    // IFTI Supply Chain Folder
    exports com.example.kfcglobaloperationsapp.IFTI_2310321;
    opens com.example.kfcglobaloperationsapp.IFTI_2310321 to javafx.fxml;

    opens com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;



    // Uzair Custom Folder
    opens com.example.kfcglobaloperationsapp.Uzair_2521139 to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.Uzair_2521139;
}