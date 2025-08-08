package service.custom.impl;

import model.entity.EmployeeDTO;
import org.modelmapper.ModelMapper;
import repository.custom.EmployeeDAO;
import repository.custom.impl.EmployeeRepositoryImpl;
import service.custom.EmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeRepositoryImpl();
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public model.dto.EmployeeDTO searchById(Integer id) {
        try {
            return mapper.map(employeeDAO.searchById(id), model.dto.EmployeeDTO.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Boolean save(model.dto.EmployeeDTO dto) {
        return employeeDAO.save(mapper.map(dto, EmployeeDTO.class));
    }

    @Override
    public void update(model.dto.EmployeeDTO dto) {
        employeeDAO.update(mapper.map(dto, EmployeeDTO.class));
    }

    @Override
    public void delete(Integer id) {
        employeeDAO.deleteById(id);
    }

    @Override
    public List<model.dto.EmployeeDTO> getAll() {
        return employeeDAO.getAll().stream()
                .map(entity -> mapper.map(entity, model.dto.EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public model.dto.EmployeeDTO searchByUsername(String username) {
        return mapper.map(employeeDAO.searchByUsername(username), model.dto.EmployeeDTO.class);
    }
}