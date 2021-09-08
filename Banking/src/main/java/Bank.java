import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;


    private List<CreditCard> creditCards = new ArrayList<CreditCard>();


    public void setName(String name) {
        this.name = name;
    }
}
