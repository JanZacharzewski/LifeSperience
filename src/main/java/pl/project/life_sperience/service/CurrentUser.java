package pl.project.life_sperience.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
public class CurrentUser extends User {
    private final pl.project.life_sperience.domain.User user;
    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.project.life_sperience.domain.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.project.life_sperience.domain.User getUser() {return user;}
}
