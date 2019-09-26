package pl.project.life_sperience.service;

import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Goal;
import pl.project.life_sperience.domain.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface GoalService {
    List<Goal> findAllByUser(User user);
    Goal saveGoal(Goal goal);
    Goal deleteGoalById(Integer goalId);
    Goal getById(int goalId);
    void delete(Goal goal);
    void close(User user, Goal goal);
}
