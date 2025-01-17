import java.time.LocalDate;
import java.time.LocalTime;

public class RegularSeat extends Seat {

    public RegularSeat(String seatNumber, double price,double taxRate) {
        super(seatNumber, price ,taxRate);
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
    public String getSeatType(){
        return "Regular";
    }
}
