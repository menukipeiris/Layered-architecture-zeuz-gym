package lk.ijse.gym.entity.tm;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class EquipmentTm {
    private String equipmentId;
    private String equName;
    private String deliveryDate;
    private String description;
    private double cost;
    private String muscleUsed;
}
