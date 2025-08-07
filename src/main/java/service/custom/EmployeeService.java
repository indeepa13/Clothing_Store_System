package service.custom;


import model.dto.EmployeeDTO;
import service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService extends SuperService {
//    Boolean addEmployee(Employee employee);
//
//    Boolean updateEmployee(Employee employee);
//
//    Employee searchById(String id);

    void save(EmployeeDTO dto);
    void update(EmployeeDTO dto);
    void delete(String id);
    List<EmployeeDTO> getAll();
}
