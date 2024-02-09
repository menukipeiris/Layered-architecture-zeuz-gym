package lk.ijse.gym.dao;

import lk.ijse.gym.dao.Custom.Impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        EMPLOYEE,EQUIPMENT,MEMBER,ORDER,PAYMENT,PLACEORDER,SERVICE,SUPPLIMENT,WORKOUT,USER;
    }
    public SuperDao getDao(DAOTypes daoTypes) {
        switch (daoTypes){
            case EMPLOYEE:return new EmployeeDaoImpl();
            case EQUIPMENT:return new EquipmentDaoImpl();
            case MEMBER:return new MemberDaoImpl();
            case ORDER:return new OrderDaoImpl();
            case PAYMENT:return new PaymentDaoImpl();
            case PLACEORDER:return new PlaceOrderDaoImpl();
            case SERVICE:return new ServiceDaoImpl();
            case SUPPLIMENT:return new SupplimentDaoImpl();
            case WORKOUT:return new WorkoutDaoImpl();
            case USER:return new UserDaoImpl();
            default:return null;
        }
    }
}
