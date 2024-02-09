package lk.ijse.gym.entity;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Workout {
    private String planId;
    private String warmUp;
    private String training;
    private String cardio;
    private String warmDown;
}
