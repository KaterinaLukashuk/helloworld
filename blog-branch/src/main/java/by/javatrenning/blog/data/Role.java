package by.javatrenning.blog.data;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    USER("USER"),  ADMIN("ADMIN");

    String type;
    Role(String type) {
        this.type = type;
    }

    @Override
    public String getAuthority() {
        return name();
    }

    public String getName(){
        return  this.name();
    }
}
