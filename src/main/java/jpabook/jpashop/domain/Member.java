package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
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


}
