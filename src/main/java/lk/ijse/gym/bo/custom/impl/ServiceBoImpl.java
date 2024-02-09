package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.dao.Custom.ServiceDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.bo.custom.ServiceBo;
import lk.ijse.gym.dto.ServiceDto;
import lk.ijse.gym.entity.Service;
import lk.ijse.gym.entity.tm.ServiceTm;

import java.sql.SQLException;
import java.util.List;

public class ServiceBoImpl implements ServiceBo {
    ServiceDao serviceDao= (ServiceDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.SERVICE);

    @Override
    public List<ServiceTm> getAllService() throws SQLException {
        return serviceDao.getAll();
    }

    @Override
    public boolean deleteService(String serviceId) throws SQLException {
        return serviceDao.delete(serviceId);
    }

    @Override
    public boolean saveService(ServiceDto serviceDto) throws SQLException {
        Service service=new Service(serviceDto.getServiceId(),serviceDto.getTrainerId(),serviceDto.getTrainerName(),serviceDto.getClassType(),serviceDto.getTime(),serviceDto.getDate());
        return serviceDao.save(service);
    }

    @Override
    public boolean updateService(ServiceDto serviceDto) throws SQLException {
        Service service=new Service(serviceDto.getServiceId(),serviceDto.getTrainerId(),serviceDto.getTrainerName(),serviceDto.getClassType(),serviceDto.getTime(),serviceDto.getDate());
        return serviceDao.update(service);

    }

    @Override
    public ServiceDto searchService(String serviceId) throws SQLException {
        Service service=serviceDao.search(serviceId);
        return new ServiceDto(service.getServiceId(),service.getTrainerId(),service.getTrainerName(),service.getClassType(),service.getTime(),service.getDate());
    }
}
