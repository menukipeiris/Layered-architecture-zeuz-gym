package lk.ijse.gym.bo;

import lk.ijse.gym.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        APPOINMENT,EMPLOYEE,EQUIPMENT,MEMBER,ORDER,PAYMENT,PLACEORDER,SERVICE,SUPPLIMENT,WORKOUT,USER;
    }
    public SuperBo getBo(BOFactory.BOTypes boTypes){
        switch (boTypes){
            case APPOINMENT:return new AppoinmentBoImpl();
            case EMPLOYEE:return new EmployeeBoImpl();
            case EQUIPMENT:return new EquipmentBoImpl();
            case MEMBER:return new MemberBoImpl();
            case ORDER:return new OrderBoImpl();
            case PAYMENT:return new PaymentBoImpl();
            case PLACEORDER:return new PlaceOrderBoImpl();
            case SERVICE:return new ServiceBoImpl();
            case SUPPLIMENT:return new SupplimentBoImpl();
            case WORKOUT:return new WorkoutBoImpl();
            case USER:return new UserBoImpl();
            default:return null;
        }
    }
}
