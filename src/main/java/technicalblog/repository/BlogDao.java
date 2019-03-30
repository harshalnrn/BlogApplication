package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.Entity.PostEntity;
import technicalblog.config.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BlogDao {

    List<PostEntity> list = null;
    TypedQuery<PostEntity> query = null;
    EntityManagerFactory em = null;
    EntityManager manager = null;
    PostEntity postEntity = null;


    public PostEntity getLatestBlog() {
        JpaConfig config = new JpaConfig();
        em = config.entityManagerFactory();
        manager = em.createEntityManager();
        postEntity = manager.find(PostEntity.class, 3);
        return postEntity;
    }

    public List<PostEntity> getAllBlogs() {
        JpaConfig config = new JpaConfig();
        em = config.entityManagerFactory();
        manager = em.createEntityManager();
        TypedQuery<PostEntity> query = manager.createQuery("select p from PostEntity p", PostEntity.class);
        List<PostEntity> list = query.getResultList();
        return list;
    }





















   /* DbConnection conn = null;
    ResultSet resultSet;
    List<Post> list = null;

    public List<Post> getAllPosts() {
try {

    conn = new DbConnection();
    resultSet = conn.connectToDb();
    list = new ArrayList<Post>();
    while (resultSet.next()) {
        Post post=new Post();
      post.setDate(new Date());
        post.setBody(resultSet.getString("body"));
        post.setTitle(resultSet.getString("title"));
        list.add(post);
    }

}
catch(SQLException e){

}

return list;
    }*/
}
