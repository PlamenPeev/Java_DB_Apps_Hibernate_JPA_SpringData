package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column
        private String name;

        @Column
        private String email;

        @Column
        private String creditCardNumber;


        @OneToMany(mappedBy = "customer")
        private Set<Sale> sales;

        public Customer() {
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getCreditCardNumber() {
                return creditCardNumber;
        }

        public void setCreditCardNumber(String creditCardNumber) {
                this.creditCardNumber = creditCardNumber;
        }

        public Set<Sale> getSales() {
                return sales;
        }

        public void setSales(Set<Sale> sales) {
                this.sales = sales;
        }
}

