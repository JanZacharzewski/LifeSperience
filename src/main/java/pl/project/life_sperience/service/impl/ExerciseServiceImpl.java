package pl.project.life_sperience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Exercise;
import pl.project.life_sperience.repository.ExerciseRepository;
import pl.project.life_sperience.service.ExerciseService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void saveExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }
}
