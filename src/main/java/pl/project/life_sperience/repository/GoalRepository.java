package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.life_sperience.domain.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
