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

    EmployeeDTO loginUser(String username, String password) throws SQLException;

    List<EmployeeDTO> getAll();

    Boolean add(EmployeeDTO employee);
}
