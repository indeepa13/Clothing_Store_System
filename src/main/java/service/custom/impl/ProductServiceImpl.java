package service.custom.impl;

import model.dto.ProductDTO;
import model.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.ProductDAO;
import service.custom.ProductService;
import util.RepositoryType;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO = DaoFactory.getInstance().getRepositoryType(RepositoryType.PRODUCT);
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<ProductDTO> getAll() {
        return productDAO.getAll().stream()
                .map(entity -> mapper.map(entity, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(ProductDTO dto) {
        productDAO.add(mapper.map(dto, ProductEntity.class));
    }

    @Override
    public void update(ProductDTO dto) {
        productDAO.update(mapper.map(dto, ProductEntity.class));
    }


    @Override
    public void delete(String id) {
        productDAO.deleteById(id);
    }
}
