package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static sun.security.x509.OIDMap.getClass;

public class DashBoardController {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnEmployee;

    @FXML
    void btnAdminLogOnAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/admin_login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Admin Login");
        stage.show();




    }

    @FXML
    void btnEmployeeLogOnAction(ActionEvent event ) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/admin_login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Admin Login");
        stage.show();

    }

}
