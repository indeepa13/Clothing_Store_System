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
import javafx.scene.control.DatePicker;
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
import util.Session;
//import service.custom.impl.SupplierServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    public DatePicker txtAddedDate;
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

    EmployeeDTO currentUser = Session.getInstance().getCurrentUser();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
   // private final SupplierServiceImpl supplierService = new SupplierServiceImpl();
    ProductService productService = ServiceFactory.getInstance().getServiceType(ServiceType.PRODUCT);

//    @FXML
//    private void openProductView() throws IOException {
//        AnchorPane view = FXMLLoader.load(getClass().getResource("/view/product_view.fxml"));
//        contentArea.getChildren().setAll(view);
//    }
//
//    public void showEmployees() throws IOException {
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/employee_view.fxml"));
//        contentArea.getChildren().setAll(pane);
//    }
//
//    public void showSuppliers() throws IOException {
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/supplier_view.fxml"));
//        contentArea.getChildren().setAll(pane);
//    }

    public void generateSalesReport() throws JRException {
        JasperReport report = JasperCompileManager.compileReport("src/main/resources/reports/sales_report.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, DBConnection.getConnection());
        JasperViewer.viewReport(print, false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminId.setText(String.valueOf(currentUser.getId()));
    }

    // --- Image Browse Placeholder ---
    public void handleBrowseImage(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Image browse not implemented").show();
        new ProductDTO();
    }

    // --- Product Management Placeholder Methods ---
    public void handleAddProduct(ActionEvent event) {

        String txtIDText = txtID.getText();
        String txtNameText = txtName.getText();
        String txtCategoryText = txtCategory.getText();
        String txtColorText = txtColor.getText();
        String txtSizeText = txtSize.getText();
        String txtQtyText = txtQty.getText();
        String txtCostPriceText = txtCostPrice.getText();
        String txtSellingPriceText = txtSellingPrice.getText();
        String txtSupplierText = txtSupplier.getText();
        String txtAddedDateText = txtAddedDate.getValue().toString();
        String txtDescriptionText = txtDescription.getText();
        String txtImagePathText = txtImagePath.getText();

        ProductDTO productDTO = null;
        try {
            Integer id = Integer.valueOf(txtIDText);
            String name = txtNameText;
            String category = txtCategoryText;
            String color = txtColorText;
            String size = txtSizeText;
            Integer qty = Integer.valueOf(txtQtyText);
            Double costPrice = Double.valueOf(txtCostPriceText);
            Double sellingPrice = Double.valueOf(txtSellingPriceText);
            Integer supplier = Integer.valueOf(txtSupplierText);
            LocalDate addedDate = LocalDate.parse(txtAddedDateText);
            String description = txtDescriptionText;
            String image = txtImagePathText;

            productDTO = new ProductDTO(
                    id, name, category, color, size,image,
                    qty, costPrice, sellingPrice, supplier,
                    addedDate, description
            );


        } catch (NumberFormatException e) {
            System.out.println("Number format error: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Date format error: " + e.getMessage());
        }
        Boolean saved = productService.save(productDTO);
        if (saved){
            new Alert(Alert.AlertType.INFORMATION, "Product Added ").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "Product not Added ").show();
        }


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

    public void btnUpdateProfile(ActionEvent actionEvent) {
        String adminIdText = adminId.getText();
        String adminNameText = adminName.getText();
        String adminPasswordText = adminPassword.getText();
        String confirmPasswordText = adminConfirmPassword.getText();

        if (adminIdText == null || adminIdText.isEmpty() ||
                adminNameText == null || adminNameText.isEmpty() ||
                adminPasswordText == null || adminPasswordText.isEmpty() ||
                confirmPasswordText == null || confirmPasswordText.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("All fields are required.");
            alert.showAndWait();

        } else {
            if (adminPasswordText.equals(confirmPasswordText)) {
                EmployeeDTO employeeDTO = new EmployeeDTO(Integer.valueOf(adminIdText), adminNameText, currentUser.getEmail(), confirmPasswordText, currentUser.getUser_type());
                employeeService.update(employeeDTO);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("EmployeeDTO updated successfully.");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Validation Error");
                alert.setHeaderText(null);
                alert.setContentText("Passwords do not match.");
                alert.showAndWait();
            }
        }


    }
}
