package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne  // Order.member가 연관관계 주인
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")  // OrderItem.order가 연관관계 주인
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)  // OrderStatus는 enum이고 숫자가 아닌 String으로 식별함
    private OrderStatus status;

    // 연관관계 편의 메소드 (연관 관계 주인에게만 존재)
    public void addMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    protected void setMember(Member member) {
        this.member = member;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
