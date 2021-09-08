import javax.persistence.*;

import lombok.Data;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int number;
    private int limit;
    private int balance;


    private Person person;


    private Bank bank;



    private Pincode pin;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ManyToOne
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @ManyToOne
    public Pincode getPin() {
        return pin;
    }

    public void setPin(Pincode pin) {
        this.pin = pin;
    }

    @ManyToOne(optional = false)
    private Person people;

    public Person getPeople() {
        return people;
    }

    public void setPeople(Person people) {
        this.people = people;
    }
}
