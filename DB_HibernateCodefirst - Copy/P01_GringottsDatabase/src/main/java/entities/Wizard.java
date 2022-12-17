package entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "wizards")
public class Wizard {

    @Id
    private Long id;

    @Column(length = 50)
    private String first_name;

    @Column(length = 60, nullable = false)
    private String last_name;

    @Column(length = 1000)
    private String notes;

    @Column(nullable = false)
    private int age;


    @OneToOne
    private MagicWand magicWand;

    @OneToMany
    private Set<Deposit> deposits;

}
