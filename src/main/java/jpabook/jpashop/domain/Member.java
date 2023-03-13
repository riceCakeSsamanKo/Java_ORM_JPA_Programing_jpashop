package jpabook.jpashop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID", nullable = false)
    private Long id;

    private String zipcode;
    private String name;
    private String city;
    private String street;

    @OneToMany(mappedBy = "member")  // Order.member가 연관관계 주인
    private List<Order> orders = new ArrayList<>();


    // 연관관계 편의 메소드 (연관 관계 주인이 아닌 엔티티에 존재)
    public void addOrder(Order order){
        orders.add(order);
        order.setMember(this);
    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
