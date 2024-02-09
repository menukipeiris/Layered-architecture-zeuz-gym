package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;

import java.sql.SQLException;

public interface OrderBo extends SuperBo {

    String generateNextOrderId() throws SQLException;


}
