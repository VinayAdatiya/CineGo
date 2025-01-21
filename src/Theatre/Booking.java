package Theatre;

import java.util.List;

public class Booking {

    private String bookingID;
    private Show show;
    private List<String> bookedSeats;
    private double totalPrice;

    public Booking(String bookingID, Show show, List<String> bookedSeats,  double totalPrice) {
        this.bookingID = bookingID;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.totalPrice = totalPrice;
    }

    public String getBookingID() {
        return bookingID;
    }

    public Show getShow() {
        return show;
    }

    public List<String> getBookedSeats() {
        return bookedSeats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
