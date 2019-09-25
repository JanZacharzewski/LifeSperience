package pl.project.life_sperience.service;


import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.User;

import javax.transaction.Transactional;


@Transactional
@Service
public interface UserService {

    User findByUserName(String name);


    void saveUser(User user);

}
