package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;
import lk.ijse.gym.dto.PaymentDto;
import lk.ijse.gym.entity.tm.PaymentTm;

import java.sql.SQLException;
import java.util.List;

public interface PaymentBo extends SuperBo {
    PaymentDto searchPayment(String paymentId) throws SQLException;
    boolean savePayment(PaymentDto dto) throws SQLException;
    List<PaymentTm> getAllPayment() throws SQLException;
    boolean deletePayment(String paymentId) throws SQLException;
    boolean updatePayment(PaymentDto dto) throws SQLException;
}
