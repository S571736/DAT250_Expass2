import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {
    private static final String PERSISTANCE_UNIT_NAME = "banking";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTANCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("select p from Person p");
        List<Person> personList = q.getResultList();
        for (Person p :personList){
            System.out.println(p);
        }

        System.out.println("Size: " + personList.size());

        em.getTransaction().begin();
        Person p = new Person();
        p.setName("Max Mustermann");

        Address address = new Address();
        address.setNumber(28);
        address.setStreet("Inndalsveien");
        p.setAddresses(address);
        em.persist(address);

        CreditCard cc1 = new CreditCard();
        CreditCard cc2 = new CreditCard();

        cc1.setBalance(-5000);
        cc2.setBalance(1);
        cc1.setNumber(12345);
        cc2.setNumber(123);
        cc1.setLimit(-10000);
        cc2.setLimit(2000);

        Pincode pin = new Pincode();
        pin.setCount(1);
        pin.setPincode("123");
        em.persist(pin);


        cc1.setPin(pin);
        cc2.setPin(pin);
        em.persist(cc1);
        em.persist(cc2);


        Bank bank = new Bank();
        bank.setName("Pengebank");
        em.persist(bank);


        p.setPersonCreditCards(cc1);
        p.setPersonCreditCards(cc2);

        em.persist(p);


        em.getTransaction().commit();

        em.close();



    }

}
