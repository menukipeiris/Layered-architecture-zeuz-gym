package lk.ijse.gym.dao.Custom;

import lk.ijse.gym.dao.CrudDao;
import lk.ijse.gym.entity.PlaceOrder;
import lk.ijse.gym.entity.tm.PlaceOrderTm;

import java.sql.SQLException;

public interface PlaceOrderDao extends CrudDao<PlaceOrder,PlaceOrderTm,String> {
    boolean placeOrder(PlaceOrder placeOrder) throws SQLException;
}
