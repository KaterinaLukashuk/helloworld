package by.javatrenning.blog.data;


import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    Role role;

    public UserRole() {
    }

    public UserRole(Role role) {
        this.role = role;
    }



    public Integer getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
