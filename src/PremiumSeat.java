public class PremiumSeat extends Seat {

    public PremiumSeat(String seatNumber, double price) {
        super(seatNumber,price);
    }

    @Override
    public String getSeatType(){
        return "Premium";
    }
}
