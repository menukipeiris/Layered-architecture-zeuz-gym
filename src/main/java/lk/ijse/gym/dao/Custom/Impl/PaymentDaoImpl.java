package lk.ijse.gym.dao.Custom.Impl;

import lk.ijse.gym.dao.Custom.PaymentDao;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.db.DbConnection;
import lk.ijse.gym.entity.Payment;
import lk.ijse.gym.entity.tm.PaymentTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {
    public Payment search(String paymentId) throws SQLException {
        String sql="SELECT * FROM payment WHERE paymentId=?";

        ResultSet resultSet= SqlUtil.execute(sql,paymentId);

        Payment dto=null;

        if(resultSet.next()){
            String PaymentId=resultSet.getString(1);
            String memId=resultSet.getString(2);
            String memName=resultSet.getString(3);
            String plan=resultSet.getString(4);
            double amountPaid= resultSet.getDouble(5);
            String date=resultSet.getString(6);

            dto=new Payment(PaymentId,memId,memName,plan,amountPaid,date);
        }
       return dto;
    }
    public boolean save(Payment payment) throws SQLException {
        String sql = "INSERT INTO payment VALUES (?,?,?,?,?,?)";
         return SqlUtil.execute(sql,payment.getPaymentId(),payment.getMemberId(),payment.getName(),payment.getPlan(),payment.getAmountPaid(),payment.getDate());
    }

    public List<PaymentTm> getAll() throws SQLException {
        Connection connection=DbConnection.getInstance().getConnection();

        String sql="SELECT * FROM payment";
        PreparedStatement pstm=connection.prepareStatement(sql);
        ResultSet resultSet=pstm.executeQuery();

        ArrayList<PaymentTm>dtoList=new ArrayList<>();

        while (resultSet.next()){
            dtoList.add(
                    new PaymentTm(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getString(6)

                    )
            );
        }
        return dtoList;
    }

    public  boolean delete(String paymentId) throws SQLException {
        String sql="DELETE FROM payment WHERE  paymentId=? ";
        return SqlUtil.execute(sql,paymentId);
    }

    public  boolean update(Payment payment) throws SQLException {
        String sql="UPDATE payment set memberId=?,name=?,plan=?,amountPaid=?,date=? WHERE paymentId=?";
        return SqlUtil.execute(sql,payment.getMemberId(),payment.getName(),payment.getPlan(),payment.getAmountPaid(),payment.getDate(),payment.getPaymentId());


    }

}

