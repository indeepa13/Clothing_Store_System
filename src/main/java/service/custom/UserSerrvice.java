package service.custom;

import model.dto.EmployeeDTO;

import java.sql.SQLException;

public interface UserSerrvice  {

    EmployeeDTO loginUser(String username, String password) throws SQLException;
}
