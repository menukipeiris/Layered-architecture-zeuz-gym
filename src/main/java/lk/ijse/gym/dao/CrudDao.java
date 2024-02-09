package lk.ijse.gym.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T,TM,ID2> extends SuperDao{
    T search(ID2 memberId) throws SQLException;
    boolean save(T dto) throws SQLException;
    List<TM> getAll() throws SQLException;
    boolean delete(ID2 memberId) throws SQLException;
    boolean update(T dto) throws SQLException;
}
