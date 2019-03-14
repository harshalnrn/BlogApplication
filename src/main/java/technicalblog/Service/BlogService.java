package technicalblog.Service;

import org.springframework.stereotype.Service;
import technicalblog.Model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service                             //registers the class as service class in IOC container. but why is there a need to categorize?
public class BlogService {
    public BlogService() {
        System.out.println("blog service bean got created");
    }

    public List<Post> getAllBlogs(){

        List<Post> list=new ArrayList<Post>();

        //thus we see that this class has a dependency of class Post. Hence lets autowire it.

        Post post=new Post();
        post.setTitle("blog 1");
        post.setBody("blog 1 body");
        post.setDate(new Date());

        Post post1=new Post();
        post1.setTitle("blog 2");
        post1.setBody("blog 2 body");
        post1.setDate(new Date());

        Post post2=new Post();
        post2.setTitle("blog 3");
        post2.setBody("blog 3 body");
        post2.setDate(new Date());


        Post post3=new Post();
        post3.setTitle("blog 4");
        post3.setBody("blog 4 body");
        post3.setDate(new Date());

        list.add(post);
        list.add(post1);
        list.add(post2);
        list.add(post3);


        return list;

    }
}
