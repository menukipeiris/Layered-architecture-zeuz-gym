package lk.ijse.gym.entity;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Member {
    private String memberId;
    private String name;
    private String gender;
    private int cont;
    private String address;
    private String dateJoin;
    private String plan;
    private double planPrice;
}
