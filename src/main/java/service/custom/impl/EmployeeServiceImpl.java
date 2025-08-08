package service.custom.impl;

import model.dto.EmployeeDTO;
import model.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import repository.custom.EmployeeDAO;
import repository.custom.impl.EmployeeRepositoryImpl;
import repository.custom.impl.EmployeeRepositoryImpl;
import service.custom.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeRepositoryImpl();
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public void save(EmployeeDTO dto) {
        employeeDAO.save(mapper.map(dto, EmployeeEntity.class));
    }

    @Override
    public void update(EmployeeDTO dto) {
        employeeDAO.update(mapper.map(dto, EmployeeEntity.class));
    }

    @Override
    public void delete(String id) {
        employeeDAO.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return employeeDAO.findAll().stream()
                .map(entity -> mapper.map(entity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}