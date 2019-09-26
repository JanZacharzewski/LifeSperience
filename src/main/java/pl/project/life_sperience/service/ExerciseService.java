package pl.project.life_sperience.service;

import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Exercise;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ExerciseService {
    void saveExercise(Exercise exercise);
    List<Exercise> findAllExercises();
    Exercise getExerciseById(int id);
}
