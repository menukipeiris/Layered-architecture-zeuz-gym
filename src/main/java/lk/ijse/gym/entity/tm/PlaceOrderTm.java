package lk.ijse.gym.entity.tm;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PlaceOrderTm {
    private String orderId;
    private LocalDate date;
    private String memberId;
    private List<CartTm> cartTmList = new ArrayList<>();

}
