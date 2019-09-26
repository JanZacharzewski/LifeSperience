package pl.project.life_sperience.service.impl;

import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Goal;
import pl.project.life_sperience.repository.GoalRepository;
import pl.project.life_sperience.service.GoalService;

import javax.transaction.Transactional;

@Service
@Transactional
public class GoalServiceImpl implements GoalService {

    private final
    GoalRepository goalRepository;

    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public Goal deleteGoalById(Integer goalId) {
        return goalRepository.deleteGoalById(goalId);
    }

    @Override
    public Goal getById(int goalId) {
        return goalRepository.getGoalById(goalId);
    }
}
