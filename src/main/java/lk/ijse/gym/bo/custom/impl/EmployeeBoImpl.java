package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.dao.Custom.EmployeeDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.bo.custom.EmployeeBo;
import lk.ijse.gym.dto.EmployeeDto;
import lk.ijse.gym.entity.Employee;
import lk.ijse.gym.entity.tm.EmployeeTm;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {
    EmployeeDao employeeDao= (EmployeeDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public List <EmployeeTm>getAllEmployees() throws SQLException {
        return employeeDao.getAll();
    }

    @Override
    public boolean deleteEmployee(String trainerId) throws SQLException {
        return employeeDao.delete(trainerId);
    }

    @Override
    public boolean saveEmployee(EmployeeDto employeeDto) throws SQLException {
        Employee employee=new Employee(employeeDto.getTrainerId(),employeeDto.getName(),employeeDto.getContactNu(),employeeDto.getAddress(),employeeDto.getRole(),employeeDto.getAvailability());
        return employeeDao.save(employee);
    }

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) throws SQLException {
        Employee employee=new Employee(employeeDto.getTrainerId(),employeeDto.getName(),employeeDto.getContactNu(),employeeDto.getAddress(),employeeDto.getRole(),employeeDto.getAvailability());
        return employeeDao.update(employee);
    }

    @Override
    public EmployeeDto searchEmployee(String trainerId) throws SQLException {
        Employee employee= employeeDao.search(trainerId);
        return new EmployeeDto(employee.getTrainerId(),employee.getName(),employee.getContactNu(), employee.getAddress(),employee.getRole(),employee.getAvailability());

    }
}
