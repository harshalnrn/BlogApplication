package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.Model.Post;
import technicalblog.Model.User;
import technicalblog.Model.UserProfile;
import technicalblog.Service.BlogService;
import technicalblog.Service.UserLoginService;
import technicalblog.Service.UserRegService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    //in case of single attribute value, not need to explicitly state, value. Also by default the method is get method

    @Autowired
    private BlogService blog;
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserRegService userRegService;

    @RequestMapping("users/login1")
    public String login() {
        return "login";
    }

    @RequestMapping("users/registration")
    public String registration(Model model) {

        User user = new User();
        UserProfile profile = new UserProfile();
        user.setUserProfile(profile);

        model.addAttribute("User", user);

        return "registration";
    }

    //note: objects like model, httpSession are created by Springcontainer by default, and injected into controller method
    @RequestMapping(value = "users/login1", method = RequestMethod.POST)
    public String loginUser(User user, HttpSession httpSession) {
        //after submit, verify login and redirect to blogs page after succesfull login
        User existingUser = userLoginService.verifyLogin(user);
        if (existingUser != null) {
            httpSession.setAttribute("loggedUser", existingUser);
            return "redirect:/posts";
        } else
            return "redirect:/users/login1";
    }

    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String regUser(User user) {
        userRegService.registerNewUser(user);
        return "redirect:/users/login1";
    }

    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logoutUser(Model model, HttpSession session) {

        session.invalidate();
        Post post = blog.getAllBlogs();
        List<Post> list = new ArrayList<Post>();
        list.add(post);
        model.addAttribute("blogList", list);
        return "index";
        // return "redirect:/";
    }


}
