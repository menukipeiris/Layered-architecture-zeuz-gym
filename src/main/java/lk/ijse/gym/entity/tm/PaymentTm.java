package lk.ijse.gym.entity.tm;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PaymentTm {
    private String paymentId;
    private String memberId;
    private String name;
    private String plan;
    private double amountPaid;
    private String date;

}
