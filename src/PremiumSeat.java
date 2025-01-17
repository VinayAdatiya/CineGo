import java.time.LocalDate;
import java.time.LocalTime;

public class PremiumSeat extends Seat {
    private double vipFees = 50.0;
    private double peakHourCharges = 50.0;

    public PremiumSeat(String seatNumber, double price,double taxRate) {
        super(seatNumber,price,taxRate);
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
    public String getSeatType(){
        return "Premium";
    }
}
