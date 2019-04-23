package by.javatrenning.blog.data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "userstbl")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private boolean active;


//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;
//    @OneToOne
//    @CollectionTable(name = "user_role")
//    @JoinColumn(name = "role_id" )
////    @Enumerated(EnumType.STRING)
//    String role = Role.USER.getName();
//    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "role_id")
    UserRole role;

    private  String email;
    private String activationCode;
    private  Date createdAt;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

      //  ArrayList<Role> roles = new ArrayList<Role>();
        Set<Role> roles= new HashSet<>();
        roles.add(Role.USER);
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    @Override
    public String toString() {

        return username + " " + "e-mail: "+  email ;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
