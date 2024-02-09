package lk.ijse.gym.entity.tm;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class WorkoutTm {
    private String planId;
    private String warmUp;
    private String training;
    private String cardio;
    private String warmDown;
}
