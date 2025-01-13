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
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Date: " + showDate);
        System.out.println("Time: " + showTime);
        System.out.println("Screen: " + screen.getScreenType());
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

    public double bookSeat(List<String> seatNumbers) {
        double totalPrice = 0;
        for (int i = 0; i < seatNumbers.size(); i++) {
            for (int j = 0; j < seats.size(); j++) {
                if (seats.get(j).getSeatNumber().equals(seatNumbers.get(i)) && !seats.get(j).isBooked()) {
                    seats.get(j).setBooked(true);
                    totalPrice = totalPrice + seats.get(j).getPrice();
                }
            }
        }
        return totalPrice;
    }

    public void displaySeats() {
        System.out.println("Seats for Show ID: " + showID);
        for (Seat seat : seats) {
            System.out.println("Seat: " + seat.getSeatNumber() + " | Type: " + seat.getSeatType() + " | Booked: " + seat.isBooked());
        }
    }

    public String getShowID() {
        return showID;
    }

    public void setShowID(String showID) {
        this.showID = showID;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}