package pl.project.life_sperience.service;

import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Goal;

import javax.transaction.Transactional;

@Service
@Transactional
public interface GoalService {
    Goal saveGoal(Goal goal);
    Goal deleteGoalById(Integer goalId);
    Goal getById(int goalId);
}
