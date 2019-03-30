package technicalblog.Entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")//Foreign key column , that takes primary key value
    private UserProfileEntity userProfileEntity; //thus user table also gets populated with object data along with Foreign keytable b having foreign key and refers to a. This mean A has B

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfileEntity getUserProfileEntity() {
        return userProfileEntity;
    }

    public void setUserProfileEntity(UserProfileEntity userProfileEntity) {
        this.userProfileEntity = userProfileEntity;
    }
}
