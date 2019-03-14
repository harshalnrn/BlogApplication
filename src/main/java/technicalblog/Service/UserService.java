package technicalblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.Model.User;

@Service
public class UserService {

public void verifyLogin(User user){
 System.out.println("username:"+user.getUsername());
    System.out.println("password:"+user.getPassword());

}
}
