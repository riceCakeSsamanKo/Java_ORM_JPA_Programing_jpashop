package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @OneToMany(mappedBy = "member")  // Order.member가 연관관계 주인
    private List<Order> orders = new ArrayList<>();

    private String zipcode;
    private String name;
    private String city;
    private String street;

    // Setter
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
