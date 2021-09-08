import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;


    private final List<Address> addresses = new ArrayList<Address>();



    private List<CreditCard> personCreditCards = new ArrayList<CreditCard>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "address")
    public List<Address> getAddresses() {
        return addresses;
    }

    @OneToMany(mappedBy = "address")
    public List<CreditCard> getPersonCreditCards() {
        return personCreditCards;
    }

    public void setPersonCreditCards(CreditCard personCreditCards) {
        this.personCreditCards.add(personCreditCards);
    }

    public void setAddresses(Address ad){
        addresses.add(ad);
    }



}
