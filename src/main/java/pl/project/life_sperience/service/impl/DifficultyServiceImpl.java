package pl.project.life_sperience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Difficulty;
import pl.project.life_sperience.repository.DifficultyRepository;
import pl.project.life_sperience.service.DifficultyService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class DifficultyServiceImpl implements DifficultyService {


    private final DifficultyRepository difficultyRepository;

    @Autowired
    public DifficultyServiceImpl(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    @Override
    public List<Difficulty> findAllDifficulties() {
        return difficultyRepository.findAll();
    }
}
