package pl.project.life_sperience.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query ("select c from Category c where c.parent_id=0")
    List<Category> findAllCategories();

    @Query ("select c from Category c where c.parent_id > 0")
    List<Category> findAllSubCategories();

    @Query("select c from Category c where c.parent_id = ?1")
    List<Category> FindAllCategoryByParentId(int parentId);

}
