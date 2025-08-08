package repository.custom;

import model.entity.EmployeeDTO;
import repository.CrudRepository;

public interface UserDAO extends CrudRepository<EmployeeDTO,String> {
}
