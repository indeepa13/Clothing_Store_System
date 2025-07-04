//package controller;
//
//import javafx.collections.FXCollections;
//import javafx.fxml.FXML;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import model.dto.Product;
//import service.custom.ProductService;
//
//import java.util.List;
//
//public class ProductController {
//    @FXML
//    private TableView<Product> tblProducts;
//    @FXML
//    private TableColumn<Product, Integer> colId;
//    @FXML
//    private TableColumn<Product, String> colName;
//    @FXML
//    private TableColumn<Product, Double> colPrice;
//
//    @FXML
//    private TextField txtName;
//    @FXML
//    private TextField txtPrice;
//
//    private ProductService productService = new ProductService() {
//        @Override
//        public List<Product> getAll() {
//            return List.of();
//        }
//
//        @Override
//        public void save(Product product) {
//
//        }
//
//        @Override
//        public void update(Product selected) {
//
//        }
//
//        @Override
//        public void delete(Product selected) {
//
//        }
//    };
//
//    public void initialize() {
//        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//        loadProducts();
//    }
//
//    private void loadProducts() {
//        List<Product> products = productService.getAll();
//        tblProducts.setItems(FXCollections.observableArrayList(products));
//    }
//
//    @FXML
//    private void addProduct() {
//        Product product = new Product();
//        product.setName(txtName.getText());
//        product.setPrice(Double.parseDouble(txtPrice.getText()));
//        productService.save(product);
//        loadProducts();
//    }
//
//    @FXML
//    private void updateProduct() {
//        Product selected = tblProducts.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            selected.setName(txtName.getText());
//            selected.setPrice(Double.parseDouble(txtPrice.getText()));
//            productService.update(selected);
//            loadProducts();
//        }
//    }
//
//    @FXML
//    private void deleteProduct() {
//        Product selected = tblProducts.getSelectionModel().getSelectedItem();
//        if (selected != null) {
//            productService.delete(selected);
//            loadProducts();
//        }
//    }
//
//}
