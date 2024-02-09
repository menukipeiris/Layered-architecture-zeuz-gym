package lk.ijse.gym.dao.Custom.Impl;

import lk.ijse.gym.dao.Custom.EmployeeDao;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.entity.Employee;
import lk.ijse.gym.entity.tm.EmployeeTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    public List<EmployeeTm> getAll() throws SQLException{

        String sql="SELECT * FROM employee";
        ResultSet resultSet= SqlUtil.execute(sql);

        ArrayList<EmployeeTm>dtoList=new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new EmployeeTm(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
            )
            );
        }
        return  dtoList;
    }

    public boolean delete(String trainerId) throws SQLException {
        String sql="DELETE FROM employee WHERE trainerId=?";
        return SqlUtil.execute(sql,trainerId);
    }


    public boolean save(Employee employee) throws SQLException{
        String sql="INSERT INTO employee VALUES(?,?,?,?,?,?)";
        return SqlUtil.execute(sql,employee.getTrainerId(),employee.getName(),employee.getContactNu(),employee.getAddress(),employee.getRole(),employee.getAvailability());
    }

    public boolean update(Employee employee) throws SQLException {
        String sql="UPDATE employee set name=?,contactNu=?,address=?,role=?,availability=? WHERE trainerId=?";
       return SqlUtil.execute(sql,employee.getName(),employee.getContactNu(),employee.getAddress(),employee.getRole(),employee.getAvailability(),employee.getTrainerId());
    }

    public Employee search(String trainerId) throws SQLException {
        String sql="SELECT * FROM employee WHERE trainerId=?";
        ResultSet resultSet =SqlUtil.execute(sql,trainerId);

       Employee dto=null;

       if(resultSet.next()){
           String trainerid=resultSet.getString(1);
           String name=resultSet.getString(2);
           String contact=resultSet.getString(3);
           String address=resultSet.getString(4);
           String role=resultSet.getString(5);
           String availability=resultSet.getString(6);

           dto=new Employee(trainerid,name,contact,address,role,availability);
       }
       return dto;
    }




}
