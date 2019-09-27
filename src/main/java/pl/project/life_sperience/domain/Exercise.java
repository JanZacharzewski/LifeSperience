
package pl.project.life_sperience.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long EXP_to_gain;
    @ManyToOne
    private Difficulty difficulty;
    @ManyToOne
    private Category category;
    private String name_exp;

    public String getName_exp() {
        return name + "(" + String.valueOf(EXP_to_gain)+" XP)";
    }
}
