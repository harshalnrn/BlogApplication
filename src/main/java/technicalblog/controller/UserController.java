package technicalblog.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.Model.Post;
import technicalblog.Model.User;
import technicalblog.Service.BlogService;
import technicalblog.Service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
//in case of single attribute value, not need to explicitly state, value. Also by default the method is get method
@Autowired
private UserService userService;

    @RequestMapping("users/login1")
    public String login() {

        return "login";
        //return "redirect:/login";
    }

    @RequestMapping("users/registration1")
    public String registration() {

        return "registration";
        //return "redirect:/registration";
    }

    @RequestMapping(value="users/login1", method= RequestMethod.POST)
    public String loginUser(User user) {
        //after submit, verify login and redirect to blogs page after succesfull login
userService.verifyLogin(user);
return "redirect:/posts";
    }

    @RequestMapping(value="users/logout", method=RequestMethod.POST)
    public String logoutUser(Model model){
return "redirect:/";
    }


}
