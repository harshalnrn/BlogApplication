package technicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.Model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
@RequestMapping("/")

/**Spring provides a model class in which
you can pass data from the controller method to the view (or Thymeleaf template in the context of this demonstration.
 **/
public String getAllPosts(Model model) {
    List<Post> list=new ArrayList<Post>();

    Post post=new Post();
    post.setTitle("blog 1");
    post.setBody("blog 1 body");
    post.setDate(new Date());

    Post post1=new Post();
    post1.setTitle("blog 1");
    post1.setBody("blog 2 body");
    post1.setDate(new Date());

    Post post2=new Post();
    post2.setTitle("blog 1");
    post2.setBody("blog 3 body");
    post2.setDate(new Date());


    Post post3=new Post();
    post3.setTitle("blog 1");
    post3.setBody("blog 4 body");
    post3.setDate(new Date());

    list.add(post);
    list.add(post1);
    list.add(post2);
    list.add(post3);

    /**
     * The model is a Spring Model object and is a key-value-like class (similar to a hash table) provided  by the Spring framework, and it helps to pass data from the controller to the view template (or thymeleaf in this demonstration) . In the instruction above, the string ‘posts’ act as a key, and its corresponding value would be the post data stored in the variable posts. Specifically, Spring would automatically pass the model to the view ,
     * which can then retrieve the data stored in the model  and then render the data as a part of the web page to be shown to the user.
     */

    //key: blogList , value: list
    model.addAttribute("blogList", list);

    return "index";
}
}
