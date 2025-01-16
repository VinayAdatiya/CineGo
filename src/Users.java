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
}
