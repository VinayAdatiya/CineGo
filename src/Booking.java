import java.util.List;

public class Booking {
    private String bookingID;
    private Show show;
    private List<Seat> bookedSeats;
    private double totalPrice;
    private Users user;

    public Booking(String bookingID, Show show, List<Seat> bookedSeats, Users user) {
        this.bookingID = bookingID;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.user = user;
    }
}
