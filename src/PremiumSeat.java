import java.time.LocalDate;
import java.time.LocalTime;

public class PremiumSeat extends Seat {
    private final double taxRate = 0.12;
    private double vipFees = 50.0;
    private double peakHourCharges = 50.0;

    public PremiumSeat(String seatNumber, double price) {
        super(seatNumber,price);
    }

    @Override
    public double calculatePrice(LocalDate showDate, LocalTime showTime) {
        double price = getBasePrice() + vipFees;

        //After 6 PM Extra Charges
        if (showTime.isAfter(LocalTime.of(18, 0))) {
            price += peakHourCharges;
        }

        //On Weekends Extra Charges
        if (showDate.getDayOfWeek().getValue() >= 6) {
            price += 100.0;
        }
        return price;
    }

    @Override
    protected double calculateTaxes(double price) {
        return price * taxRate;
    }

    @Override
    public String getSeatType(){
        return "Premium";
    }
}
