package pl.project.life_sperience.service;



import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Lvl;
import pl.project.life_sperience.repository.LvlRepository;

import javax.transaction.Transactional;


@Service
@Transactional
public interface LvlService {

    void saveLvl(Lvl lvl);


}
