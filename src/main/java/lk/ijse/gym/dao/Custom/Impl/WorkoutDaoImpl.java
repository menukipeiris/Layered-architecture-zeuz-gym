package lk.ijse.gym.dao.Custom.Impl;

import lk.ijse.gym.dao.Custom.WorkoutDao;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.entity.Workout;
import lk.ijse.gym.entity.tm.WorkoutTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDaoImpl implements WorkoutDao {

    public  boolean delete(String planId) throws SQLException {
        String sql = "DELETE FROM workoutPlan WHERE planId= ?";
        return SqlUtil.execute(sql,planId);
    }

    public boolean save(Workout workout) throws SQLException {
        String sql = "INSERT INTO workoutPlan VALUES (?,?,?,?,?)";
        return SqlUtil.execute(sql,workout.getPlanId(),workout.getWarmUp(),workout.getTraining(),workout.getCardio(),workout.getWarmDown());

    }

    public boolean update(Workout workout) throws SQLException {
        String sql="UPDATE workoutPlan SET warmUp=?,training=?,cardio=?,warmDown=? WHERE planId=?";
        return SqlUtil.execute(sql,workout.getWarmUp(),workout.getTraining(),workout.getCardio(),workout.getWarmDown(),workout.getPlanId());
    }

    public List<WorkoutTm> getAll() throws SQLException {
            String sql="SELECT * FROM workoutPlan";
            ResultSet resultSet=SqlUtil.execute(sql);

        ArrayList<WorkoutTm> dtoList=new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new WorkoutTm(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    )
            );
        }
        return dtoList;
    }

    public Workout search(String planId) throws SQLException {
        String sql = "SELECT * FROM workoutPlan WHERE planId =? ";
        ResultSet resultSet = SqlUtil.execute(sql,planId);

         Workout dto = null;

        if (resultSet.next()) {
            String planid = resultSet.getString(1);
            String warmUp = resultSet.getString(2);
            String training = resultSet.getString(3);
            String cardio = resultSet.getString(4);
            String warmDown = resultSet.getString(5);

            dto = new Workout(planid, warmUp, training, cardio, warmDown);
        }
        return dto;
    }

}
