package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;
import lk.ijse.gym.dto.WorkoutDto;
import lk.ijse.gym.entity.Workout;
import lk.ijse.gym.entity.tm.WorkoutTm;

import java.sql.SQLException;
import java.util.List;

public interface WorkoutBo extends SuperBo {
    boolean deleteService(String planId) throws SQLException;
    boolean saveService(WorkoutDto workout) throws SQLException;
    boolean updateService(WorkoutDto workout) throws SQLException;
    List<WorkoutTm> getAllService() throws SQLException;
    WorkoutDto searchService(String planId) throws SQLException;


}
