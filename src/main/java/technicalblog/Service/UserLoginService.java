package technicalblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.Entity.UserEntity;
import technicalblog.Model.User;
import technicalblog.Model.UserProfile;
import technicalblog.repository.UserLoginDao;

@Service
public class UserLoginService {
    @Autowired
    UserLoginDao userLoginDao;

    //please validate here, if login is succesfull or not, and based on that navigate user to appropriate view
    public User verifyLogin(User user) {
        UserProfile userProfile = null;
        User user1 = null;
        UserEntity userEntity = userLoginDao.checkLogin(user);
        if (userEntity != null) {
            userProfile = new UserProfile();
            user1 = new User();
            user1.setUserProfile(userProfile);
            user1.setUsername(userEntity.getUsername());
            user1.setPassword(userEntity.getPassword());
            user1.getUserProfile().setFullName(userEntity.getUserProfileEntity().getFullName());
            user1.getUserProfile().setEmailAddress(userEntity.getUserProfileEntity().getEmailAddress());
            user1.getUserProfile().setMobileNumber(userEntity.getUserProfileEntity().getMobileNumber());
            user1.setUser_id(userEntity.getId());
        }
        return user1;
    }
}