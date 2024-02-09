package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.dao.Custom.SupplimentDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.bo.custom.SupplimentBo;
import lk.ijse.gym.dto.SupplimentDto;
import lk.ijse.gym.entity.Suppliment;
import lk.ijse.gym.entity.tm.CartTm;
import lk.ijse.gym.entity.tm.SupplimentTm;

import java.sql.SQLException;
import java.util.List;

public class SupplimentBoImpl implements SupplimentBo {
    SupplimentDao supplimentDao= (SupplimentDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.SUPPLIMENT);


    @Override
    public List<SupplimentTm> getAllItems() throws SQLException {
        return supplimentDao.getAll();
    }

    @Override
    public boolean saveItems(SupplimentDto supplimentDto) throws SQLException {
        Suppliment suppliment=new Suppliment(supplimentDto.getCode(),supplimentDto.getDescription(),supplimentDto.getUnitPrice(),supplimentDto.getQtyOnHand());
        return supplimentDao.save(suppliment);
    }

    @Override
    public boolean updateItems(SupplimentDto supplimentDto) throws SQLException {
        Suppliment suppliment=new Suppliment(supplimentDto.getCode(),supplimentDto.getDescription(),supplimentDto.getUnitPrice(),supplimentDto.getQtyOnHand());
        return supplimentDao.update(suppliment);
    }

    @Override
    public boolean update(List<CartTm> cartTmList) throws SQLException {
        return false;
    }

    @Override
    public SupplimentDto searchItems(String code) throws SQLException {
        Suppliment suppliment=supplimentDao.search(code);
        return new SupplimentDto(suppliment.getCode(),suppliment.getDescription(),suppliment.getUnitPrice(),suppliment.getQtyOnHand());
    }

    @Override
    public boolean deleteItems(String code) throws SQLException {
        return supplimentDao.delete(code);
    }

    @Override
    public boolean update(String code, int qty) throws SQLException {
        return false;
    }

    @Override
    public List<SupplimentDto> loadAllItem() throws SQLException {
        return supplimentDao.loadAllItem();
    }
}
