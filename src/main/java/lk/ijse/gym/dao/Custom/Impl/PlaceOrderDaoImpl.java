package lk.ijse.gym.dao.Custom.Impl;

import lk.ijse.gym.dao.Custom.OrderDao;
import lk.ijse.gym.dao.Custom.PlaceOrderDao;
import lk.ijse.gym.dao.Custom.SupplimentDao;
import lk.ijse.gym.db.DbConnection;
import lk.ijse.gym.entity.PlaceOrder;
import lk.ijse.gym.entity.Suppliment;
import lk.ijse.gym.entity.tm.PlaceOrderTm;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class PlaceOrderDaoImpl implements PlaceOrderDao {

    private OrderDao orderDao = new OrderDaoImpl();
    private SupplimentDao supplimentDao = new SupplimentDaoImpl();
    private OrderDetailDaoImpl orderDetailModel = new OrderDetailDaoImpl();


    public boolean placeOrder(PlaceOrder placeOrder) throws SQLException {
        System.out.println(placeOrder);

        String orderId = placeOrder.getOrderId();
        String memberId = placeOrder.getMemberId();
        LocalDate date = placeOrder.getDate();

        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved =orderDao.saveOrder(orderId, memberId, date);
            if (isOrderSaved) {
                boolean isUpdated = supplimentDao.update((Suppliment) placeOrder.getCartTmList());
                if(isUpdated) {
                    boolean isOrderDetailSaved = orderDetailModel.saveOrderDetails(placeOrder.getOrderId(), placeOrder.getCartTmList());
                    if (isOrderDetailSaved) {
                        connection.commit();
                    }
                }
            }
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }

        return true;
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

