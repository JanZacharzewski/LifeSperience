package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.life_sperience.domain.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
