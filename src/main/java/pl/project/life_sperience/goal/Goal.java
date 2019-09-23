package pl.project.life_sperience.goal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.project.life_sperience.category.Category;
import pl.project.life_sperience.exercise.Repetition;


import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String skills;
    @OneToOne
    private Category category;
    @OneToOne
    private Repetition repetition;
    private Date deadline;
    private long XP_toGet;
}
