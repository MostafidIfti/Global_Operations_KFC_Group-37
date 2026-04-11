module com.example.kfcglobaloperationsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.crypto;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;

    opens com.example.kfcglobaloperationsapp to javafx.fxml;
    exports com.example.kfcglobaloperationsapp;

    // IFTI Supply Chain Folder
    exports com.example.kfcglobaloperationsapp.IFTI_2310321;
    opens com.example.kfcglobaloperationsapp.IFTI_2310321 to javafx.fxml;



    // Uzair Custom Folder
    opens com.example.kfcglobaloperationsapp.Uzair_2521139 to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.Uzair_2521139;
    exports com.example.kfcglobaloperationsapp.Uzair_2521139.Model;
    opens com.example.kfcglobaloperationsapp.Uzair_2521139.Model to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;
    opens com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers to javafx.fxml;
}