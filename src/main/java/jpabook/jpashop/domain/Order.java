package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
public class Order extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // Order.member가 연관관계 주인
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)  // OrderItem.order가 연관관계 주인
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)  //cascade가 ALL이라는 것은 주문을 생성시에 배송정보도 동시에 생성하겠다는 것
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @Enumerated(EnumType.STRING)  // OrderStatus는 enum이고 숫자가 아닌 String으로 식별함
    private OrderStatus status;
    private LocalDateTime orderDate;

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
