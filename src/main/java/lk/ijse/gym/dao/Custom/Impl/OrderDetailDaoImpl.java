package lk.ijse.gym.dao.Custom.Impl;

import lk.ijse.gym.dao.Custom.OrderDetailDao;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.entity.tm.CartTm;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {

    public boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException {
        for(CartTm tm : cartTmList) {
            if(!saveOrderDetails(orderId, tm)) {
                return false;
            }
        }
        return true;
    }

    private boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException {
        String sql = "INSERT INTO order_detail VALUES(?, ?, ?, ?)";
        return SqlUtil.execute(sql,orderId,tm);
    }

    @Override
    public Object search(Object memberId) throws SQLException {
        return null;
    }

    @Override
    public boolean save(Object dto) throws SQLException {
        return false;
    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Object memberId) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Object dto) throws SQLException {
        return false;
    }
}
