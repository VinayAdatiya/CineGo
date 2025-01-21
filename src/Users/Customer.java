package Users;

import Exceptions.SeatAlreadyOccupiedException;
import Exceptions.SeatNotFoundException;
import Exceptions.ShowNotAvailableException;
import Theatre.Booking;
import Theatre.Movie;
import Theatre.Show;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Users {
    private List<Booking> ticketList;

    public Customer(String firstName, String lastName, String userName, String password, String customerID, String emailID, String city, int pinCode) {
        super(firstName, lastName, userName, password, customerID, emailID, city, pinCode);
        this.ticketList = new ArrayList<>();
    }



    public void getShowDetails(Movie movie) throws ShowNotAvailableException {
        if(movie.getShowList().size() == 0){
            throw new ShowNotAvailableException("Currently no show available for "+movie.getTitle()+ "movie");
        }
        System.out.println("\n----------Theatre.Show Details----------");
        System.out.println("  ShowID  ||  Date  ||  Time  ||  Title");
        for (int i = 0; i < movie.getShowList().size(); i++) {
            System.out.println("  "+movie.getShowList().get(i).getShowID() +" ||  "+movie.getShowList().get(i).getShowDate() +"  ||  "+ movie.getShowList().get(i).getShowTime() +"  ||  "+ movie.getShowList().get(i).getMovie().getTitle());
        }
    }

    public void bookingPreview(Show show , List<String> seats) throws SeatNotFoundException,SeatAlreadyOccupiedException {
        show.bookingPreview(show,seats);
    }

    public void bookTicket(Show show, List<String> seats)  throws SeatNotFoundException,SeatAlreadyOccupiedException {
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
            System.out.println("Theatre.Booking ID :- "+ticket.getBookingID());
            System.out.println("Theatre.Show Details :- ");
            ticket.getShow().displayShowDetails();
            System.out.println("Seats :- "+ticket.getBookedSeats());
            System.out.println("Grand Total :- "+ ticket.getTotalPrice());
        }
    }
}
