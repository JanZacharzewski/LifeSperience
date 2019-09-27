package pl.project.life_sperience.service;


import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Lvl;
import pl.project.life_sperience.domain.User;

import javax.transaction.Transactional;


@Transactional
@Service
public interface UserService {

    User findByUserName(String name);
    Lvl getUserLvl(User user);


    User findByEmail(String email);

    void saveUser(User user);

}
