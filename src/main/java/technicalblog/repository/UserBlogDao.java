package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.Entity.PostEntity;
import technicalblog.config.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class UserBlogDao {

    @PersistenceUnit(unitName = "bloggingApplication")
    private EntityManagerFactory emf;

    public PostEntity createPost(PostEntity postEntity) {
        JpaConfig config = new JpaConfig();
        emf = config.entityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();       //understand why Transaction required, and whether exception block is necessary
        //understand why persist along with transaction is safe
        try {
            transaction.begin();
            em.persist(postEntity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return postEntity;
    }

    public PostEntity getPost(Integer id) {
        PostEntity postEntity = null;
        JpaConfig config = new JpaConfig();
        emf = config.entityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();       //understand why Transaction required, and whether exception block is necessary
        //understand why persist along with transaction is safe
        try {
            transaction.begin();
            postEntity = em.find(PostEntity.class, id);
        } catch (Exception e) {
        }
        return postEntity;

    }


    public void updateBlog(Integer id, PostEntity postEntity) {
        JpaConfig config = new JpaConfig();
        emf = config.entityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();       //understand why Transaction required, and whether exception block is necessary
        //understand why persist along with transaction is safe
        try {
            transaction.begin();
            em.merge(postEntity);
           /* Query query=em.createNativeQuery("update posts p set title="+postEntity.getTitle()+",body="+postEntity.getBody()+",date="+postEntity.getDate()+
                            "where id ="+id+";");
            query.executeUpdate();*/
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

    }

    public void deleteBlog(Integer id) {
        JpaConfig config = new JpaConfig();
        emf = config.entityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();       //understand why Transaction required, and whether exception block is necessary
        //understand why persist along with transaction is safe
        try {
            transaction.begin();
            PostEntity postEntity = em.find(PostEntity.class, id);
            em.remove(postEntity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }


    }

    /* public void deletePost(String postTitle) {*//*
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            TypedQuery<PostEntity> query = em.createQuery("SELECT p FROM PostEntity p WHERE title =:title",PostEntity.class);
            query.setParameter("title",postTitle);
            PostEntity post = query.getSingleResult();
            em.remove(post);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }
    }*/
}

