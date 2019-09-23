package pl.project.life_sperience.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
