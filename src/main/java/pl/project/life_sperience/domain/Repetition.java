package pl.project.life_sperience.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repetitions")
public class Repetition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String choice;
}
