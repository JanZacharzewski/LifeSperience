package pl.project.life_sperience.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"username", "email"})}, name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String username;
    @NotBlank
    private String password;
    private boolean enabled=true;
    @NotBlank
    @Column(unique = true)
    private String email;
    @OneToOne
    private Lvl lvl;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private List <Goal> goals;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Transient
    private List<Goal> activeGoals;
    public List<Goal> getActiveGoals(){
        if(goals!=null){
            return goals.stream().filter(item-> !item.isClose()).collect(Collectors.toList());
        }
        return null;
    }
}
