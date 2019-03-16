package technicalblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.Model.Post;

import java.util.ArrayList;
import java.util.Date;

@Service
public class UserBlogService {
    private ArrayList<Post> posts;

    public UserBlogService() {
      posts=new ArrayList<Post>();
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void createBlog(Post post) {
        post.setDate(new Date());
        posts.add(post);

    }
}
