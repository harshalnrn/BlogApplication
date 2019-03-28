package technicalblog.Entity;

import javax.persistence.*;
import java.util.Date;

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
