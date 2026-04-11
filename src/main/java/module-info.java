module com.example.kfcglobaloperationsapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.kfcglobaloperationsapp to javafx.fxml;
    exports com.example.kfcglobaloperationsapp;

    // ADD THESE TWO LINES RIGHT HERE:
    opens com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final to javafx.fxml;
    exports com.example.kfcglobaloperationsapp.hanif_2310091_oop_project_final;
}