package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            //Member
            Member member = new Member();
            member.setName("member");

            //Item
            Item book = new Item();
            book.setName("Book");
            book.setPrice(1000);
            book.setStockQuantity(100);

            Item robot = new Item();
            robot.setName("Robot");
            robot.setPrice(3000);
            robot.setStockQuantity(50);

            em.persist(book);
            em.persist(robot);

            //OrderItem
            OrderItem orderItem1 = new OrderItem();
            orderItem1.setCount(2);
            orderItem1.setOrderPrice(book.getPrice() * orderItem1.getCount());
            book.addOrderItem(orderItem1);

            OrderItem orderItem2 = new OrderItem();
            orderItem2.setCount(3);
            orderItem2.setOrderPrice(robot.getPrice() * orderItem2.getCount());
            robot.addOrderItem(orderItem2);

            OrderItem orderItem3 = new OrderItem();
            orderItem3.setCount(5);
            orderItem3.setOrderPrice(book.getPrice() * orderItem3.getCount());
            book.addOrderItem(orderItem3);

            em.persist(orderItem1);
            em.persist(orderItem2);
            em.persist(orderItem3);

            //Order
            Order order1 = new Order();
            order1.setStatus(OrderStatus.ORDER);
            order1.addOrderItem(orderItem1);
            order1.addOrderItem(orderItem2);

            Order order2 = new Order();
            order2.setStatus(OrderStatus.CANCEL);
            order2.addOrderItem(orderItem3);

            em.persist(order1);
            em.persist(order2);


            member.addOrder(order1);
            member.addOrder(order2);

            em.persist(member);



            tx.commit();
        } catch(Exception e) {
            tx.rollback(); //오류 발생 시 롤백
        } finally {
            em.close();
        }
        emf.close();
    }
}
