package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;
import lk.ijse.gym.dto.ServiceDto;
import lk.ijse.gym.entity.Service;
import lk.ijse.gym.entity.tm.ServiceTm;

import java.sql.SQLException;
import java.util.List;

public interface ServiceBo extends SuperBo {
    List<ServiceTm> getAllService() throws SQLException;
    boolean deleteService(String serviceId) throws SQLException;
    boolean saveService(ServiceDto dto) throws SQLException;
    boolean updateService(ServiceDto dto) throws SQLException;
    ServiceDto searchService(String serviceId) throws SQLException;
}
