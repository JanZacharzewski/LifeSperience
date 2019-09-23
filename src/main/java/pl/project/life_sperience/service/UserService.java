package pl.project.life_sperience.service;

import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.User;
import pl.project.life_sperience.repository.UserRepository;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void saveUser(User user){
        userRepository.save(user);
    }
}
