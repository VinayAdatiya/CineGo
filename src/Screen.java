import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String screenID;
    private int screenNumber;
    private List<Show> shows;
    private String screenType;
    private int noOfSeats;
    List<Seat> seats= new ArrayList<>();

    public Screen(String screenID, int screenNumber , String screenType , int noOfSeats) {
        this.screenID = screenID;
        this.screenNumber = screenNumber;
        this.screenType = screenType;
        this.shows = new ArrayList<>();
        this.seats = initializeSeats(noOfSeats);
        Theatre.screenList.add(this);
    }

    public List<Seat> initializeSeats(int noOfSeats){
        List<Seat> seats = new ArrayList<>();
        int vipSeats = (int) (noOfSeats * 0.2); // 20% VIP seats
        for (int i = 1; i <= noOfSeats; i++) {
            if (i <= vipSeats) {
                seats.add(new PremiumSeat("A" + i, 300.0));
            } else {
                seats.add(new RegularSeat("B" + i, 200.0));
            }
        }
        return seats;
    }
}
