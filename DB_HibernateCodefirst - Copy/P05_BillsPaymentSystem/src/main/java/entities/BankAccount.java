package entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail{
    private final static String type = "BANK_ACCOUNT";

    @Column private String name;
    @Column private String swiftCode;

    public BankAccount(){}

    public BankAccount(int id, int number, String owner, String type,String name, String swiftCode) {
        super();
        this.name = name;
        this.swiftCode = swiftCode;
    }
}
