package pl.project.life_sperience.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lvl")
public class Lvl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long XP_owned;
    private long XP_needed;
    private int lvl_value;
}
