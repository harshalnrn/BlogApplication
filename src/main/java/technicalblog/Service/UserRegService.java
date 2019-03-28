package technicalblog.Service;

import org.springframework.stereotype.Service;
import technicalblog.Model.NewUser;

@Service
public class UserRegService {

    public void registerNewUser(NewUser newUser) {

        System.out.println("new user registration details are as follows:");
        System.out.println("full name" + newUser.getFullName());
        System.out.println("username" + newUser.getUser().getUsername());
        System.out.println("password" + newUser.getUser().getPassword());


    }
}

//note if class is not annotated as service, its object wont be available in container