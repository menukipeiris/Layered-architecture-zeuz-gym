package lk.ijse.gym.entity;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Suppliment {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
