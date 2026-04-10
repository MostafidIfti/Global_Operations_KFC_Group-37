module com.example.kfcglobaloperationsapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.kfcglobaloperationsapp to javafx.fxml;
    exports com.example.kfcglobaloperationsapp;

     //Ifti Supply Manager Folder
    opens com.example.kfcglobaloperationsapp.IFTI_2310321 to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.IFTI_2310321;

    //Ifti finance Manager Folder
    exports com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager;
    opens com.example.kfcglobaloperationsapp.IFTI_2310321.finance_manager to javafx.fxml;

    // Uzair Custom Folder
    opens com.example.kfcglobaloperationsapp.Uzair_2521139 to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.Uzair_2521139;
}