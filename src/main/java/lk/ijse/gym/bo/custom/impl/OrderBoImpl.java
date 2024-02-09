package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.bo.custom.OrderBo;
import lk.ijse.gym.dao.Custom.OrderDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.dao.SqlUtil;

import java.sql.SQLException;

public class OrderBoImpl implements OrderBo {

    OrderDao orderDao= (OrderDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ORDER);

    @Override
    public String generateNextOrderId() throws SQLException {
        return orderDao.generateNextOrderId();
    }
}
