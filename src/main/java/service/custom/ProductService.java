package service.custom;

import model.dto.Product;
import service.SuperService;

import java.util.List;

public interface ProductService extends SuperService {
    List<Product> getAll();

  public   void save(Product product);

    void update(Product selected);

    void delete(Product selected);
}
