package pl.project.life_sperience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Lvl;
import pl.project.life_sperience.repository.LvlRepository;
import pl.project.life_sperience.service.LvlService;

import javax.transaction.Transactional;

@Transactional
@Service
public class LvlServiceImpl implements LvlService {



    private final LvlRepository lvlRepository;

    @Autowired
    public LvlServiceImpl(LvlRepository lvlRepository) {
        this.lvlRepository = lvlRepository;
    }

    @Override
    public void saveLvl(Lvl lvl) {
        lvlRepository.save(lvl);
    }
}
