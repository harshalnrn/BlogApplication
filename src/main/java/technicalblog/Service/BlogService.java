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
//registers the class as service class in IOC container. but why is there a need to categorize?
public class BlogService {

    public BlogService() {
        System.out.println("blog service bean got created");
    }

    /*@Autowired
    BlogDao blogDao;*/
    public List<Post> blogList = new ArrayList<Post>();

    // public List<Post> getAllBlogs(){
    public Post getAllBlogs() {

/*BlogDao blogDao=new BlogDao();
        List<PostEntity> list=blogDao.getAllPost();//getting list from database.

        for (PostEntity postEntity:list) {
            Post post=new Post();
            post.setTitle(postEntity.getTitle());
            post.setBody(postEntity.getBody());
            post.setDate(new Date());
            blogList.add(post);
        }*/

        BlogDao blogDao = new BlogDao();
        PostEntity postEntity = blogDao.getLatestBlog();
        Post post = new Post();
        if (postEntity != null) {
            if (postEntity.getBody() != null)
                post.setBody(postEntity.getBody());
            if (postEntity.getTitle() != null)
                post.setTitle(postEntity.getTitle());
            post.setDate(new Date());
        }
        return post;

        // return blogList;

    }


    public Post getBlog(Integer id) {

        UserBlogDao userBlogDao = new UserBlogDao();
        PostEntity postEntity = userBlogDao.getPost(id);
        Post post = new Post();
        if (postEntity != null) {
            if (postEntity.getBody() != null)
                post.setBody(postEntity.getBody());
            System.out.println(post.getBody());
            if (postEntity.getTitle() != null)
                post.setTitle(postEntity.getTitle());
            if (postEntity.getDate() != null)
                post.setDate(postEntity.getDate());
        }
        post.setId(postEntity.getId());
        return post;

    }


}
