package Theatre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Screen {
    private String screenID;
    private int screenNumber;
    private List<Show> shows;
    private String screenType;
    private int noOfSeats;
    private List<Seat> seats;

    public Screen(String screenID, int screenNumber , String screenType , int noOfSeats) {
        this.screenID = screenID;
        this.screenNumber = screenNumber;
        this.screenType = screenType;
        this.shows = new ArrayList<>();
        this.noOfSeats = noOfSeats;
        this.seats = initializeSeats(noOfSeats);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screen screen = (Screen) o;
        return screenID.equals(screen.screenID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screenID);
    }

    public List<Seat> initializeSeats(int noOfSeats){
        List<Seat> seats = new ArrayList<>();
        int vipSeats = (int) (noOfSeats * 0.2); // 20% VIP seats
        for (int i = 1; i <= noOfSeats; i++) {
            if (i <= vipSeats) {
                seats.add(new PremiumSeat("A" + i, 300.0 , 0.12));
            } else {
                seats.add(new RegularSeat("B" + i, 200.0 , 0.05));
            }
        }
        return seats;
    }

    public String getScreenID() {
        return screenID;
    }

    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
