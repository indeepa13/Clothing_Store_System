package service.custom;

import model.dto.ProductDTO;
import service.SuperService;

import java.util.List;

public interface ProductService extends SuperService {
    List<ProductDTO> getAll();

  public Boolean save(ProductDTO product);

    void update(ProductDTO selected);



    void delete(Integer id);
}
