package technicalblog.Model;

import org.springframework.beans.factory.annotation.Autowired;

public class NewUser {
    private String fullName;
    @Autowired
    private User user;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
