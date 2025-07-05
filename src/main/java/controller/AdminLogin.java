package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class  AdminLogin {


    @FXML
    private Button btnLogin;

    @FXML
    private JFXTextField txtEmail1;

    @FXML
    private JFXPasswordField txtPassword01;

    @FXML
    private Button txtSignUp;

    public AdminLogin() {
      //  this.txtPassword1 = txtPassword1;
    }

    @FXML
    void BtnLoginOnAction1(ActionEvent event) throws IOException {

        String email = txtEmail1.getText();
        String password = txtPassword01.getText();

        // Temporary hardcoded login check
        if (email.equals("admin@clothify.com") && password.equals("admin123")) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/admin_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Invalid credentials!").show();
        }
    }

    @FXML
    void BtnSignUpOnAction1(ActionEvent event) {

    }

}
