import java.util.ArrayList;
import java.util.List;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    // get all movies detail
    public void getAllMovies(){
        List<Movie> movies = Theatre.getMovieList();
        System.out.println("-------------------------------------------------------");
        System.out.println("Movie ID | Title | Duration | Genre | Rating | Language");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println("-------------------------------------------------------");
            System.out.println(movies.get(i).getMovieID()+" | "+movies.get(i).getTitle()+" | "+movies.get(i).getDuration()+" | "+movies.get(i).getGenre() +" | "+movies.get(i).getRating()+" | "+movies.get(i).getLanguage());
        }
        System.out.println("-------------------------------------------------------");
    }
}
