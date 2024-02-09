package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;
import lk.ijse.gym.dto.EquipmentDto;
import lk.ijse.gym.entity.tm.EquipmentTm;

import java.sql.SQLException;
import java.util.List;

public interface EquipmentBo extends SuperBo {
    List<EquipmentTm> getAllEquipment() throws SQLException;
    boolean saveEquipment(EquipmentDto equipment) throws SQLException;
    boolean updateEquipment(EquipmentDto equipment) throws SQLException;
    boolean deleteEquipment(String equId) throws SQLException;
    EquipmentDto searchEquipment(String equipmentId) throws SQLException;

}
