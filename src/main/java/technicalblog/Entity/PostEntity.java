package technicalblog.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    //@Transient
    @Column(name = "date")
    private Date date; //you need to make this transient

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    //Here we dont want to persist userEntity, hence no cascade
    @JoinColumn(name = "user_id")    //note: the column naming syntax here is very important, else result in exceptions
    private UserEntity userEntity;  //value of user-id would be PK value of userEntity object*/

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Category_Entity> categories = new ArrayList<>();    //1 post can have mutiple categories, hence list. Here categories entity is the foreign table

    @Transient
    private String springBlog;    //The @Transient annotation is used to specify that these attributes are not mapped to any columns in the database
    @Transient
    private String javaBlog;

    public String getSpringBlog() {
        return springBlog;
    }

    public void setSpringBlog(String springBlog) {
        this.springBlog = springBlog;
    }

    public String getJavaBlog() {
        return javaBlog;
    }

    public void setJavaBlog(String javaBlog) {
        this.javaBlog = javaBlog;
    }

    public List<Category_Entity> getCategories() {
        return categories;
    }

    public void setCategories(List<Category_Entity> categories) {
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
