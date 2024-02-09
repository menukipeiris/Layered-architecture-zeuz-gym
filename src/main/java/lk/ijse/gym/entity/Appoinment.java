package lk.ijse.gym.entity;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Appoinment {

    private String appoinmentId;
    private String date;
    private String memberId;
    private String time;
    private String description;

}
