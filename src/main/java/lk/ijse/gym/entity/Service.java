package lk.ijse.gym.entity;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Service {
    private String serviceId;
    private String trainerId;
    private String trainerName;
    private String classType;
    private String time;
    private String date;

}
