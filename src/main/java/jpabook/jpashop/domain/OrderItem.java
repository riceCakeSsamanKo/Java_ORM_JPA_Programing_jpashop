package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne  // OrderItem.order가 연관관계 주인
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne  // OrderItem.item이 연관관계 주인
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;

    // Setter
    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // 연관관계 편의 메소드 (연관 관계 주인에게만 존재)
    public void addOrder(Order order) {
        this.order = order;
        order.getOrderItems().add(this);
    }
    public void addItem(Item item) {
        this.item = item;
        item.getOrderItems().add(this);
    }
}
