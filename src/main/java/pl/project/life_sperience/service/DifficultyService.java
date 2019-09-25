package pl.project.life_sperience.service;

import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Difficulty;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public interface DifficultyService {
    List<Difficulty> findAllDifficulties();
}
