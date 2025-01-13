import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Users {
    static List<Customer> customerList = new ArrayList<>();

    public Customer(String firstName, String lastName, String userName, String password, String customerID, String emailID, String city, int pinCode) {
        super(firstName, lastName, userName, password, customerID, emailID, city, pinCode);
        customerList.add(this);
    }

    public static Customer customerLogin(String userName, String password) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getUserName().equals(userName) && customerList.get(i).getPassword().equals(password)) {
                return customerList.get(i);
            }
        }
        return null;
    }

    public void getShowDetails(){
        List<Show> show = Movie.showList;
        System.out.println("  ShowID  ||  Date  ||  Time  ||  Title");
        for (int i = 0; i < Movie.showList.size(); i++) {
            System.out.println("  "+show.get(i).getShowID() +" ||  "+show.get(i).getShowDate() +"  ||  "+ show.get(i).getShowTime() +"  ||  "+ show.get(i).getMovie().getTitle());
        }
    }

    public Booking bookTicket(Show show,List<String> seats){
        double totalPrice = show.bookSeat(seats);
        Booking book = new Booking("BK001",show,seats,this ,totalPrice);
        return book;
    }

    public void showAvailableSeats(Show show){
        System.out.println("----------Available Seats----------");
        System.out.println("Total Available Seats :- "+show.getAvailableSeats());
        show.displaySeats();
    }

    public void getTicketDetails(Booking ticket1) {
        System.out.println("----------Booking Details----------");
        System.out.println("Booking ID :- "+ticket1.getBookingID());
        System.out.println("Show Details :- ");
        ticket1.getShow().displayShowDetails();
        System.out.println("Seats :- "+ticket1.getBookedSeats());
        System.out.println("Grand Total :- "+ ticket1.getTotalPrice());
    }
}
