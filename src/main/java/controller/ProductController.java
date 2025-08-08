package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.ProductDTO;
import service.custom.ProductService;

import java.util.List;

public class ProductController {
    @FXML
    private TableView<ProductDTO> tblProducts;
    @FXML
    private TableColumn<ProductDTO, Integer> colId;
    @FXML
    private TableColumn<ProductDTO, String> colName;
    @FXML
    private TableColumn<ProductDTO, Double> colPrice;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;

    private ProductService productService = new ProductService() {
        @Override
        public List<ProductDTO> getAll() {
            return List.of();
        }

        @Override
        public void save(ProductDTO product) {

        }

        @Override
        public void update(ProductDTO selected) {

        }

        @Override
        public void delete(String id) {

        }


    };

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        loadProducts();
    }

    private void loadProducts() {
        List<ProductDTO> products = productService.getAll();
        tblProducts.setItems(FXCollections.observableArrayList(products));
    }

    @FXML
    private void addProduct() {
        ProductDTO product = new ProductDTO();
        product.setName(txtName.getText());
        product.setPrice(String.valueOf(Double.parseDouble(txtPrice.getText())));
        productService.save(product);
        loadProducts();
    }

    @FXML
    private void updateProduct() {
        ProductDTO selected = tblProducts.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setName(txtName.getText());
            selected.setPrice(String.valueOf(Double.parseDouble(txtPrice.getText())));
            productService.update(selected);
            loadProducts();
        }
    }

    @FXML
    private void deleteProduct() {
        ProductDTO selected = tblProducts.getSelectionModel().getSelectedItem();
        if (selected != null) {
            productService.delete(String.valueOf(selected.getId()));
            tblProducts.getItems().remove(selected);
            txtName.clear();
            txtPrice.clear();
        } else {
            // Handle case where no product is selected
            System.out.println("No product selected for deletion.");
        }
            loadProducts();
        }
    }

