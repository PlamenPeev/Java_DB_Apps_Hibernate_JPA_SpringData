package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private Date dateOfBirth;

    @Column
    private String picture;

    @Column
    private Boolean IsMedicalInsurance;

    @OneToMany
    private Set<Diagnose> diagnoses;

    @OneToMany
    private Set<Medicament> medicaments;

    @OneToMany
    private Set<Visitation> visitations;

}
