package com.example.kfcglobaloperationsapp.IFTI_2310321.Finance_Manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class FinanceMasterController {

    private void loadScreen(ActionEvent event, String fxmlPath, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void openGoal1ButtonOnClick(ActionEvent e) throws IOException { loadScreen(e, "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/FinancialReportDashboard.fxml", "Goal 1"); }
    @FXML public void openGoal2ButtonOnClick(ActionEvent e) throws IOException { loadScreen(e, "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/VendorPaymentDashboard.fxml", "Goal 2"); }
    @FXML public void openGoal3ButtonOnClick(ActionEvent e) throws IOException { loadScreen(e, "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/BudgetManagementDashboard.fxml", "Goal 3"); }
    @FXML public void openGoal4ButtonOnClick(ActionEvent e) throws IOException { loadScreen(e, "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/RevenueMonitoringDashboard.fxml", "Goal 4"); }
    @FXML public void openGoal5ButtonOnClick(ActionEvent e) throws IOException { loadScreen(e, "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/ExpenseManagementDashboard.fxml", "Goal 5"); }
    @FXML public void openGoal6ButtonOnClick(ActionEvent e) throws IOException { loadScreen(e, "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/CashFlowMonitoringDashboard.fxml", "Goal 6"); }
    @FXML public void openGoal7ButtonOnClick(ActionEvent e) throws IOException { loadScreen(e, "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/FinancialAuditDashboard.fxml", "Goal 7"); }
    @FXML public void openGoal8ButtonOnClick(ActionEvent e) throws IOException { loadScreen(e, "/com/example/kfcglobaloperationsapp/Ifti_2310321_FXML_FIles/Finance-Fxml_works/TaxComplianceDashboard.fxml", "Goal 8"); }
}