package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


    @Getter
    @Setter
    @Entity
    @Table(name = "credit_cards")
    public class CreditCard extends BillingDetail{
        private final static String type = "CREDIT_CARD";

        @Column
        private String cardType;
        @Column
        private Integer expirationMonth;
        @Column
        private Integer expirationYear;

        public CreditCard(){

         }

    public CreditCard(String cardType, Integer expirationMonth, Integer expirationYear) {
        super();
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }
}
