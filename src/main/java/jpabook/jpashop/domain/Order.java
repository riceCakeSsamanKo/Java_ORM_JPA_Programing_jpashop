package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)  //OrderStatus는 enum이고 숫자가 아닌 String으로 식별함
    private OrderStatus status;
}
