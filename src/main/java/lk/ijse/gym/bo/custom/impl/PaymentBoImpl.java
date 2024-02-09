package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.dao.Custom.PaymentDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.bo.custom.PaymentBo;
import lk.ijse.gym.dto.PaymentDto;
import lk.ijse.gym.entity.Payment;
import lk.ijse.gym.entity.tm.PaymentTm;

import java.sql.SQLException;
import java.util.List;

public class PaymentBoImpl implements PaymentBo {
    PaymentDao paymentDao= (PaymentDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.PAYMENT);

    @Override
    public PaymentDto searchPayment(String paymentId) throws SQLException {
        Payment payment=paymentDao.search(paymentId);
        return new PaymentDto(payment.getPaymentId(),payment.getMemberId(),payment.getName(),payment.getPlan(),payment.getAmountPaid(),payment.getDate());
    }

    @Override
    public boolean savePayment(PaymentDto paymentDto) throws SQLException {
        Payment payment=new Payment(paymentDto.getPaymentId(),paymentDto.getMemberId(), paymentDto.getName(),paymentDto.getPlan(),paymentDto.getAmountPaid(),paymentDto.getDate());
        return paymentDao.save(payment);
    }

    @Override
    public List<PaymentTm> getAllPayment() throws SQLException {
      return paymentDao.getAll();
    }

    @Override
    public boolean deletePayment(String paymentId) throws SQLException {
        return paymentDao.delete(paymentId);
    }

    @Override
    public boolean updatePayment(PaymentDto paymentDto) throws SQLException {
        Payment payment=new Payment(paymentDto.getPaymentId(),paymentDto.getMemberId(),paymentDto.getName(),paymentDto.getPlan(),paymentDto.getAmountPaid(),paymentDto.getDate());
        return paymentDao.update(payment);
    }
}
