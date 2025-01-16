import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private List<Movie> movieList = new ArrayList<>();
    private List<Show> showList = new ArrayList<>();
    private List<Screen> screenList = new ArrayList<>();

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

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void addMovie(Movie movie){
        movieList.add(movie);
    }

    public void addScreen(Screen screen) {
        screenList.add(screen);
    }

    public void addShow(Show show) {
        showList.add(show);
        Movie movie = show.getMovie();
        movie.addShow(show);
    }
}
