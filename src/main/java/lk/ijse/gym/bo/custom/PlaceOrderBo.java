package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;
import lk.ijse.gym.entity.PlaceOrder;

import java.sql.SQLException;

public interface PlaceOrderBo extends SuperBo {
    boolean placeOrder(PlaceOrder placeOrder) throws SQLException;
}
