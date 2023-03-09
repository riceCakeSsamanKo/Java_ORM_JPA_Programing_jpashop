package jpabook.jpashop.domain;

import lombok.AccessLevel;
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

    // 연관관계 편의 메소드 (연관 관계 주인이 아닌 엔티티에 존재)
    public void addOrder(Order order) {
        this.order = order;
        order.getOrderItems().add(this);
    }
    public void addItem(Item item) {
        this.item = item;
        item.getOrderItems().add(this);
    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    protected void setOrder(Order order) {
        this.order = order;
    }

    protected void setItem(Item item) {
        this.item = item;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
