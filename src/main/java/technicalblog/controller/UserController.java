package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.Model.NewUser;
import technicalblog.Model.User;
import technicalblog.Service.UserLoginService;
import technicalblog.Service.UserRegService;

@Controller
public class UserController {
    //in case of single attribute value, not need to explicitly state, value. Also by default the method is get method
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserRegService userRegService;

    @RequestMapping("users/login1")
    public String login() {
        return "login";
    }

    @RequestMapping("users/registration")
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = "users/login1", method = RequestMethod.POST)
    public String loginUser(User user) {
        //after submit, verify login and redirect to blogs page after succesfull login
        if (userLoginService.verifyLogin(user))
            return "redirect:/posts";
        else
            return "redirect:/users/login1";
    }

    @RequestMapping(value = "/users/registration", method = RequestMethod.POST)
    public String regUser(NewUser newUser) {
        userRegService.registerNewUser(newUser);
        return "redirect:/users/login1";
    }

    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logoutUser(Model model) {
        return "redirect:/";
    }


}
