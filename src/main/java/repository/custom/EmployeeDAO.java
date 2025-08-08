package repository.custom;

import model.entity.EmployeeEntity;
//import repository.CrudDAO;
import repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<EmployeeEntity, Integer> {

    // Any custom Employee queries can be added here
}
