package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.life_sperience.domain.Lvl;
@Repository
public interface LvlRepository extends JpaRepository<Lvl, Integer> {
}
