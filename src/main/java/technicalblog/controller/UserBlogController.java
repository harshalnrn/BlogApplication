package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.Model.Post;
import technicalblog.Service.UserBlogService;

import java.util.ArrayList;

@Controller
public class UserBlogController {
    @Autowired
 private UserBlogService postService;

    public UserBlogController() {
        System.out.println("user blog controlller object created");
    }

    @RequestMapping("posts")
        public String getUserPosts(Model model) {
            ArrayList<Post> posts = postService.getPosts();
            model.addAttribute("posts", posts);
            return "blogs";
        }

    @RequestMapping(value="createPost", method= RequestMethod.POST)
    public String createNewBlog(Model model) {
        return "newBlog";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createPost(Post newPost) {
      postService.createBlog(newPost);
        return "redirect:/posts";
    }


}
