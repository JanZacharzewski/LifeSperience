package pl.project.life_sperience.service;

import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Exercise;

import javax.transaction.Transactional;

@Service
@Transactional
public interface ExerciseService {
    void saveExercise(Exercise exercise);
}
