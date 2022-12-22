package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column (nullable = false, unique = true)
    private int number;

    @Column
    private String owner;

    @Column
    private String type;

    @ManyToOne
    private User user;

    protected BillingDetail() {
    }


}
