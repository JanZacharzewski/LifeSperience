package pl.project.life_sperience.service;



import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Lvl;
import pl.project.life_sperience.repository.LvlRepository;

import javax.transaction.Transactional;


@Service
@Transactional
public class LvlService {

    private final LvlRepository lvlRepository;

    public LvlService(LvlRepository lvlRepository) {
        this.lvlRepository = lvlRepository;
    }

    public Lvl getLvl(Integer id) {
        return lvlRepository.findById(id).orElse(null);
    }
}
