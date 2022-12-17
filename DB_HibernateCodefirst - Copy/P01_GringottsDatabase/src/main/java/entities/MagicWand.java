package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "magic_wands")
public class MagicWand {
    @Id
    private Long id;

    @OneToOne
    private Wizard creator;

    @Column
    private Long size;

     @OneToMany
     private Set<Wizard> wizards;
}
