module com.example.kfcglobaloperationsapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.crypto;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    //requires com.example.kfcglobaloperationsapp;
    //requires com.example.kfcglobaloperationsapp;

    opens com.example.kfcglobaloperationsapp to javafx.fxml;
    exports com.example.kfcglobaloperationsapp;

<<<<<<< HEAD
    // ADD THESE TWO LINES RIGHT HERE:
    opens com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
=======
    // IFTI Supply Chain Folder
    exports com.example.kfcglobaloperationsapp.IFTI_2310321;
    opens com.example.kfcglobaloperationsapp.IFTI_2310321 to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;
    opens com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager to javafx.fxml;

    // Uzair Custom Folder
    opens com.example.kfcglobaloperationsapp.Uzair_2521139 to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.Uzair_2521139;
    exports com.example.kfcglobaloperationsapp.Uzair_2521139.Model;
    opens com.example.kfcglobaloperationsapp.Uzair_2521139.Model to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers;
    opens com.example.kfcglobaloperationsapp.Uzair_2521139.Cashier.Controllers to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.Uzair_2521139.KitchenSupervisor.Controllers;
    opens com.example.kfcglobaloperationsapp.Uzair_2521139.KitchenSupervisor.Controllers to javafx.fxml;
>>>>>>> c54d0637a6ee3a0137bdd275f0788035279766dd
}