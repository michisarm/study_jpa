package cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CascadeMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            // cascade 사용하지 않으면 각각 등록해주어야함
            em.persist(parent);
            em.persist(child1);
            em.persist(child2);

            // Parent.class에 childList 항목에 cascade 선언시 parent가 바뀌면 자동으로 전이됨
            //@OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
            //private List<Child> childList = new ArrayList<>();
            em.persist(parent);





            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }

    }
}
