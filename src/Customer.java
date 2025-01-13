import java.util.ArrayList;
import java.util.List;

public class Customer extends Users {
    static List<Customer> customerList = new ArrayList<>();

    public Customer(String firstName, String lastName, String userName, String password, String customerID, String emailID, String city, int pinCode) {
        super(firstName, lastName, userName, password, customerID, emailID, city, pinCode);
    }

}
