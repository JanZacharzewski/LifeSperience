package pl.project.life_sperience.service.impl;

import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Goal;
import pl.project.life_sperience.domain.User;
import pl.project.life_sperience.repository.GoalRepository;
import pl.project.life_sperience.service.GoalService;

import javax.transaction.Transactional;
import java.util.List;

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
        goal.setXp_to_get(goal.getExercises().stream()
                .mapToLong(item->item.getEXP_to_gain()).sum());
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
    @Override
    public void delete(Goal goal){
         goalRepository.delete(goal);
    }
    @Override
    public void close(User user,Goal goal){
        if(goal.getUser().getId().equals(user.getId())) {
            goal.setClose(true);
            goalRepository.save(goal);
        }else{
            //todo exception
        }
    }
    @Override
    public List<Goal> findAllByUser(User user){
        return goalRepository.findAllByUser(user);
    }
}
