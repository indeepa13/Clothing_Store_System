package repository.custom;

import model.entity.EmployeeEntity;
import repository.CrudRepository;

import java.util.List;

public interface EmployeeDAO extends CrudRepository<EmployeeEntity,String> {

    void save(EmployeeEntity entity);
    boolean update(EmployeeEntity entity);
    boolean deleteById(String id);
    List<EmployeeEntity> findAll();

}
