package com.example.kfcglobaloperationsapp.Uzair_2521139.KitchenSupervisor.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Staff;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class RecordStaffAssignmentController {
    @javafx.fxml.FXML
    private TableColumn nameTC;
    @javafx.fxml.FXML
    private TableView assignedStationTableView;
    @javafx.fxml.FXML
    private ComboBox<String> selectStaffComboBox;
    @javafx.fxml.FXML
    private TableColumn stationAssignedTC;
    @javafx.fxml.FXML
    private TableColumn employeeIdTC;
    @javafx.fxml.FXML
    private ComboBox<String> assignStationComboBox;

    public void initialize() {
        assignStationComboBox.getItems().addAll("Frying", "Grilling", "Assembly", "Packaging");
        ArrayList<String> tmp = new ArrayList<>();
        for (Staff staff: Database.staffList) {
            tmp.add(staff.getName());
        }
        selectStaffComboBox.getItems().addAll(tmp);
    }

    @javafx.fxml.FXML
    public void onActionAssign(ActionEvent actionEvent) {
        String staff = selectStaffComboBox.getValue();
        String station = assignStationComboBox.getValue();
        Staff staffObj = null;
        for (Staff stf: Database.staffList) {
            if (staff.equals(stf.getName())) {
                staffObj = stf;
            }
        }
        for (Staff assignStaff: Database.assignedStaff) {
            if (staffObj.getUserID() == assignStaff.getUserID()) {
                //Alert
                return;
            }
        }
        Database.assignedStaff.add(staffObj);

    }
}
