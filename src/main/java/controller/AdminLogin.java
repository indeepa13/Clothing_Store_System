package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.dto.EmployeeDTO;
import service.ServiceFactory;
import service.custom.EmployeeService;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class  AdminLogin implements Initializable {


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
    EmployeeService employeeService = ServiceFactory.getInstance().getServiceType(ServiceType.EMPLOYEE);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        employeeService.save(new EmployeeDTO(1000, "Admin", "admin@clothify.com", "admin123", "ADMIN"));
    }
    @FXML
    public void BtnLoginOnAction1(ActionEvent event) throws IOException {

        String email = txtEmail1.getText();
        String password = txtPassword01.getText();

        EmployeeDTO employeeDTO = employeeService.searchByUsername(email);

        if (employeeDTO.getPassword().equals(password)) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/admin_dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Dashboard");
            stage.show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid credentials!").show();
        }
    }

    @FXML
    void BtnSignUpOnAction1(ActionEvent event) {

    }


}
