package repository;

import model.dto.EmployeeDTO;

public interface SuperRepository {
    interface UserDAO extends CrudRepository<EmployeeDTO,String> {
    }
}
