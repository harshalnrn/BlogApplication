package technicalblog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import technicalblog.Entity.UserEntity;
import technicalblog.config.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class UserRegDao {
    @Autowired
    JpaConfig jpaConfig;

    public void registerUser(UserEntity userEntity) {

        EntityManagerFactory emf = jpaConfig.entityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {

            transaction.begin();
            em.persist(userEntity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }


}

