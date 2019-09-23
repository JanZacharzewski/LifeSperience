package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.life_sperience.domain.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
