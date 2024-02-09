package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.dao.Custom.WorkoutDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.bo.custom.WorkoutBo;
import lk.ijse.gym.dto.WorkoutDto;
import lk.ijse.gym.entity.Workout;
import lk.ijse.gym.entity.tm.WorkoutTm;

import java.sql.SQLException;
import java.util.List;

public class WorkoutBoImpl implements WorkoutBo {
    WorkoutDao workoutDao= (WorkoutDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.WORKOUT);
    @Override
    public boolean deleteService(String planId) throws SQLException {
        return workoutDao.delete(planId);
    }

    @Override
    public boolean saveService(WorkoutDto workoutDto) throws SQLException {
        Workout workout=new Workout(workoutDto.getPlanId(),workoutDto.getWarmUp(),workoutDto.getTraining(),workoutDto.getCardio(),workoutDto.getWarmDown());
        return workoutDao.save(workout);
    }

    @Override
    public boolean updateService(WorkoutDto workoutDto) throws SQLException {
        Workout workout=new Workout(workoutDto.getPlanId(),workoutDto.getWarmUp(),workoutDto.getTraining(),workoutDto.getCardio(),workoutDto.getWarmDown());
        return workoutDao.update(workout);
    }

    @Override
    public List<WorkoutTm> getAllService() throws SQLException {
        return workoutDao.getAll();
    }

    @Override
    public WorkoutDto searchService(String planId) throws SQLException {
        Workout workout=workoutDao.search(planId);
        return new WorkoutDto(workout.getPlanId(),workout.getWarmUp(),workout.getTraining(),workout.getCardio(),workout.getWarmDown());
    }
}
