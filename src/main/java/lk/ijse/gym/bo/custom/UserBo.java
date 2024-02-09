package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;

import java.sql.SQLException;

public interface UserBo extends SuperBo {
    String getEmail(String email) throws SQLException;
    boolean isExistUser(String userName, String pw) throws SQLException;

}
