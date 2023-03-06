package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
}
