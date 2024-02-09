package lk.ijse.gym.dao.Custom;

import lk.ijse.gym.dao.CrudDao;
import lk.ijse.gym.entity.User;
import lk.ijse.gym.entity.tm.UserTm;

import java.sql.SQLException;

public interface UserDao extends CrudDao<User, UserTm,String> {
    String getEmail(String email) throws SQLException;
    boolean isExistUser(String userName, String pw) throws SQLException;
}
