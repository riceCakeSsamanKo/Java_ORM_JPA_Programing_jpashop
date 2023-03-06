package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne  // Order.member가 연관관계 주인
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")  // OrderItem.order가 연관관계 주인
    private List<OrderItem> orderItems= new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)  // OrderStatus는 enum이고 숫자가 아닌 String으로 식별함
    private OrderStatus status;
}
