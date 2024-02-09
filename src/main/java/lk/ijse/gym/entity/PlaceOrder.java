package lk.ijse.gym.entity;

import lk.ijse.gym.entity.tm.CartTm;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PlaceOrder {
    private String orderId;
    private LocalDate date;
    private String memberId;
    private List<CartTm> cartTmList = new ArrayList<>();
}
