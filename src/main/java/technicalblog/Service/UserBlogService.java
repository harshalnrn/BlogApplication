package technicalblog.Service;

import org.springframework.stereotype.Service;
import technicalblog.Entity.PostEntity;
import technicalblog.Model.Post;
import technicalblog.repository.BlogDao;
import technicalblog.repository.UserBlogDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserBlogService {
    private List<Post> posts;

    public UserBlogService() {
        posts = new ArrayList<Post>();
    }

    public List<Post> getPosts() {
        posts = new ArrayList<Post>();
        BlogDao blogDao = new BlogDao();
        List<PostEntity> list = blogDao.getAllBlogs();
        for (PostEntity postEntity : list) {
            Post post = new Post();
            post.setTitle(postEntity.getTitle());
            post.setBody(postEntity.getBody());
            post.setDate(postEntity.getDate());
            post.setId(postEntity.getId());
            System.out.println(post.getId());
            posts.add(post);
        }
        return posts;
    }

    public void createBlog(Post post) {
        PostEntity postEntity = new PostEntity();
        postEntity.setBody(post.getBody());
        postEntity.setTitle(post.getTitle());
        postEntity.setDate(new Date());

        UserBlogDao blogDao = new UserBlogDao();
        postEntity = blogDao.createPost(postEntity);

        post.setTitle(postEntity.getTitle());
        post.setBody(postEntity.getBody());
        post.setDate(postEntity.getDate());
        post.setId(postEntity.getId());
        posts.add(post);

    }


    public void updatePost(Integer id, Post post) {

        UserBlogDao dao = new UserBlogDao();

        PostEntity postEntity = new PostEntity();
        postEntity.setBody(post.getBody());
        postEntity.setTitle(post.getTitle());
        postEntity.setDate(new Date());
        postEntity.setId(post.getId());
        dao.updateBlog(id, postEntity);

    }
}
