package pl.project.life_sperience.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.project.life_sperience.goal.Goal;
import pl.project.life_sperience.lvl.Lvl;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    @Column(unique = true)
    private String email;
    @OneToOne
    private Lvl lvl;
    @OneToMany
    private List <Goal> goals;
}
