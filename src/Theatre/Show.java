package Theatre;

import Exceptions.SeatAlreadyOccupiedException;
import Exceptions.SeatNotFoundException;
import Users.Customer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return showID.equals(show.showID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showID);
    }

    public void displayShowDetails() {
        System.out.println("    Theatre.Show ID: " + showID);
        System.out.println("    Theatre.Movie: " + movie.getTitle());
        System.out.println("    Date: " + showDate);
        System.out.println("    Time: " + showTime);
        System.out.println("    Theatre.Screen No: " + screen.getScreenID());
        System.out.println("    Theatre.Screen: " + screen.getScreenType());
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

    public void displaySeats() {
        System.out.println("Seats for Theatre.Show ID: " + showID);
        for (Seat seat : seats) {
            System.out.println("Theatre.Seat: " + seat.getSeatNumber() + " | Type: " + seat.getSeatType() + " | Booked: " + seat.isBooked());
        }
    }

    public void bookingPreview(Show show , List<String> seats) throws SeatNotFoundException , SeatAlreadyOccupiedException{
        System.out.println("\n----------Theatre.Booking Preview----------");
        double totalPrice = 0;
        double totalTax = 0;
        List<String> alreadyBookedSeats = new ArrayList<>();

        System.out.println("Theatre.Seat || Base Price || Tax Amount || Total Price");
        System.out.println("----------------------------------------------");

        for (String seatLabel : seats) {
            boolean seatFound = false;
            for (Seat seat : show.getSeats()) {
                if (seat.getSeatNumber().equals(seatLabel)) {
                    seatFound = true;
                    if (seat.isBooked()) {
                        alreadyBookedSeats.add(seatLabel);
                    } else {
                        double seatPrice = seat.calculatePrice(show.getShowDate(), show.getShowTime());
                        double taxAmount = seat.calculateTaxes(seatPrice);
                        double totalSeatPrice = seatPrice + taxAmount;

                        totalPrice += seatPrice;
                        totalTax += taxAmount;

                        System.out.println(seat.getSeatNumber()+" || "+seatPrice+" || "+taxAmount+" || "+totalSeatPrice);
                    }
                    break;
                }
            }
            if (!seatFound) {
                throw new SeatNotFoundException("Theatre.Seat " + seatLabel + " not found in the system.");
            }
        }

        System.out.println("----------------------------------------------");
        System.out.println("Grand Total :- "+ (totalPrice + totalTax));

        if (!alreadyBookedSeats.isEmpty()) {
            throw new SeatAlreadyOccupiedException("The following seats are already booked: " + String.join(", ", alreadyBookedSeats));
        }
    }

    public void bookTicket(Show show, List<String> seats, Customer customer) throws SeatAlreadyOccupiedException, SeatNotFoundException {
        Random random = new Random();
        System.out.println("\n----------Theatre.Booking Details----------");
        double totalPrice = 0;
        double totalTax = 0;
        List<String> alreadyBookedSeats = new ArrayList<>();

        System.out.println("Theatre.Seat || Base Price || Tax Amount || Total Price");
        System.out.println("----------------------------------------------");

        for (String seatLabel : seats) {
            boolean seatFound = false;
            for (Seat seat : show.getSeats()) {
                if (seat.getSeatNumber().equals(seatLabel)) {
                    seatFound = true;
                    if (seat.isBooked()) {
                        alreadyBookedSeats.add(seatLabel);
                    } else {
                        double seatPrice = seat.calculatePrice(show.getShowDate(), show.getShowTime());
                        double taxAmount = seat.calculateTaxes(seatPrice);
                        double totalSeatPrice = seatPrice + taxAmount;

                        seat.setBooked(true);
                        totalPrice += seatPrice;
                        totalTax += taxAmount;

                        System.out.println(seat.getSeatNumber()+" || "+seatPrice+" || "+taxAmount+" || "+totalSeatPrice);
                    }
                    break;
                }
            }
            if (!seatFound) {
                throw new SeatNotFoundException("Theatre.Seat " + seatLabel + " not found in the system.");
            }
        }

        System.out.println("----------------------------------------------");
        System.out.println("Grand Total :- "+ (totalPrice + totalTax));

        if (!alreadyBookedSeats.isEmpty()) {
            throw new SeatAlreadyOccupiedException("The following seats are already booked: " + String.join(", ", alreadyBookedSeats));
        }
        Booking ticket = new Booking("BK"+random.nextInt(5000),show,seats ,totalPrice + totalTax);
        customer.addTicket(ticket);
    }

    public String getShowID() {
        return showID;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}