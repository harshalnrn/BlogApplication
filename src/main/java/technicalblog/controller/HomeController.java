package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.Model.Post;
import technicalblog.Service.BlogService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private BlogService blog;

    public HomeController() {
        System.out.println(" home controller object got created");
    }

    @RequestMapping("/")

/**Spring provides a model class in which
 you can pass data from the controller method to the view (or Thymeleaf template in the context of this demonstration.
 **/
    public String getAllPosts(Model model) {
        /**
         * The model is a Spring Model object and is a key-value-like class (similar to a hash table) provided  by the Spring framework, and it helps to pass data from the controller to the view template (or thymeleaf in this demonstration) . In the instruction above, the string ‘posts’ act as a key, and its corresponding value would be the post data stored in the variable posts. Specifically, Spring would automatically pass the model to the view ,
         * which can then retrieve the data stored in the model  and then render the data as a part of the web page to be shown to the user.
         * key: blogList , value: list
         */

        //noew hardcoding a dependency, creates tight-coupling between classes, in large projects

        // BlogService blog=new BlogService();
        //List<Post>list=blog.getAllBlogs();
        Post post = blog.getAllBlogs();
        List<Post> list = new ArrayList<Post>();
        list.add(post);
        model.addAttribute("blogList", list);

        return "index"; //note this path of view is in relative to templates folder
    }
}
