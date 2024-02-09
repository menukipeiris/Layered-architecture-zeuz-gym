package lk.ijse.gym.entity;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class Equipment {
    private String equipmentId;
    private String equName;
    private String deliveryDate;
    private String description;
    private double cost;
    private String muscleUsed;
}
