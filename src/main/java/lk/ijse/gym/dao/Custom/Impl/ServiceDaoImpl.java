package lk.ijse.gym.dao.Custom.Impl;


import lk.ijse.gym.dao.Custom.ServiceDao;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.entity.Service;
import lk.ijse.gym.entity.tm.ServiceTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl implements ServiceDao {

    public List<ServiceTm> getAll() throws SQLException {
        String sql="SELECT * FROM service";
        ResultSet resultSet= SqlUtil.execute(sql);

        ArrayList<ServiceTm>dtoList=new ArrayList<>();

        while (resultSet.next()){
            dtoList.add(
                    new ServiceTm(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return dtoList;
    }

    public boolean delete(String serviceId) throws SQLException {
        String sql="DELETE FROM service WHERE serviceId=?";
        return SqlUtil.execute(sql,serviceId);
    }

    public boolean save(Service service) throws SQLException {
        String sql="INSERT INTO service VALUES(?,?,?,?,?,?)";
        return SqlUtil.execute(sql,service.getServiceId(),service.getTrainerId(),service.getTrainerName(),service.getClassType(),service.getTime(),service.getDate());
    }

    public boolean update(Service service) throws SQLException {
        String sql="UPDATE service set trainerId=?,trainerName=?,classType=?,time=?,date=? WHERE serviceId=?";
        return SqlUtil.execute(sql,service.getTrainerId(),service.getTrainerName(),service.getClassType(),service.getTime(),service.getDate(),service.getServiceId());

    }

    public Service search(String serviceId) throws SQLException {
        String sql="SELECT * FROM service WHERE serviceId=?";
        ResultSet resultSet=SqlUtil.execute(sql,serviceId);

        Service dto=null;
        if(resultSet.next()){
            String service_Id=resultSet.getString(1);
            String trainerId=resultSet.getString(2);
            String trainerName=resultSet.getString(3);
            String classType=resultSet.getString(4);
            String time=resultSet.getString(5);
            String date=resultSet.getString(6);

            dto=new Service(service_Id,trainerId,trainerName,classType,time,date);
        }
        return dto;
    }
}
