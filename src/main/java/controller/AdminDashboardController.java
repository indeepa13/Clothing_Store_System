package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import service.custom.ProductService;
import service.custom.impl.EmployeeServiceImpl;
import util.ServiceType;
import util.Session;
//import service.custom.impl.SupplierServiceImpl;

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
        try {
            Integer id = Integer.valueOf(txtID.getText());
            String name = txtName.getText();
            String category = txtCategory.getText();
            String color = txtColor.getText();
            String size = txtSize.getText();
            Integer qty = Integer.valueOf(txtQty.getText());
            Double costPrice = Double.valueOf(txtCostPrice.getText());
            Double sellingPrice = Double.valueOf(txtSellingPrice.getText());
            Integer supplier = Integer.valueOf(txtSupplier.getText());
            LocalDate addedDate = txtAddedDate.getValue();
            String description = txtDescription.getText();
            String image = txtImagePath.getText();

            ProductDTO dto = new ProductDTO(id, name, category, color, size, image, qty, costPrice, sellingPrice, supplier, addedDate, description);

            boolean updated = productService.update(dto);
            if (updated) {
                new Alert(Alert.AlertType.INFORMATION, "Product updated successfully").show();
                loadProducts();
            } else {
                new Alert(Alert.AlertType.ERROR, "Product update failed").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Invalid input: " + e.getMessage()).show();
        }
    }

    public void handleDeleteProduct(ActionEvent event) {
        try {
            Integer id = Integer.valueOf(txtID.getText());
            boolean deleted = productService.deleteById(id);
            if (deleted) {
                new Alert(Alert.AlertType.INFORMATION, "Product deleted successfully").show();
                loadProducts();
            } else {
                new Alert(Alert.AlertType.ERROR, "Product delete failed").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Invalid Product ID").show();
        }
    }

    private void loadProducts() {
    }

    public void handleClearForm(ActionEvent event) {
        txtID.clear();
        txtName.clear();
        txtCategory.clear();
        txtColor.clear();
        txtSize.clear();
        txtQty.clear();
        txtCostPrice.clear();
        txtSellingPrice.clear();
        txtSupplier.clear();
        txtAddedDate.setValue(null);
        txtDescription.clear();
        txtImagePath.clear();
    }


    // --- Supplier Management Placeholder Methods ---
//    public void handleAddSupplier(ActionEvent event) {
//        SupplierDTO dto = new SupplierDTO("SUP001", "ABC Traders", "ABC Pvt Ltd", "abc@gmail.com", "0771234567");
//        supplierService.save(dto);
//        new Alert(Alert.AlertType.INFORMATION, "Supplier added successfully").show();
//    }

//    public void handleAddSupplier(ActionEvent event) {
//        try {
//            Integer id = Integer.valueOf(supId.getText());
//            String name = supName.getText();
//            String company = supCompany.getText();
//            String email = supEmail.getText();
//            String contact = supContact.getText();
//
//            SupplierDTO dto = new SupplierDTO(id, name, company, email, contact);
//            boolean saved = supplierService.save(dto);
//
//            if (saved) {
//                new Alert(Alert.AlertType.INFORMATION, "Supplier added successfully").show();
//                loadSuppliers();
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Supplier not added").show();
//            }
//        } catch (Exception e) {
//            new Alert(Alert.AlertType.ERROR, "Invalid input").show();
//        }
//    }
//
//    public void handleUpdateSupplier(ActionEvent event) {
//        try {
//            Integer id = Integer.valueOf(supId.getText());
//            String name = supName.getText();
//            String company = supCompany.getText();
//            String email = supEmail.getText();
//            String contact = supContact.getText();
//
//            SupplierDTO dto = new SupplierDTO(id, name, company, email, contact);
//            boolean updated = supplierService.update(dto);
//
//            if (updated) {
//                new Alert(Alert.AlertType.INFORMATION, "Supplier updated successfully").show();
//                loadSuppliers();
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Supplier update failed").show();
//            }
//        } catch (Exception e) {
//            new Alert(Alert.AlertType.ERROR, "Invalid input").show();
//        }
//    }
//
//    public void handleDeleteSupplier(ActionEvent event) {
//        try {
//            Integer id = Integer.valueOf(supId.getText());
//            boolean deleted = supplierService.deleteById(id);
//
//            if (deleted) {
//                new Alert(Alert.AlertType.INFORMATION, "Supplier deleted successfully").show();
//                loadSuppliers();
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Supplier delete failed").show();
//            }
//        } catch (Exception e) {
//            new Alert(Alert.AlertType.ERROR, "Invalid Supplier ID").show();
//        }
//    }

    public void handleClearSupplierForm(ActionEvent event) {
        supId.clear();
        supName.clear();
        supCompany.clear();
        supEmail.clear();
        supContact.clear();
    }


    public void handleAddEmployee(ActionEvent event) {
        try {
            Integer id = Integer.valueOf(empId.getText());
            String name = empName.getText();
            String email = empEmail.getText();
            String password = empPassword.getText();
            String role = empRole.getText();

            EmployeeDTO dto = new EmployeeDTO(id, name, email, password, role);
            boolean saved = employeeService.save(dto);

            if (saved) {
                new Alert(Alert.AlertType.INFORMATION, "Employee added successfully").show();
                loadEmployees();
            } else {
                new Alert(Alert.AlertType.ERROR, "Employee not added").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Invalid input: " + e.getMessage()).show();
        }
    }

    public void handleUpdateEmployee(ActionEvent event) {
        try {
            Integer id = Integer.valueOf(empId.getText());
            String name = empName.getText();
            String email = empEmail.getText();
            String password = empPassword.getText();
            String role = empRole.getText();

            EmployeeDTO dto = new EmployeeDTO(id, name, email, password, role);
            boolean updated = employeeService.update(dto);

            if (updated) {
                new Alert(Alert.AlertType.INFORMATION, "Employee updated successfully").show();
                loadEmployees();
            } else {
                new Alert(Alert.AlertType.ERROR, "Employee update failed").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Invalid input").show();
        }
    }

    public void handleDeleteEmployee(ActionEvent event) {
        try {
            Integer id = Integer.valueOf(empId.getText());
            boolean deleted = employeeService.deleteById(id);

            if (deleted) {
                new Alert(Alert.AlertType.INFORMATION, "Employee deleted successfully").show();
                loadEmployees();
            } else {
                new Alert(Alert.AlertType.ERROR, "Employee delete failed").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Invalid Employee ID").show();
        }
    }

    private void loadEmployees() {

    }

    public void handleClearEmployeeForm(ActionEvent event) {
        empId.clear();
        empName.clear();
        empEmail.clear();
        empPassword.clear();
        empRole.clear();
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
