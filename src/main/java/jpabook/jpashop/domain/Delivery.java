package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    // Setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }
}
