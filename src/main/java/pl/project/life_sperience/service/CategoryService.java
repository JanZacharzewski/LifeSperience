package pl.project.life_sperience.service;

import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Category;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CategoryService {

    void saveCategory(Category category);

    boolean isCategoryNameUnique(String name);

    List <Category> findAllCategories();
    List<Category> findAllSubCategories();
    Category findCategory(int category_id);
    int findParentId();
    Category findById(int id);
}
