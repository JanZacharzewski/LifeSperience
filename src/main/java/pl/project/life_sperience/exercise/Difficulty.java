package pl.project.life_sperience.exercise;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parameters")
public class Difficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String difficulty;
    
}