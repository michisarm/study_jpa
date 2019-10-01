package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class PersistenceContextMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{


//            Member member = new Member();
//            member.setId(101L);
//            member.setName("helloJPA");
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            //select query 실행 안됨
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());


            //영속 - 1번만 조회함
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

            //동일함
            //1차 캐시로 반복 가능한 읽기(REPEATABLE READ) 등급의 트랜잭
            //션 격리 수준을 데이터베이스가 아닌 애플리케이션 차원에서 제공
//            System.out.println("result= " + (findMember1 == findMember2));
//            tx.commit();



            //엔티티 매니저는 데이터 변경시 트랜잭션을 시작해야 한다.
            //tx.begin(); // [트랜잭션] 시작
//            Member memberA = new Member(150L,"A");
//            Member memberB = new Member(160L,"B");
//            em.persist(memberA);
//            em.persist(memberB);
            //여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.
//            System.out.println("=============================================");
            //커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.
//            tx.commit(); // [트랜잭션] 커밋

            //update
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");

            //준영속 상태
            //em.detach(member);
            //em.clear(); //전체

//            System.out.println("=============================================");
//            tx.commit(); // [트랜잭션] 커밋


            //강제 flush
            Member member = new Member(200L,"A");
            em.persist(member);

            em.flush();

            System.out.println("=============================================");
            tx.commit(); // [트랜잭션] 커밋


        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }

    }
}
