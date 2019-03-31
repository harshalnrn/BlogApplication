package technicalblog.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    private String category;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)  //bi directional mapping
    //1 post can have many categories. Similarly 1 category can have multiple posts
    private List<PostEntity> posts = new ArrayList<>();       //1 category can have mutiple posts

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
