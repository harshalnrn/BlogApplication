package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.Model.Post;
import technicalblog.Service.UserBlogService;

import java.util.ArrayList;

@Controller
public class UserBlogController {

//        @Autowired
//        private UserBlogService postService;


    public UserBlogController() {
        System.out.println("user blog controlller object created");
    }

    @RequestMapping("posts")
        public String getUserPosts(Model model) {
         /*   UserBlogService postService=new UserBlogService();
            ArrayList<Post> posts = postService.getOnePost();
            model.addAttribute("posts", posts);*/
            return "blogs";
        }


}
