package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    @FXML
    private JFXPasswordField adminConfirmPassword;

    @FXML
    private JFXTextField adminEmail;

    @FXML
    private JFXTextField adminId;

    @FXML
    private JFXTextField adminName;

    @FXML
    private JFXPasswordField adminPassword;

    @FXML
    private TableColumn colCategory;

    @FXML
    private TableColumn colCostPrice;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colQty;

    @FXML
    private TableColumn colSellingPrice;

    @FXML
    private TableColumn colSupplier;

    @FXML
    private TableColumn empColEmail;

    @FXML
    private TableColumn empColId;

    @FXML
    private TableColumn empColName;

    @FXML
    private TableColumn empColRole;

    @FXML
    private JFXTextField empEmail;

    @FXML
    private JFXTextField empId;

    @FXML
    private JFXTextField empName;

    @FXML
    private JFXPasswordField empPassword;

    @FXML
    private JFXTextField empRole;

    @FXML
    private TableColumn supColCompany;

    @FXML
    private TableColumn supColContact;

    @FXML
    private TableColumn supColEmail;

    @FXML
    private TableColumn supColId;

    @FXML
    private TableColumn supColName;

    @FXML
    private JFXTextField supCompany;

    @FXML
    private JFXTextField supContact;

    @FXML
    private JFXTextField supEmail;

    @FXML
    private JFXTextField supId;

    @FXML
    private JFXTextField supName;

    @FXML
    private TableView tblEmployees;

    @FXML
    private TableView tblProducts;

    @FXML
    private TableView tblSuppliers;

    @FXML
    private JFXTextField txtAddedDate;

    @FXML
    private JFXTextField txtCategory;

    @FXML
    private JFXTextField txtColor;

    @FXML
    private JFXTextField txtCostPrice;

    @FXML
    private JFXTextArea txtDescription;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtImagePath;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private JFXTextField txtSellingPrice;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private JFXTextField txtSupplier;
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
        EmployeeDTO dto = new EmployeeDTO(1000, "John Doe", "john@example.com", "1234", "EMPLOYEE");
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
