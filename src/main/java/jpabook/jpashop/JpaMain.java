package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Member member = new Member();
            member.setName("user");
            Address address = new Address("city", "street", "zipcode");
            member.setAddress(address);

            em.persist(member);

            tx.commit();
        } catch(Exception e) {
            e.printStackTrace();
            tx.rollback(); //오류 발생 시 롤백
        } finally {
            em.close();
        }
        emf.close();
    }
}
