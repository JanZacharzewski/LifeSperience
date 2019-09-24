package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.project.life_sperience.domain.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query ("select c from Category c where c.parent_id=0")
    List<Category> findAllCategories();

    @Query ("select c from Category c where c.parent_id > 0")
    List<Category> findAllSubCategories();

    @Query("select c from Category c where c.parent_id = 0")
    List<Category> FindAllCategory();

    Category findByName(String name);

}
