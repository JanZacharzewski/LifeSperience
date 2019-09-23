package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.life_sperience.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
