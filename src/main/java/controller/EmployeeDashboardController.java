package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeeDashboardController {

    @FXML
    private ComboBox cmbCustomerId;

    @FXML
    private ComboBox cmbItemCode;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colSize;

    @FXML
    private TableColumn colTotal;

    @FXML
    private TableColumn colUnitPrice;

    @FXML
    private Label lbkNetTotal;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTIme;

    @FXML
    private TableView tblCart;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtStock;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnGetCustomerReportOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

}
