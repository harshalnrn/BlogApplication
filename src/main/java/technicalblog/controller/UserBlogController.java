package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technicalblog.Model.Post;
import technicalblog.Model.User;
import technicalblog.Service.BlogService;
import technicalblog.Service.UserBlogService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserBlogController {
    @Autowired
    private UserBlogService postService;
    @Autowired
    private BlogService blogService;

    public UserBlogController() {
        System.out.println("user blog controlller object created");
    }

    @RequestMapping(value = "posts", method = RequestMethod.GET)
    public String getUserPosts(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        List<Post> posts = postService.getPosts(user.getUser_id());
        model.addAttribute("posts", posts);


        return "blogs";
    }

    @RequestMapping(value = "createPost", method = RequestMethod.POST)
    public String createNewBlog(Model model) {
        return "newBlog";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createPost(Post newPost, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("loggedUser");
        newPost.setUser(user);
        postService.createBlog(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name = "postId") Integer postId, Model model) {
        Post post = blogService.getBlog(postId);
        model.addAttribute("post", post);
        return "editBlog.html";
    }

    @RequestMapping(value = "editPost", method = RequestMethod.PUT)
    public String editPost(@RequestParam(name = "postId") Integer postId, Post post) {
        post.setId(postId);
        postService.updatePost(postId, post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "deletePost", method = RequestMethod.GET)
    public String deletePost(@RequestParam(name = "postId") Integer postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }


}
