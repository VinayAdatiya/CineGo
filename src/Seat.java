import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Seat {
    private String seatNumber;
    private boolean isBooked;
    private double basePrice;

    public Seat(String seatLabel, double basePrice) {
        this.seatNumber = seatLabel;
        this.isBooked = false;
        this.basePrice = basePrice;
    }

    // Abstract method for calculating price, including taxes
    public abstract double calculatePrice(LocalDate showDate, LocalTime showTime);

    // Abstract method to calculate taxes
    protected abstract double calculateTaxes(double price);

    public abstract String getSeatType();

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
