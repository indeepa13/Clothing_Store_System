package service.custom;

import model.dto.EmployeeDTO;
import service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService extends SuperService {
    boolean save(EmployeeDTO dto);
    boolean update(EmployeeDTO dto);
    boolean deleteById(Integer id);
    EmployeeDTO searchById(Integer id) throws SQLException;
    List<EmployeeDTO> getAll();

    EmployeeDTO searchByUsername(String email);
}
