package pl.project.life_sperience.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.lang.Nullable;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"name"})}, name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @Nullable
    private int parent_id;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    List<Exercise> exercises;
}
