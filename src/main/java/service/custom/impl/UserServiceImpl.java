package service.custom.impl;

import model.dto.EmployeeDTO;
import model.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDAO;
import service.custom.UserSerrvice;
import util.RepositoryType;

import java.sql.SQLException;

public class UserServiceImpl implements UserSerrvice {
    EmployeeDAO employeeDAO = DaoFactory.getInstance().getRepositoryType(RepositoryType.EMPLOYEE);

    @Override
    public EmployeeDTO loginUser(String username, String password) throws SQLException {
        EmployeeEntity employeeEntity = employeeDAO.searchById(username);
        EmployeeDTO employeeDTO = new ModelMapper().map(employeeEntity, EmployeeDTO.class);
        if (employeeDTO.getPassword().equals(password)){
            return employeeDTO;
        }
        return null;
    }
}
