package pl.project.life_sperience.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Category category;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;
    @ManyToOne
    private User user;
    private long xp_to_get;
    @ManyToMany
    private List<Exercise> exercises;
    private boolean close = false;
}
