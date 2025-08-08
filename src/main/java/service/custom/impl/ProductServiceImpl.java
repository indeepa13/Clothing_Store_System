package service.custom.impl;

import model.dto.ProductDTO;
import model.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;

import repository.custom.ProductDAO;
import service.custom.ProductService;
import util.RepositoryType;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO = DaoFactory.getInstance().getRepositoryType(util.RepositoryType.PRODUCT);
    ModelMapper mapper = new ModelMapper();

    @Override
    public boolean save(ProductDTO dto) {
        return productDAO.add(mapper.map(dto, ProductEntity.class));
    }

    @Override
    public boolean update(ProductDTO dto) {
        return productDAO.update(mapper.map(dto, ProductEntity.class));
    }

    @Override
    public boolean deleteById(Integer id) {
        return productDAO.deleteById(id);
    }

    @Override
    public ProductDTO searchById(Integer id) throws SQLException {
        ProductEntity entity = productDAO.searchById(id);
        return entity != null ? mapper.map(entity, ProductDTO.class) : null;
    }

    @Override
    public List<ProductDTO> getAll() {
        return productDAO.getAll().stream()
                .map(entity -> mapper.map(entity, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(ProductDTO dto) {
        return false;
    }

}

