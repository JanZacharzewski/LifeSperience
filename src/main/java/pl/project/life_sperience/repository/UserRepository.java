package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.life_sperience.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
