package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.dao.Custom.EquipmentDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.bo.custom.EquipmentBo;
import lk.ijse.gym.dto.EquipmentDto;
import lk.ijse.gym.entity.Equipment;
import lk.ijse.gym.entity.tm.EquipmentTm;

import java.sql.SQLException;
import java.util.List;

public class EquipmentBoImpl implements EquipmentBo {
EquipmentDao equipmentDao= (EquipmentDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.EQUIPMENT);


    @Override
    public List<EquipmentTm> getAllEquipment() throws SQLException {
     return equipmentDao.getAll();

    }

    @Override
    public boolean saveEquipment(EquipmentDto equipmentDto) throws SQLException {
        Equipment equipment=new Equipment(equipmentDto.getEquipmentId(),equipmentDto.getEquName(),equipmentDto.getDeliveryDate(),equipmentDto.getDescription(),equipmentDto.getCost(),equipmentDto.getMuscleUsed());
        return equipmentDao.save(equipment);
    }

    @Override
    public boolean updateEquipment(EquipmentDto equipmentDto) throws SQLException {
        Equipment equipment=new Equipment(equipmentDto.getEquipmentId(),equipmentDto.getEquName(),equipmentDto.getDeliveryDate(),equipmentDto.getDescription(),equipmentDto.getCost(),equipmentDto.getMuscleUsed());
        return equipmentDao.update(equipment);
    }

    @Override
    public boolean deleteEquipment(String equId) throws SQLException {
        return equipmentDao.delete(equId);
    }

    @Override
    public EquipmentDto searchEquipment(String equipmentId) throws SQLException {
        Equipment equipment=equipmentDao.search(equipmentId);
        return new EquipmentDto(equipment.getEquipmentId(),equipment.getEquName(),equipment.getDeliveryDate(),equipment.getDescription(),equipment.getCost(),equipment.getMuscleUsed());
    }
}
