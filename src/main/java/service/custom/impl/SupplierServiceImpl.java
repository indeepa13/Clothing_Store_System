//package service.custom.impl;
//
//import model.dto.SupplierDTO;
//import model.entity.SupplierEntity;
//import org.modelmapper.ModelMapper;
//import repository.DaoFactory;
//import repository.RepositoryType;
//import repository.custom.SupplierDAO;
//import service.custom.SupplierService;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class SupplierServiceImpl implements SupplierService {
//
//    private final SupplierDAO supplierDAO = DaoFactory.getInstance().getRepositoryType(RepositoryType.SUPPLIER);
//    private final ModelMapper mapper = new ModelMapper();
//
//    @Override
//    public boolean save(SupplierDTO dto) {
//        return supplierDAO.add(mapper.map(dto, SupplierEntity.class));
//    }
//
//    @Override
//    public boolean update(SupplierDTO dto) {
//        return supplierDAO.update(mapper.map(dto, SupplierEntity.class));
//    }
//
//    @Override
//    public boolean deleteById(Integer id) {
//        return supplierDAO.deleteById(id);
//    }
//
//    @Override
//    public SupplierDTO searchById(Integer id) {
//        SupplierEntity entity = supplierDAO.searchById(id);
//        return entity != null ? mapper.map(entity, SupplierDTO.class) : null;
//    }
//
//    @Override
//    public List<SupplierDTO> getAll() {
//        return supplierDAO.getAll()
//                .stream()
//                .map(entity -> mapper.map(entity, SupplierDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public boolean add(SupplierDTO dto) {
//        return false;
//    }
//}
