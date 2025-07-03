package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class  AdminLogin {


    @FXML
    private Button btnLogin;

    @FXML
    private JFXTextField txtEmail1;

    @FXML
    private JFXTextField txtPassword1;

    @FXML
    private Button txtSignUp;

    @FXML
    void BtnLoginOnAction1(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/admin_dashboard.fxml."));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Admin DashBoard");
        stage.show();

    }



    @FXML
    void BtnSignUpOnAction1(ActionEvent event) {

    }

}
