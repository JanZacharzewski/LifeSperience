package pl.project.life_sperience.service;


import pl.project.life_sperience.domain.User;






public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

}
