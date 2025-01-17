import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Seat {
    private String seatNumber;
    private boolean isBooked;
    private double basePrice;
    private double taxRate;

    public Seat(String seatLabel, double basePrice,double taxRate) {
        this.seatNumber = seatLabel;
        this.isBooked = false;
        this.basePrice = basePrice;
        this.taxRate = taxRate;
    }

    // Abstract method for calculating price, including taxes
    public abstract double calculatePrice(LocalDate showDate, LocalTime showTime);

    // Abstract method to calculate taxes
    protected double calculateTaxes(double price){
        return price * taxRate;
    }

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
