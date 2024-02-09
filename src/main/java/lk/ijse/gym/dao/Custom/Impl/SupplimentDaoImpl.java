package lk.ijse.gym.dao.Custom.Impl;

import lk.ijse.gym.dao.Custom.SupplimentDao;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.dto.SupplimentDto;
import lk.ijse.gym.entity.Suppliment;
import lk.ijse.gym.entity.tm.CartTm;
import lk.ijse.gym.entity.tm.SupplimentTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplimentDaoImpl implements SupplimentDao {

    public List<SupplimentDto> loadAllItem() throws SQLException {
        String sql = "SELECT * FROM suppliment";
        ResultSet resultSet =SqlUtil.execute(sql);

        List<SupplimentDto> itemList = new ArrayList<>();

        while (resultSet.next()) {
            itemList.add(new SupplimentDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }

        return itemList;
    }

    @Override
    public boolean delete(String code) throws SQLException {
        String sql="DELETE FROM suppliment WHERE code=?";
        return SqlUtil.execute(sql,code);
    }

    public boolean save(Suppliment suppliment) throws SQLException {
        String sql = "INSERT INTO suppliment VALUES(?, ?, ?, ?)";
        return SqlUtil.execute(sql,suppliment.getCode(),suppliment.getDescription(),suppliment.getUnitPrice(),suppliment.getQtyOnHand());
    }

    @Override
    public List<SupplimentTm> getAll() throws SQLException {
        return null;
    }

    public boolean update(Suppliment suppliment) throws SQLException {
        String sql = "UPDATE suppliment SET description = ?, unitPrice = ?, qtyOnHand = ? WHERE code = ?";
        return SqlUtil.execute(sql,suppliment.getDescription(),suppliment.getUnitPrice(),suppliment.getQtyOnHand(),suppliment.getCode());
    }
    public  boolean update1(List<CartTm> cartTmList) throws SQLException {
        for(CartTm tm : cartTmList) {
            System.out.println("Item: " + tm);
            if(!updateQty(tm.getCode(), tm.getQty())) {
                return false;
            }
        }
        return true;
    }

    public Suppliment search(String code) throws SQLException {
        String sql = "SELECT * FROM suppliment WHERE  code = ?";
        ResultSet resultSet = SqlUtil.execute(sql,code);

        Suppliment dto = null;

        if(resultSet.next()) {
            dto = new Suppliment(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        }
        return dto;
    }
    public static boolean updateQty(String code, int qty) throws SQLException {
        String sql = "UPDATE suppliment SET qtyOnHand = qtyOnHand - ? WHERE code = ?";
        return SqlUtil.execute(sql,code,qty);
    }
}
