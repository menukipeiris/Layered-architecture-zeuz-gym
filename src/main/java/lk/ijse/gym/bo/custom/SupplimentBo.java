package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;
import lk.ijse.gym.dto.SupplimentDto;
import lk.ijse.gym.entity.tm.CartTm;
import lk.ijse.gym.entity.tm.SupplimentTm;

import java.sql.SQLException;
import java.util.List;

public interface SupplimentBo extends SuperBo {
    List<SupplimentTm> getAllItems() throws SQLException;
    boolean saveItems(SupplimentDto suppliment) throws SQLException;
    boolean updateItems(SupplimentDto suppliment) throws SQLException;
    boolean update(List<CartTm> cartTmList) throws SQLException;
    SupplimentDto searchItems(String code) throws SQLException;
    boolean deleteItems(String code) throws SQLException;
    boolean update(String code, int qty) throws SQLException;
    List<SupplimentDto> loadAllItem() throws SQLException;

}
