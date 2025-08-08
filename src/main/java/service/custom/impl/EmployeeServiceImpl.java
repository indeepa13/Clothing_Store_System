package service.custom.impl;

import model.dto.EmployeeDTO;
import model.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
//import repository.RepositoryType;
import repository.custom.EmployeeDAO;
import service.custom.EmployeeService;
import util.RepositoryType;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO = DaoFactory.getInstance().getRepositoryType(util.RepositoryType.EMPLOYEE);
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public boolean save(EmployeeDTO dto) {
        return employeeDAO.add(mapper.map(dto, EmployeeEntity.class));
    }

    @Override
    public boolean update(EmployeeDTO dto) {
        return employeeDAO.update(mapper.map(dto, EmployeeEntity.class));
    }

    @Override
    public boolean deleteById(Integer id) {
        return employeeDAO.deleteById(id);
    }

    @Override
    public EmployeeDTO searchById(Integer id) throws SQLException {
        EmployeeEntity entity = employeeDAO.searchById(id);
        return entity != null ? mapper.map(entity, EmployeeDTO.class) : null;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return employeeDAO.getAll()
                .stream()
                .map(entity -> mapper.map(entity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO searchByUsername(String email) {
        return null;
    }
}
