package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.bo.custom.PlaceOrderBo;
import lk.ijse.gym.dao.Custom.PlaceOrderDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.entity.PlaceOrder;

import java.sql.SQLException;

public class PlaceOrderBoImpl implements PlaceOrderBo {

    PlaceOrderDao placeOrderDao= (PlaceOrderDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.PLACEORDER);
    @Override
    public boolean placeOrder(PlaceOrder placeOrder) throws SQLException {
        return placeOrderDao.placeOrder(placeOrder);
    }
}
