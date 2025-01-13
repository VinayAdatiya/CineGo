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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
