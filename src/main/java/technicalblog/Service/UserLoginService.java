package technicalblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.Model.User;
import technicalblog.repository.UserLoginDao;

@Service
public class UserLoginService {
    @Autowired
    UserLoginDao userLoginDao;

    //please validate here, if login is succesfull or not, and based on that navigate user to appropriate view
    public boolean verifyLogin(User user) {
        boolean loginFlag = true;
        loginFlag = userLoginDao.checkLogin(user);
        return loginFlag;

    }
}