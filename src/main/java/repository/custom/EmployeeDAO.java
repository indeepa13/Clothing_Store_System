package repository.custom;

import model.entity.EmployeeDTO;
import repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<EmployeeDTO,Integer> {

//    void save(EmployeeEntity entity);
//    boolean update(EmployeeEntity entity);
//    boolean deleteById(String id);
//    List<EmployeeEntity> findAll();
    EmployeeDTO searchByUsername(String username);

}
