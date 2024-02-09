package lk.ijse.gym.dao.Custom;

import lk.ijse.gym.dao.CrudDao;
import lk.ijse.gym.entity.PlaceOrder;
import lk.ijse.gym.entity.tm.PlaceOrderTm;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDao extends CrudDao<PlaceOrder, PlaceOrderTm,String> {
    String generateNextOrderId() throws SQLException;
    String splitOrderId(String currentOrderId);
    boolean saveOrder(String orderId, String memberId, LocalDate date) throws SQLException;

    }