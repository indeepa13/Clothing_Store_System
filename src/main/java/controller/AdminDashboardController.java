package controller;


import db.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    @FXML
    private AnchorPane contentArea;

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
}
