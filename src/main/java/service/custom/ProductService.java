package service.custom;

import model.dto.ProductDTO;
import service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface ProductService extends SuperService {
    boolean save(ProductDTO dto);
    boolean update(ProductDTO dto);
    boolean deleteById(Integer id);
    ProductDTO searchById(Integer id) throws SQLException;
    List<ProductDTO> getAll();
    boolean add(ProductDTO dto);
}
