package pl.project.life_sperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.project.life_sperience.domain.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c where c.parent_id=0")
    List<Category> findAllCategories();

    @Query("select c from Category c where c.parent_id > 0")
    List<Category> findAllSubCategories();

    @Query("select  c from Category c where c.id = ?1")
    Category findCategory(int category_id);

    @Query("select c from Category c where c.id=?1 and c.parent_id > 0")
            Category findById(int id);

    Category findByName(String name);

}
