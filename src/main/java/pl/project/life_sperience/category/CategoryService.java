package pl.project.life_sperience.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(Category category){
       categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List getAllCategories() {
        return categoryRepository.findAllCategories();
    }

    public List getAllSubCategoriesByParent(int parentId){
        return categoryRepository.FindAllCategoryByParentId(parentId);
    }
}
