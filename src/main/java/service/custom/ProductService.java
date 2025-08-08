package service.custom;

import model.dto.ProductDTO;
import model.dto.ProductDTO;
import service.SuperService;

import java.util.List;

public interface ProductService extends SuperService {
    List<ProductDTO> getAll();

  public   void save(ProductDTO product);

    void update(ProductDTO selected);



    void delete(String id);
}
