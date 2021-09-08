import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number;
    private String street;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    private final List<Person> houseHold = new ArrayList<Person>();

    @ManyToMany
    public List<Person> getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(Person p){
        houseHold.add(p);
    }
}
