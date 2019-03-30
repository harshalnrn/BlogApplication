package technicalblog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import technicalblog.Entity.UserEntity;
import technicalblog.Model.User;
import technicalblog.config.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

@Repository
public class UserLoginDao {
    @Autowired
    JpaConfig jpaConfig;

    public boolean checkLogin(User user) {
        boolean flag = true;
        EntityManagerFactory emf = jpaConfig.entityManagerFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u where username=:username AND password=:value", UserEntity.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("value", user.getPassword());
        try {
            UserEntity userEntity1 = query.getSingleResult();
        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }
}
