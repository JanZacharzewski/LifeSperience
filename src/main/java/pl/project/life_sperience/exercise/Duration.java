package pl.project.life_sperience.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "duration")
public class Duration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long minutes;
    private long hours;
    private long days;
    private long weeks;
    private long months;
}
