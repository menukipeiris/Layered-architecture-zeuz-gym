package lk.ijse.gym.dao.Custom.Impl;

import lk.ijse.gym.dao.Custom.OrderDao;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.entity.PlaceOrder;
import lk.ijse.gym.entity.tm.PlaceOrderTm;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    public String generateNextOrderId() throws SQLException {
        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
        ResultSet resultSet = SqlUtil.execute(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    public   String splitOrderId(String currentOrderId) {
     if(currentOrderId != null) {
        String[] split = currentOrderId.split("O0");

        int id = Integer.parseInt(split[1]); //01
        id++;
        return "O00" + id;
    } else {
        return "O001";
    }
}

    public boolean saveOrder(String orderId, String memberId, LocalDate date) throws SQLException {
        String sql = "INSERT INTO orders VALUES(?, ?, ?)";
        return SqlUtil.execute(sql,orderId,memberId,date);
    }


    @Override
    public PlaceOrder search(String memberId) throws SQLException {
        return null;
    }

    @Override
    public boolean save(PlaceOrder dto) throws SQLException {
        return false;
    }

    @Override
    public List<PlaceOrderTm> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String memberId) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PlaceOrder dto) throws SQLException {
        return false;
    }
}
