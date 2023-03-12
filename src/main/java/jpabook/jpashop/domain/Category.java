package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany  // 예시라서 쓴거지 실전에서는 다대다를 쓰지 않는다. 실전에서는 중간 엔티티 만들어서 일대다,다대일로 중간테이블에 매핑해서 사용한다.
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name="CATEAGORY_ID"),
            inverseJoinColumns = @JoinColumn(name="ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();

//    @ManyToOne
//    @JoinTable(name = "CATEGORY_ITEM")
//    private Category parent; // 상위 카테고리, ex) 카테고리: 옷
//
//    @OneToMany(mappedBy = "parent")
//    private List<Category> child = new ArrayList<>();  // 하위 카테고리 ex): 옷/바지, 옷/상의
}
