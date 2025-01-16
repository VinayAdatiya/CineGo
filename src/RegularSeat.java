import java.time.LocalDate;
import java.time.LocalTime;

public class RegularSeat extends Seat {
    private final double taxRate = 0.05;

    public RegularSeat(String seatNumber, double price) {
        super(seatNumber, price);
    }

    @Override
    public double calculatePrice(LocalDate showDate, LocalTime showTime) {
        double price = getBasePrice();

        // Weekend Charges
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
        return "Regular";
    }
}
