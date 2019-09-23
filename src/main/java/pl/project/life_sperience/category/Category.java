package pl.project.life_sperience.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import pl.project.life_sperience.exercise.Exercise;


import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Nullable
    private int parent_id;
    @OneToMany
    List<Exercise> exercises;
}
