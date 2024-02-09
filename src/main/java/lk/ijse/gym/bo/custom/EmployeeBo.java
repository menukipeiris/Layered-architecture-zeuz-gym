package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;
import lk.ijse.gym.dto.EmployeeDto;
import lk.ijse.gym.entity.tm.EmployeeTm;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBo extends SuperBo {
    public List<EmployeeTm> getAllEmployees() throws SQLException;
    public boolean deleteEmployee(String trainerId) throws SQLException;
    public boolean saveEmployee(EmployeeDto employee) throws SQLException;
    public boolean updateEmployee(EmployeeDto employee) throws SQLException;
    public EmployeeDto searchEmployee(String trainerId) throws SQLException;







    }
