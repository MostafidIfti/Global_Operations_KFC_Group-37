package com.example.kfcglobaloperationsapp.Uzair_2521139.KitchenSupervisor.Controllers;

import com.example.kfcglobaloperationsapp.Uzair_2521139.Database;
import com.example.kfcglobaloperationsapp.Uzair_2521139.Model.Staff;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class RecordStaffAssignmentController {
    @javafx.fxml.FXML
    private TableColumn<Staff, String> nameTC;
    @javafx.fxml.FXML
    private TableView<Staff> assignedStationTableView;
    @javafx.fxml.FXML
    private ComboBox<String> selectStaffComboBox;
    @javafx.fxml.FXML
    private TableColumn<Staff, String> stationAssignedTC;
    @javafx.fxml.FXML
    private TableColumn<Staff, Integer> employeeIdTC;
    @javafx.fxml.FXML
    private ComboBox<String> assignStationComboBox;

    public void initialize() {

        employeeIdTC.setCellValueFactory(new PropertyValueFactory<>("userID"));
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        stationAssignedTC.setCellValueFactory(new PropertyValueFactory<>("stationAssigned"));

        assignStationComboBox.getItems().addAll("Frying", "Grilling", "Assembly", "Beverages", "Packaging");

        ArrayList<String> staffNames = new ArrayList<>();
        for (Staff staff: Database.staffList) {
            staffNames.add(staff.getName());
        }
        selectStaffComboBox.getItems().addAll(staffNames);

    }

    @javafx.fxml.FXML
    public void onActionAssign(ActionEvent actionEvent) {

        String selectedName    = selectStaffComboBox.getValue();
        String selectedStation = assignStationComboBox.getValue();

        if (selectedName == null || selectedStation == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Select a staff member and a station");
            alert.showAndWait();
            return;
        }

        Staff staffObj = null;
        for (Staff stf : Database.staffList) {
            if (selectedName.equals(stf.getName())) {
                staffObj = stf;
                break;
            }
        }

        for (Staff assigned : Database.assignedStaff) {
            if (staffObj.getUserID() == assigned.getUserID()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Staff already assigned");
                alert.showAndWait();
                return;
            }
        }

        staffObj.setStationAssigned(selectedStation);
        Database.assignedStaff.add(staffObj);

        refreshTable();

    }

    private void refreshTable() {
        assignedStationTableView.getItems().clear();
        for (Staff s : Database.assignedStaff) {
            assignedStationTableView.getItems().add(s);
        }
    }

}
