import java.util.ArrayList;
import java.util.List;

public class Theatre {

    static List<Movie> movieList = new ArrayList<>();
    static List<Screen> screenList = new ArrayList<>();

    private String theatreID;
    private String theatreName;
    private String theatreRating;
    private String location;
    private String area;
    private String city;
    private String state;
    private int pinCode;

    public Theatre(String theatreID, String theatreName, String theatreRating, String location, String area, String city, String state, int pinCode) {
        this.theatreID = theatreID;
        this.theatreName = theatreName;
        this.theatreRating = theatreRating;
        this.location = location;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public static List<Movie> getMovieList() {
        return movieList;
    }

    public static List<Screen> getScreenList() {
        return screenList;
    }
}
