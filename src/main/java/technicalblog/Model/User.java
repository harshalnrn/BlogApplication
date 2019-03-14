package technicalblog.Model;


//note the naming rules when it comes to rendering a model in view
public class User {

    private String username1;
    private String password1;

    public String getUsername() {
        return username1;
    }

    public void setUsername(String username) {
        this.username1 = username;
    }

    public String getPassword() {
        return password1;
    }

    public void setPassword(String password) {
        this.password1 = password;
    }
}
