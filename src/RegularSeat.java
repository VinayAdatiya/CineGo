public class RegularSeat extends Seat {
    public RegularSeat(String seatNumber, double price) {
        super(seatNumber, price);
    }
    @Override
    public String getSeatType(){
        return "Regular";
    }
}
