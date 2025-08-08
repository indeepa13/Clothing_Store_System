package service.custom;


import model.dto.EmployeeDTO;
import service.SuperService;

import java.util.List;

public interface EmployeeService extends SuperService {
//    Boolean addEmployee(Employee employee);
//
//    Boolean updateEmployee(Employee employee);
//
    EmployeeDTO searchById(Integer id);
    Boolean save(EmployeeDTO dto);
    void update(EmployeeDTO dto);
    void delete(Integer id);
    List<EmployeeDTO> getAll();
    EmployeeDTO searchByUsername(String username);
}
