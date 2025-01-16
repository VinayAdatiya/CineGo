import java.util.ArrayList;
import java.util.List;

public class Customer extends Users {
    private List<Booking> ticketList;

    public Customer(String firstName, String lastName, String userName, String password, String customerID, String emailID, String city, int pinCode) {
        super(firstName, lastName, userName, password, customerID, emailID, city, pinCode);
        this.ticketList = new ArrayList<>();
    }

    public void getShowDetails(Movie interstellarMovie){
        System.out.println("\n----------Show Details----------");
        System.out.println("  ShowID  ||  Date  ||  Time  ||  Title");
        for (int i = 0; i < interstellarMovie.getShowList().size(); i++) {
            System.out.println("  "+interstellarMovie.getShowList().get(i).getShowID() +" ||  "+interstellarMovie.getShowList().get(i).getShowDate() +"  ||  "+ interstellarMovie.getShowList().get(i).getShowTime() +"  ||  "+ interstellarMovie.getShowList().get(i).getMovie().getTitle());
        }
    }

    public void bookingPreview(Show show , List<String> seats){
        show.bookingPreview(show,seats);
    }

    public void bookTicket(Show show,List<String> seats){
        show.bookTicket(show,seats,this);
    }

    public void showAvailableSeats(Show show){
        System.out.println("\n----------Available Seats----------");
        System.out.println("Total Available Seats for "+show.getShowID()+ ":-"+show.getAvailableSeats());
        show.displaySeats();
    }

    public void addTicket(Booking ticket){
        this.ticketList.add(ticket);
    }

    public void getTicketDetails() {
        for(Booking ticket:ticketList){
            System.out.println("\n----------Ticket Details----------");
            System.out.println("Booking ID :- "+ticket.getBookingID());
            System.out.println("Show Details :- ");
            ticket.getShow().displayShowDetails();
            System.out.println("Seats :- "+ticket.getBookedSeats());
            System.out.println("Grand Total :- "+ ticket.getTotalPrice());
        }
    }
}
