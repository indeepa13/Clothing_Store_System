package service.custom;

import model.Employee;
import service.SuperService;

import java.util.List;

public interface EmployeeService extends SuperService {
    Boolean addEmployee(Employee employee);

    Boolean updateEmployee(Employee employee);

    Employee searchById(String id);

    List<Employee> getAll();
}
