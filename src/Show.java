// File: src/Show.java
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Show {
    private String showID;
    private LocalDate showDate;
    private LocalTime showTime;
    private Movie movie;
    private Screen screen;
    private List<Seat> seats;

    public Show(String showID, LocalDate showDate, LocalTime showTime, Movie movie, Screen screen) {
        this.showID = showID;
        this.showDate = showDate;
        this.showTime = showTime;
        this.movie = movie;
        this.screen = screen;
        this.seats = new ArrayList<>(screen.initializeSeats(screen.getNoOfSeats()));
        Movie.showList.add(this);
    }

    public void displayShowDetails() {
        System.out.println("Show ID: " + showID);
        System.out.println("Date: " + showDate);
        System.out.println("Time: " + showTime);
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Screen: " + screen.getScreenType());
        System.out.println("Available Seats: " + getAvailableSeats());
    }

    public int getAvailableSeats() {
        int count = 0;
        for (int i = 0; i < seats.size(); i++) {
            if (!seats.get(i).isBooked()) {
                count++;
            }
        }
        return count;
    }

    public boolean bookSeat(String seatNumber) {
        for (int i = 0; i < seats.size(); i++) {
            if(seats.get(i).getSeatNumber().equals(seatNumber) && !seats.get(i).isBooked()){
                seats.get(i).setBooked(true);
                return true;
            }
        }
        return false;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void displaySeats() {
        System.out.println("Seats for Show ID: " + showID);
        for (Seat seat : seats) {
            System.out.println("Seat: " + seat.getSeatNumber() + " | Type: " + seat.getSeatType() + " | Booked: " + seat.isBooked());
        }
    }
}