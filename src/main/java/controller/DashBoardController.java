package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnEmployee;

    @FXML
    void btnAdminLogOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/admin_login.fxml.fxml"));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Login Page");
        newStage.show();

    }

    @FXML
    void btnEmployeeLogOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/employee_login.fxml.fxml"));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.setTitle("Login Page");
        newStage.show();

    }

}
