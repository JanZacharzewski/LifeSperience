package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.project.life_sperience.domain.Goal;
import pl.project.life_sperience.domain.User;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    Goal deleteGoalById(int goalId);

    @Query("select g from Goal g where g.id=?1")
    Goal getGoalById(Integer goalId);

    @Query("select g from Goal g where g.close=false")
    List<Goal> getFinalizeGoal();

    List<Goal> findAllByUser(User user);
}
