package pl.project.life_sperience.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.life_sperience.domain.Category;
import pl.project.life_sperience.repository.CategoryRepository;
import pl.project.life_sperience.service.CategoryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean isCategoryNameUnique(String name) {
        return categoryRepository.findByName(name) == null;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAllCategories();
    }

}
