package entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "deposits")
public class Deposit{

    @Id
    private Long id;

    @Column(length = 20)
    private String group;

    @Column
    private LocalDate startDate;

    @Column
    private Double amount;

    @Column
    private Double interest;

    @Column
    private Double charge;

    @Column
    private LocalDate expirationDate;

    @Column
    private boolean isExpired;

    @ManyToOne
    private Wizard wizards;
}
