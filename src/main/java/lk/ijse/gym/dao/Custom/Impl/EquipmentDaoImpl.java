package lk.ijse.gym.dao.Custom.Impl;

import lk.ijse.gym.dao.Custom.EquipmentDao;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.entity.Equipment;
import lk.ijse.gym.entity.tm.EquipmentTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDaoImpl implements EquipmentDao {

    public List<EquipmentTm> getAll() throws SQLException {
        String sql="SELECT * FROM equipment";
        ResultSet resultSet= SqlUtil.execute(sql);

        ArrayList<EquipmentTm> dtoList=new ArrayList<>();
        while (resultSet.next()) {
            dtoList.add(
                    new EquipmentTm(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getString(6)
                    )
            );
        }
           return dtoList;
    }

    public boolean save(Equipment equipment) throws SQLException {
        String sql = "INSERT INTO equipment VALUES (?,?,?,?,?,?)";
      return SqlUtil.execute(sql,equipment.getEquipmentId(),equipment.getEquName(),equipment.getDeliveryDate(),equipment.getDescription(),equipment.getCost(),equipment.getMuscleUsed());
    }

    public boolean update(Equipment equipment) throws SQLException {
        String sql="UPDATE equipment set equName=?,deliveryDate=?,description=?,cost=?,muscleUsed=? WHERE equipmentId=?";
        return SqlUtil.execute(sql,equipment.getEquName(),equipment.getDeliveryDate(),equipment.getDescription(),equipment.getCost(),equipment.getMuscleUsed(),equipment.getEquipmentId());
    }

    public boolean delete(String equId) throws SQLException {
        String sql= "DELETE  FROM equipment WHERE equipmentId=?";
        return SqlUtil.execute(sql,equId);

    }


    public Equipment search(String equipmentId) throws SQLException {
        String sql="SELECT * FROM equipment WHERE equipmentId=?";
        ResultSet resultSet= SqlUtil.execute(sql,equipmentId);

        Equipment dto=null;

        if(resultSet.next()){
            String equipmetId=resultSet.getString(1);
            String equName=resultSet.getString(2);
            String deliveryDate=resultSet.getString(3);
            String description=resultSet.getString(4);
            double cost= resultSet.getDouble(5);
            String muscleUsed=resultSet.getString(6);

            dto=new Equipment(equipmetId,equName,deliveryDate,description,cost,muscleUsed);
        }
        return dto;
    }


}



