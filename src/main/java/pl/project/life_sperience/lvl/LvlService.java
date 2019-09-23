package pl.project.life_sperience.lvl;



import org.springframework.stereotype.Service;

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
