package lk.ijse.gym.dao.Custom;

import lk.ijse.gym.dao.CrudDao;
import lk.ijse.gym.dto.SupplimentDto;
import lk.ijse.gym.entity.Suppliment;
import lk.ijse.gym.entity.tm.CartTm;
import lk.ijse.gym.entity.tm.SupplimentTm;

import java.sql.SQLException;
import java.util.List;

public interface SupplimentDao extends CrudDao<Suppliment, SupplimentTm,String> {
    boolean update1(List<CartTm> cartTmList) throws SQLException;
    List<SupplimentDto> loadAllItem() throws SQLException;


    }
