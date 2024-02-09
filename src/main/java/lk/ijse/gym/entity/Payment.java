package lk.ijse.gym.entity;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Payment {
    private String paymentId;
    private String memberId;
    private String name;
    private String plan;
    private double amountPaid;
    private String date;
}
