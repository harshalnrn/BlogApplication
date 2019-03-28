package technicalblog.Service;

import org.springframework.stereotype.Service;
import technicalblog.Model.User;

@Service
public class UserLoginService {

    //please validate here, if login is succesfull or not, and based on that navigate user to appropriate view
    public boolean verifyLogin(User user) {
        boolean loginFlag = true;
        System.out.println("username:" + user.getUsername());
        System.out.println("password:" + user.getPassword());


        if (user.getUsername().equals("inactive")) {
            loginFlag = false;
        }

        System.out.println(loginFlag);
        return loginFlag;

    }
}