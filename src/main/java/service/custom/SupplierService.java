package service.custom;

import model.dto.SupplierDTO;
import service.SuperService;

import java.util.List;

public interface SupplierService extends SuperService {
    boolean save(SupplierDTO dto);
    boolean update(SupplierDTO dto);
    boolean deleteById(Integer id);
    SupplierDTO searchById(Integer id);
    List<SupplierDTO> getAll();
    boolean add(SupplierDTO dto);
}
