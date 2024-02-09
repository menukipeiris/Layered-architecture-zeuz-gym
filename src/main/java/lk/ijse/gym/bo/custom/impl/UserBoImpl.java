package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.bo.custom.UserBo;
import lk.ijse.gym.dao.Custom.UserDao;
import lk.ijse.gym.dao.DAOFactory;

import java.sql.SQLException;

public class UserBoImpl implements UserBo {

    UserDao userDao= (UserDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.USER);

    @Override
    public String getEmail(String email) throws SQLException {
        return userDao.getEmail(email);
    }

    @Override
    public boolean isExistUser(String userName, String pw) throws SQLException {
        return userDao.isExistUser(userName,pw);
    }
}
