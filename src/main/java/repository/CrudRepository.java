package repository;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T,ID> extends SuperRepository{
    boolean add(T entity);
    boolean save(T entity);
    boolean update(T entity);
    boolean deleteById(ID id);
    T searchById(Integer id) throws SQLException;
    List<T> getAll();
}
