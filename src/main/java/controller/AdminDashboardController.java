package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import model.dto.EmployeeDTO;
//import model.dto.SupplierDTO;
import model.dto.ProductDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import service.ServiceFactory;
import service.SuperService;
import service.custom.ProductService;
import service.custom.impl.EmployeeServiceImpl;
import util.ServiceType;
//import service.custom.impl.SupplierServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    public JFXTextField txtName;
    @FXML
    private AnchorPane contentArea;

    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
   // private final SupplierServiceImpl supplierService = new SupplierServiceImpl();
    ProductService service = ServiceFactory.getInstance().getServiceType(ServiceType.PRODUCT);

    @FXML
    private void openProductView() throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("/view/product_view.fxml"));
        contentArea.getChildren().setAll(view);
    }

    public void showEmployees() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/employee_view.fxml"));
        contentArea.getChildren().setAll(pane);
    }

    public void showSuppliers() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/supplier_view.fxml"));
        contentArea.getChildren().setAll(pane);
    }

    public void generateSalesReport() throws JRException {
        JasperReport report = JasperCompileManager.compileReport("src/main/resources/reports/sales_report.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, DBConnection.getConnection());
        JasperViewer.viewReport(print, false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    // --- Image Browse Placeholder ---
    public void handleBrowseImage(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Image browse not implemented").show();
        new ProductDTO();
    }

    // --- Product Management Placeholder Methods ---
    public void handleAddProduct(ActionEvent event) {

        new Alert(Alert.AlertType.INFORMATION, "Add Product functionality pending").show();
    }

    public void handleUpdateProduct(ActionEvent event) {

        String name = txtName.getText();
       // service.update();
        new Alert(Alert.AlertType.INFORMATION, "Update Product functionality pending").show();
    }

    public void handleDeleteProduct(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Delete Product functionality pending").show();
    }

    public void handleClearForm(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Clear Product Form functionality pending").show();
    }

    // --- Supplier Management Placeholder Methods ---
//    public void handleAddSupplier(ActionEvent event) {
//        SupplierDTO dto = new SupplierDTO("SUP001", "ABC Traders", "ABC Pvt Ltd", "abc@gmail.com", "0771234567");
//        supplierService.save(dto);
//        new Alert(Alert.AlertType.INFORMATION, "Supplier added successfully").show();
//    }

    public void handleUpdateSupplier(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Update Supplier functionality pending").show();
    }

    public void handleDeleteSupplier(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Delete Supplier functionality pending").show();
    }

    public void handleClearSupplierForm(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Clear Supplier Form functionality pending").show();
    }

    // --- Employee Management Placeholder Methods ---
    public void handleAddEmployee(ActionEvent event) {
        EmployeeDTO dto = new EmployeeDTO("EMP001", "John Doe", "john@example.com", "1234", "EMPLOYEE");
        employeeService.save(dto);
        new Alert(Alert.AlertType.INFORMATION, "Employee added successfully").show();
    }

    public void handleUpdateEmployee(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Update Employee functionality pending").show();
    }

    public void handleDeleteEmployee(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Delete Employee functionality pending").show();
    }

    public void handleClearEmployeeForm(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Clear Employee Form functionality pending").show();
    }

    public void handleAddSupplier(ActionEvent event) {
    }
}
