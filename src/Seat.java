public abstract class Seat {
    private String seatNumber;
    private boolean isBooked;
    private double price;

    public Seat(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.price = price;
    }

    public abstract String getSeatType();
}
