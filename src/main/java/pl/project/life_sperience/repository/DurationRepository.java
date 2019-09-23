package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.life_sperience.domain.Duration;

public interface DurationRepository extends JpaRepository<Duration, Long> {
}
