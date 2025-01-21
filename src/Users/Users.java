package Users;

import java.util.Objects;

public abstract class Users {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String customerID;
    private String emailID;
    private String city;
    private int pinCode;

    public Users(String firstName, String lastName, String userName, String password, String customerID, String emailID, String city, int pinCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.customerID = customerID;
        this.emailID = emailID;
        this.city = city;
        this.pinCode = pinCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userName, users.userName) && Objects.equals(emailID, users.emailID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, emailID);
    }
}
