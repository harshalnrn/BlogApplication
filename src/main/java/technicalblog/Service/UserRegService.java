package technicalblog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.Entity.UserEntity;
import technicalblog.Entity.UserProfileEntity;
import technicalblog.Model.User;
import technicalblog.repository.UserRegDao;

@Service
public class UserRegService {

    @Autowired
    UserRegDao userRegDao;

    public void registerNewUser(User user) {

        UserEntity userEntity = new UserEntity();
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        userEntity.setUserProfileEntity(userProfileEntity);
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        userEntity.getUserProfileEntity().setEmailAddress(user.getUserProfile().getEmailAddress());
        userEntity.getUserProfileEntity().setFullName(user.getUserProfile().getFullName());
        userEntity.getUserProfileEntity().setMobileNumber(user.getUserProfile().getMobileNumber());
        userRegDao.registerUser(userEntity);

    }
}

//note if class is not annotated as service, its object wont be available in container